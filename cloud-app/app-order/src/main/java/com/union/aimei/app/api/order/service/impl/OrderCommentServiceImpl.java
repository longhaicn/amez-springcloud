package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.common.HttpStatusConstant;
import com.union.aimei.common.constant.order.OrderConstant;
import com.union.aimei.common.constant.store.BeauticianGrowthRuleEnum;
import com.union.aimei.common.feign.app.store.GrowthRuleFeign;
import com.union.aimei.common.model.order.*;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.aimei.common.vo.order.OrderSendAppVo;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.app.api.order.async.CustomerOrderCommentTask;
import com.union.aimei.app.api.order.mapper.*;
import com.union.aimei.app.api.order.service.OrderCommentService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.exception.ServerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:54
  * @description
  */
@Service("orderCommentService")
public class OrderCommentServiceImpl implements OrderCommentService {
    @Resource
    private OrderBaseMapper orderBaseMapper;
    @Resource
    private OrderCommentMapper orderCommentMapper;
    @Resource
    private OrderCommentImgMapper orderCommentImgMapper;
    @Resource
    private OrderProductMapper orderProductMapper;
    @Resource
    private CustomerOrderCommentTask customerOrderCommentTask;
    @Resource
    private GrowthRuleFeign growthRuleFeign;
    @Resource
    private OrderBeauticianMapper orderBeauticianMapper;

    /**
     * 前端分页查询订单评论
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderComment> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment) {
        PageInfo<OrderComment> page = getPage(pageNo, pageSize, orderComment);
        return page;
    }

    private PageInfo<OrderComment> getPage(Integer pageNo, Integer pageSize, OrderComment orderComment){
        PageHelper.startPage(pageNo, pageSize);
        PageHelper.orderBy("create_time DESC");
        List<OrderComment> list = this.orderCommentMapper.selectListByConditions(orderComment);
        PageInfo<OrderComment> page = new PageInfo<>(list);
        if (!CollectionUtils.isEmpty(page.getList())){
            for(OrderComment comment:page.getList()){
                List<String> imgList = orderCommentMapper.queryOrderCommentImgList(comment.getId());
                if (!CollectionUtils.isEmpty(imgList)) {
                    comment.setOrderCommentImgList(imgList);
                }
            }
        }
        return page;
    }


    @Override
    public ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(Integer pageNo, Integer pageSize, int beauticianId) {
        ResponseMessage<PageInfo<OrderCommentAllVo>> res=new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<OrderCommentAllVo> orderCommentAllVo=new ArrayList<>(10);
        PageHelper.orderBy("oct.create_time DESC");
        List<OrderComment> list = this.orderCommentMapper.queryByBeauticianId(beauticianId);
        if(!CollectionUtils.isEmpty(list)){
            for (OrderComment comment:list){
                OrderCommentAllVo vo=new OrderCommentAllVo();
                vo.setOrderComment(comment);
                List<String> imgList=orderCommentImgMapper.queryOrderCommentImgList(comment.getId());
                if(!CollectionUtils.isEmpty(imgList)){
                    vo.setImgList(imgList);
                }
                orderCommentAllVo.add(vo);
            }

        }
        PageInfo<OrderCommentAllVo> page = new PageInfo<>(orderCommentAllVo);
        res.setData(page);
        return res;
    }

    /**
     * 添加订单评论
     *
     * @param
     * @return
     */
    @Override
    public int addObj(OrderComment t) {
        return this.orderCommentMapper.insertSelective(t);
    }

    /**
     * 删除订单评论
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.orderCommentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改订单评论
     *
     * @param
     * @return
     */
    @Override
    public int modifyObj(OrderComment t) {
        return this.orderCommentMapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderComment
     */
    @Override
    public OrderComment queryObjById(int id) {
        OrderComment model = this.orderCommentMapper.selectByPrimaryKey(id);
        return model;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage submitOrderComment(OrderComment orderComment, List<String> commonImgList) {
        return getResponseMessage(orderComment, commonImgList);
    }

    private ResponseMessage getResponseMessage(OrderComment orderComment, List<String> commonImgList) {
        ResponseMessage responseMessage=new ResponseMessage();
        OrderBase orderBase=orderBaseMapper.selectByPrimaryKey(orderComment.getOrderId());
        if(orderBase!=null){
            Integer status=orderBase.getStatus();
            Integer operType=orderComment.getOperType();
            Map<String,Object> map=new HashMap<>(16);
            map.put("orderId",orderComment.getOrderId());
            map.put("productId",orderComment.getProductId());
            //类型为评价，并且订单状态为待评价
            if(operType==OrderComment.MEMBER_COMMENT&&status==OrderBase.OrderStatus.WAIT_COMMENT){
               addComment(map,orderComment,orderBase,commonImgList);
            }else if(operType==OrderComment.BEAUTICIAN_REPLY&&status==OrderBase.OrderStatus.COMMENT_COMPLETE){
                map.put("beauticianId",orderComment.getParentBeauticianId());
                //查询该订单美容师回复次数
                int replyCount=orderCommentMapper.queryCommentCount(map);
                if(replyCount>0){
                    responseMessage.setCode(OrderConstant.HAS_REPLY);
                    responseMessage.setMessage(OrderConstant.HAS_REPLY_MSG);
                }else{
                    OrderComment orderComment1=orderCommentMapper.queryByOrderId(orderComment.getOrderId());
                    if(orderComment1!=null){
                        orderComment1.setParentBeauticianId(orderComment.getParentBeauticianId());
                        orderComment1.setParentBeauticianName(orderComment.getParentBeauticianName());
                        orderComment1.setReplyContent(orderComment.getReplyContent());
                        orderComment1.setReplyTime(new Date());
                        orderCommentMapper.updateByPrimaryKeySelective(orderComment1);
                        //更改订单基础信息表为美容师已回复
                        Byte reply=2;
                        orderBase.setBeauticianReplyCommentStatus(reply);
                        orderBaseMapper.updateByPrimaryKeySelective(orderBase);
                    }else{
                        responseMessage.setCode(OrderConstant.HAS_NOT_COMMENT);
                        responseMessage.setMessage(OrderConstant.HAS_NOT_COMMENT_MSG);
                    }
                }
            }else{
                responseMessage.setCode(OrderConstant.UNKNOWN_ORDER_CPMMENT_TYPE);
                responseMessage.setMessage(OrderConstant.UNKNOWN_ORDER_CPMMENT_TYPE_MSG);
            }
        }
        return responseMessage;
    }


    private ResponseMessage addComment(Map map,OrderComment orderComment,OrderBase orderBase,List<String> commonImgList){
        ResponseMessage responseMessage=new ResponseMessage();
        //查询会员对购买服务的订单评论次数，只允许一次
        map.put("memberId",orderComment.getMemberId());
        int judgeCount=orderCommentMapper.queryCommentCount(map);
        if(judgeCount>0){
            responseMessage.setCode(OrderConstant.HAS_COMMENT);
            responseMessage.setMessage(OrderConstant.HAS_COMMENT_MSG);
        }else{
            Integer servicecredit=orderComment.getServicecredit()==null?0:orderComment.getServicecredit();
            Integer storeEnvironment=orderComment.getStoreEnvironment()==null?0:orderComment.getStoreEnvironment();
            Integer beauticianServerQuality=orderComment.getBeauticianServerQuality()==null?0:orderComment.getBeauticianServerQuality();
            orderComment.setProductEvaluationGrade(getEvaluateGrade(servicecredit));
            orderComment.setBeauticianEvaluationGrade(getEvaluateGrade(beauticianServerQuality));
            orderComment.setStoreEvaluationGrade(getEvaluateGrade(storeEnvironment));
            orderComment.setStoreId(orderBase.getStoreId());
            orderComment.setOrderNo(orderBase.getOrderNo());
            orderComment.setStoreName(orderBase.getStoreName());
            OrderProduct orderProduct=orderProductMapper.queryByOrderId(orderBase.getId());
            orderComment.setProductId(orderProduct.getProductId());
            orderComment.setProcutName(orderProduct.getProductName());
            orderComment.setProductImg(orderProduct.getProductImg());
            boolean isTrue=CollectionUtils.isEmpty(commonImgList);
            if(!isTrue){
                orderComment.setHasImg(true);
            }
            OrderBeautician orderBeautician=orderBeauticianMapper.queryByOrderId(orderBase.getId());
            orderComment.setBeauticianId(orderBeautician.getBeauticianId());
            orderCommentMapper.insertSelective(orderComment);
            OrderComment comment=orderCommentMapper.selectByPrimaryKey(orderComment.getId());
            if(!isTrue){
                if(comment!=null){
                    Integer commonId=comment.getId();
                    List<OrderCommentImg> list=new ArrayList<>(10);
                    for(String img:commonImgList){
                        OrderCommentImg orderCommentImg=new OrderCommentImg();
                        orderCommentImg.setCommentId(commonId);
                        orderCommentImg.setCommentImgUrl(img);
                        list.add(orderCommentImg);
                    }
                    //执行批量添加
                    orderCommentImgMapper.insertCommentImgBatch(list);
                }
            }
            orderBase.setStatus(OrderConstant.Status.EVALUATION_COMPLETION);
            Byte rePly=1;
            orderBase.setBeauticianReplyCommentStatus(rePly);
            orderBaseMapper.updateByPrimaryKeySelective(orderBase);
            addGrowthRule(storeEnvironment,beauticianServerQuality,orderBase.getStoreId(),orderBeautician.getBeauticianId());
            //推送APP消息
            OrderSendAppVo vo=orderBaseMapper.queryById(orderBase.getId());
            customerOrderCommentTask.pushMsg(vo);
        }
        return responseMessage;

    }

    private Byte getEvaluateGrade(int starNum){
        Byte grade=0;
        if(starNum==OrderComment.StarNum.ONE_STAR){
            grade=1;
        }else if(starNum==OrderComment.StarNum.TWO_STAR||starNum==OrderComment.StarNum.THREE_STAR||starNum==OrderComment.StarNum.FOUR_STAR){
            grade=2;
        }else if(starNum==OrderComment.StarNum.FIVE_STAR){
            grade=3;
        }
        return grade;

    }

    private void addGrowthRule(Integer storeEnvironment,Integer beauticianServerQuality,Integer storeId,Integer beauticianId){
        //添加成长值
        List<GrowthRuleVo> voList=new ArrayList<>(10);
        if(storeId!=null){
            if(storeEnvironment==1 ||storeEnvironment==OrderComment.StarNum.FIVE_STAR){
                //店铺评价
                GrowthRuleVo grow1=new GrowthRuleVo();
                boolean isStorePriase=storeEnvironment==5;
                String storeCode=isStorePriase?BeauticianGrowthRuleEnum.ORDER_PRAISE.getCode():BeauticianGrowthRuleEnum.ORDER_BAD_REVIEW.getCode();
                grow1.setCode(storeCode);
                grow1.setRuleType(GrowthRuleVo.RuleTypes.STORE);
                grow1.setSourceId(storeId);
                voList.add(grow1);
            }

        }
        if(beauticianId!=null){
            if(beauticianServerQuality==OrderComment.StarNum.ONE_STAR||beauticianServerQuality==OrderComment.StarNum.FIVE_STAR){
                //美容师评价
                GrowthRuleVo grow2=new GrowthRuleVo();
                boolean isBeauticianPriase=beauticianServerQuality==5;
                String beauticianCode=isBeauticianPriase?BeauticianGrowthRuleEnum.ORDER_PRAISE.getCode():BeauticianGrowthRuleEnum.ORDER_BAD_REVIEW.getCode();
                grow2.setCode(beauticianCode);
                grow2.setRuleType(GrowthRuleVo.RuleTypes.BEAUTICIAN);
                grow2.setSourceId(beauticianId);
                voList.add(grow2);
            }
        }
        if(voList.size()>0){
            growthRuleFeign.saveBatchGrowthRuleV111(voList);
        }
    }

    @Override
    public ResponseMessage cancelOrderComment(Integer memberId, Integer orderId) {
        ResponseMessage res= ResponseMessageFactory.newInstance();
        OrderBase order=orderBaseMapper.selectByPrimaryKey(orderId);
        if(order!=null){
            OrderComment orderComment=orderCommentMapper.queryByOrderId(order.getId());
            if(orderComment!=null){
                orderComment.setIsEnabled(false);
                orderComment.setHasCancel(true);
                orderCommentMapper.updateByPrimaryKeySelective(orderComment);
                order.setBeauticianReplyCommentStatus((byte)0);
                orderBaseMapper.updateByPrimaryKeySelective(order);
            }else{
                res.setCode(OrderConstant.Query.HAS_NO_COMMENT);
                res.setMessage(OrderConstant.Query.HAS_NO_COMMEN_MSG);
            }
        }else{
            throw new ServerException(HttpStatusConstant.ERROR.getStatus(),"查询不到订单信息");
        }
        return res;
    }


    /**
     *
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param productId
     * @param hasImg
     * @param productEvaluationGrade
     * @param storeEvaluationGrade
     * @return
     */
    @Override
    public ResponseMessage<CommentVo> queryCommentPage(Integer pageNo, Integer pageSize, Integer storeId, Integer productId, boolean hasImg,Integer beauticianId,
                                                       Byte productEvaluationGrade, Byte storeEvaluationGrade,Byte beauticianEvaluationGrade) {
        ResponseMessage<CommentVo> res=new ResponseMessage<>();
        OrderComment orderComment=new OrderComment();
        orderComment.setStoreId(storeId);
        orderComment.setProductId(productId);
        orderComment.setBeauticianId(beauticianId);
        if(hasImg){
            orderComment.setHasImg(hasImg);
        }
        orderComment.setProductEvaluationGrade(productEvaluationGrade);
        orderComment.setStoreEvaluationGrade(storeEvaluationGrade);
        orderComment.setBeauticianEvaluationGrade(beauticianEvaluationGrade);
        CommentVo commentVo=null;
        if (productId != null) {
            commentVo = this.orderCommentMapper.queryProductCountByCondition(orderComment);
        }
        if(storeId!=null) {
            commentVo = this.orderCommentMapper.queryStoreCountByConditions(orderComment);
        }
        if(beauticianId!=null){
            commentVo=this.orderCommentMapper.queryBeauticianCountByConditions(orderComment);
        }
        PageInfo<OrderComment> pageInfo=getPage(pageNo,pageSize,orderComment);
        if(commentVo==null){
            commentVo=new CommentVo();
        }
        commentVo.setVoPageInfo(pageInfo);
        res.setData(commentVo);
        return res;
    }


    @Override
    public ResponseMessage<OrderComment> queryByOrderId(Integer orderId) {
        ResponseMessage<OrderComment> res=new ResponseMessage<>();
        OrderComment orderComment=orderCommentMapper.queryByOrderId(orderId);
        Optional.ofNullable(orderComment).filter(x->x!=null).orElseThrow(()->new ServerException(HttpStatusConstant.ERROR.getStatus(),"订单评论查询为空"));
        List<String> imgList=orderCommentImgMapper.queryOrderCommentImgList(orderComment.getId());
        if(!CollectionUtils.isEmpty(imgList)){
            orderComment.setOrderCommentImgList(imgList);
        }
        res.setData(orderComment);
        return res;
    }
}