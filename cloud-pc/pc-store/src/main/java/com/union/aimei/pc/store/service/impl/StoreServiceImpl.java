package com.union.aimei.pc.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.tx.annotation.TxTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.union.aimei.common.constant.base.SmsConstant;
import com.union.aimei.common.constant.common.CommonConstant;
import com.union.aimei.common.constant.store.StoreConstant;
import com.union.aimei.common.constant.store.StoreGrowthRuleEnum;
import com.union.aimei.common.feign.im.pc.EasemobImUsersFeign;
import com.union.aimei.common.feign.pc.member.MemberFeign;
import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import com.union.aimei.common.feign.pc.product.ProductFeign;
import com.union.aimei.common.feign.pc.product.ProductStoreRefFeign;
import com.union.aimei.common.feign.pc.system.BaseUserFeign;
import com.union.aimei.common.feign.pc.system.SendSmsFeign;
import com.union.aimei.common.model.im.ImUsers;
import com.union.aimei.common.model.member.Member;
import com.union.aimei.common.model.order.QueryNewAddOrder;
import com.union.aimei.common.model.product.Product;
import com.union.aimei.common.model.product.ProductStoreRef;
import com.union.aimei.common.model.store.*;
import com.union.aimei.common.model.system.BaseUser;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.aimei.common.vo.order.StatisticsOrderVo;
import com.union.aimei.common.vo.product.pc.ProductStoreRefByBatchVo;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.GrowthRuleVo;
import com.union.aimei.common.vo.store.pc.*;
import com.union.aimei.common.vo.system.BaseUserVo;
import com.union.aimei.common.vo.system.SmsMessageVo;
import com.union.aimei.pc.store.mapper.*;
import com.union.aimei.pc.store.service.GrowthRuleService;
import com.union.aimei.pc.store.service.StoreChainBrandService;
import com.union.aimei.pc.store.service.StoreService;
import com.union.aimei.remote.model.MrbMemberLoginImVo;
import com.union.aimei.remote.model.MrbMemberLoginVo;
import com.union.common.baidumap.util.MapUtil;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.constant.ResponseContants;
import com.union.common.utils.date.DateUtil;
import com.union.common.utils.encryption.Md5Util;
import io.swagger.client.model.User;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

/**
 * 门店
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMapper storeMapper;
    @Resource
    private StoreExtendMapper storeExtendMapper;
    @Resource
    private StoreChainBrandMapper storeChainBrandMapper;
    @Resource
    private StoreExtendOperationLogMapper storeExtendOperationLogMapper;
    @Resource
    private ProductFeign productFeign;
    @Resource
    private ProductStoreRefFeign productStoreRefFeign;
    @Resource
    private BaseUserFeign baseUserFeign;
    @Resource
    private EasemobImUsersFeign easemobImUsersFeign;
    @Resource
    private MemberFeign memberFeign;
    @Resource
    private StoreBeauticianMapper storeBeauticianMapper;
    @Resource
    private StoreChainBrandService storeChainBrandService;
    @Resource
    private GrowthRuleService growthRuleService;
    @Resource
    private SendSmsFeign sendSmsFeign;
    @Resource
    private OrderBaseFeign orderBaseFeign;

    /**
     * 前端分页查询门店
     *
     * @param pageNo   分页索引
     * @param pageSize 每页显示数量
     * @param store    查询条件
     * @return
     */
    @Override
    public PageInfo<Store> findByPageForFront(Integer pageNo, Integer pageSize, Store store) {
        PageHelper.startPage(pageNo, pageSize);
        List<Store> list = this.storeMapper.selectListByConditions(store);
        PageInfo<Store> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加门店
     *
     * @param store
     * @return
     */
    @Override
    public int addObj(Store store) {
        return this.storeMapper.insertSelective(store);
    }

    /**
     * 删除门店
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.storeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改门店
     *
     * @param store
     * @return
     */
    @Override
    @TxTransaction
    @Transactional(rollbackFor = Exception.class)
    public int modifyObj(Store store) {
        return this.storeMapper.updateByPrimaryKeySelective(store);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnstore
     */
    @Override
    public Store queryObjById(int id) {
        Store model = this.storeMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage<List<Store>> findListByBrandId(StoreByBrandIdVo storeByBrandIdVo) {
        ResponseMessage<List<Store>> responseMessage = new ResponseMessage<>();
        List<Store> storeList = this.storeMapper.selectListByBrandId(storeByBrandIdVo);
        responseMessage.setData(storeList);
        return responseMessage;
    }

    /**
     * 生成入驻码
     *
     * @return
     */
    public String getSettledCode() {
        String settledCode = "";
        boolean flag = true;
        while (flag) {
            settledCode = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
            Store store = new Store();
            store.setSettledCode(settledCode);
            List<Store> storeList = this.storeMapper.selectListByConditions(store);
            if (CollectionUtils.isEmpty(storeList)) {
                flag = false;
            }
        }
        return settledCode;
    }

    /**
     * 保存门店操作日志
     *
     * @param store   门店
     * @param storeVo 门店条件
     */
    @Async
    public void saveStoreExtendOperationLog(Store store, StoreVo storeVo) {
        StoreExtendOperationLog storeExtendOperationLog = new StoreExtendOperationLog();
        storeExtendOperationLog.setStoreId(store.getId());
        storeExtendOperationLog.setContent("新增\"" + store.getStoreName() + "\"");
        storeExtendOperationLog.setOldValue("");
        storeExtendOperationLog.setNewValue(storeVo.toString());
        this.storeExtendOperationLogMapper.insertSelective(storeExtendOperationLog);
    }

    /**
     * 门店连锁品牌
     *
     * @param isAddStore 是否新增门店，true-是，false-否
     * @param store      门店
     */
    public void storeChainBrand(boolean isAddStore, Store store) {
        if (null != store.getBrandId()) {
            if (!isAddStore) {
                ResponseMessage productStoreRefRes = this.productStoreRefFeign.deleteByStoreId(store.getId());
                ResponseUtil.isFailThrowException(productStoreRefRes);
            }
            ResponseMessage<List<Product>> productListRes = this.productFeign.findListByBrandId(store.getBrandId());
            ResponseUtil.isFailThrowException(productListRes);
            List<Product> productList = productListRes.getData();
            if (CollectionUtils.isNotEmpty(productList)) {
                List<ProductStoreRef> productStoreRefList = new ArrayList<>(10);
                productList.forEach(product -> {
                    ProductStoreRef productStoreRef = new ProductStoreRef();
                    productStoreRef.setProductId(product.getId());
                    productStoreRef.setStoreId(store.getId());
                    productStoreRef.setStoreName(store.getStoreName());
                    productStoreRef.setCityId(store.getCityId());
                    productStoreRef.setStoreLongitude(store.getStoreLongitude());
                    productStoreRef.setStoreLatitude(store.getStoreLatitude());
                    productStoreRef.setSaleStatus(Product.SaleStatus.OFF_SHELVES);
                    productStoreRefList.add(productStoreRef);
                });
                ResponseMessage productStoreRefRes = this.productStoreRefFeign.addBatch(new ProductStoreRefByBatchVo(productStoreRefList));
                ResponseUtil.isFailThrowException(productStoreRefRes);
            }
            if (isAddStore) {
                // 更新店铺连锁品牌
                this.storeChainBrandService.accumStoreTotalByBrandId(store.getBrandId(), StoreChainBrand.TOTAL_ADD);
            }
        }
    }

    @Override
    @TxTransaction(isStart = true)
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage<StoreVo> add(StoreVo storeVo) {
        ResponseMessage<StoreVo> responseMessage = new ResponseMessage<>();
        // 门店
        Store store = storeVo.getStore();
        Store sellerStore = this.storeMapper.getBySellerPhone(store.getSellerPhone());
        if (null != sellerStore) {
            throw new ResponseException(StoreConstant.Query.STORE_SELLER_EXIST, StoreConstant.Query.STORE_SELLER_EXIST_MSG);
        }
        store.setStoreState(Store.StoreState.OPEN);
        store.setSettledCode(this.getSettledCode());
        store.setQualificationStatus(Store.QualificationStatus.PASS);
        store.setQualificationCommitTime(new Date());
        store.setQualificationAuditTime(new Date());
        this.storeMapper.insertSelective(store);
        // 门店扩展
        StoreExtend storeExtend = storeVo.getStoreExtend();
        storeExtend.setStoreId(store.getId());
        this.storeExtendMapper.insertSelective(storeExtend);
        // 门店操作日志
        this.saveStoreExtendOperationLog(store, storeVo);
        // 新增店长
        this.addSeller(store);
        // 项目-门店-关联
        this.storeChainBrand(true, store);
        // 返回结果
        storeVo.setStore(store);
        storeVo.setStoreExtend(storeExtend);
        responseMessage.setData(storeVo);
        return responseMessage;
    }

    /**
     * 新增老板
     *
     * @param store
     */
    public void addBoss(Store store) {
        // 美容师-老板
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPhone(store.getBossPhone());
        if (null == beautician) {
            beautician = new StoreBeautician();
        }
        // 用户
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(store.getBossPhone());
        baseUserVo.setUserType(0);
        ResponseMessage<BaseUser> baseUserRes = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        ResponseUtil.isFailThrowException(baseUserRes);
        BaseUser baseUser = baseUserRes.getData();
        store.setBossUserId(baseUser.getUserId());
        // 更新门店
        this.storeMapper.updateByPrimaryKeySelective(store);
        // 会员
        MrbMemberLoginVo mrbMemberLoginVo = new MrbMemberLoginVo();
        mrbMemberLoginVo.setLoginCustomer(2);
        mrbMemberLoginVo.setLoginType(1);
        mrbMemberLoginVo.setIp("192.168.1.1");
        mrbMemberLoginVo.setMobile(store.getBossPhone());
        mrbMemberLoginVo.setPassword(Md5Util.md5("123456cnbbx"));
        mrbMemberLoginVo.setSource("2");
        mrbMemberLoginVo.setUserName(store.getBossPhone());
        ResponseMessage<Member> memberRes = this.memberFeign.registerAmezMember(mrbMemberLoginVo);
        if (ResponseUtil.isFail(memberRes) && ResponseContants.QUERY_RESULT_EMPTY != memberRes.getCode()) {
            throw new ResponseException(memberRes);
        }
        Member member = memberRes.getData();
        // IM用户
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(ImUsers.DEFAULT_PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = this.easemobImUsersFeign.registerSingle(user);
        ResponseUtil.isFailThrowException(imUsersRes);
        ImUsers imUsers = imUsersRes.getData();
        member.setImUserId(imUsers.getId());
        member.setImUsername(imUsers.getUsername());
        // 更新会员
        ResponseMessage modifyMemberRes = this.memberFeign.modify(member);
        ResponseUtil.isFailThrowException(modifyMemberRes);
        // 美容师
        beautician.setStoreId(store.getId());
        beautician.setStoreName(store.getStoreName());
        beautician.setMemberId(member.getId());
        beautician.setUserId(baseUser.getUserId());
        beautician.setImUserId(imUsers.getId());
        beautician.setImUsername(imUsers.getUsername());
        beautician.setBeauticianName(store.getBossName());
        beautician.setBeauticianNickName(CommonConstant.Beautician.BOSS_NICK_NAME);
        beautician.setPhone(store.getBossPhone());
        beautician.setBeauticianType(StoreBeautician.BeauticianType.BOSS);
        this.storeBeauticianMapper.insertSelective(beautician);
    }

    /**
     * 新增店长
     *
     * @param store
     */
    public void addSeller(Store store) {
        // 美容师-手机号是否已存在
        StoreBeautician beautician = this.storeBeauticianMapper.selectByPhone(store.getSellerPhone());
        if (null != beautician) {
            throw new ResponseException(StoreConstant.Query.BEAUTICIAN_PHONE_EXIST, StoreConstant.Query.BEAUTICIAN_PHONE_EXIST_MSG);
        }
        // 用户
        BaseUserVo baseUserVo = new BaseUserVo();
        baseUserVo.setPhone(store.getSellerPhone());
        baseUserVo.setUserType(1);
        ResponseMessage<BaseUser> baseUserRes = this.baseUserFeign.insertBbossAndShopkeeperAndMember(baseUserVo);
        ResponseUtil.isFailThrowException(baseUserRes);
        BaseUser baseUser = baseUserRes.getData();
        store.setSellerUserId(baseUser.getUserId());
        // 门店更新
        this.storeMapper.updateByPrimaryKeySelective(store);
        // IM用户
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(ImUsers.DEFAULT_PASSWORD);
        ResponseMessage<ImUsers> imUsersRes = this.easemobImUsersFeign.registerSingle(user);
        ResponseUtil.isFailThrowException(imUsersRes);
        ImUsers imUsers = imUsersRes.getData();
        // 会员
        MrbMemberLoginImVo mrbMemberLoginVo = new MrbMemberLoginImVo();
        MrbMemberLoginVo loginVo = new MrbMemberLoginVo();
        loginVo.setLoginCustomer(2);
        loginVo.setLoginType(1);
        loginVo.setIp("192.168.1.1");
        loginVo.setMobile(store.getSellerPhone());
        loginVo.setPassword(Md5Util.md5("123456cnbbx"));
        loginVo.setSource("2");
        loginVo.setUserName(store.getSellerPhone());
        mrbMemberLoginVo.setLoginVo(loginVo);
        mrbMemberLoginVo.setImUserId(imUsers.getId());
        mrbMemberLoginVo.setImUsername(imUsers.getUsername());
        ResponseMessage<Member> memberRes = this.memberFeign.registerAmezMemberV111(mrbMemberLoginVo);
        if (ResponseUtil.isFail(memberRes) && ResponseContants.QUERY_RESULT_EMPTY != memberRes.getCode()) {
            throw new ResponseException(memberRes);
        }
        Member member = memberRes.getData();
        // 美容师
        beautician = new StoreBeautician();
        beautician.setStoreId(store.getId());
        beautician.setStoreName(store.getStoreName());
        beautician.setMemberId(member.getId());
        beautician.setUserId(baseUser.getUserId());
        beautician.setImUserId(imUsers.getId());
        beautician.setImUsername(imUsers.getUsername());
        beautician.setBeauticianName(store.getSellerName());
        beautician.setBeauticianNickName(CommonConstant.Beautician.MANAGER_NICK_NAME);
        beautician.setPhone(store.getSellerPhone());
        beautician.setBeauticianType(StoreBeautician.BeauticianType.MANAGER);
        beautician.setRegisterStatus(StoreBeautician.RegisterStatus.WAIT_IMPROVE);
        beautician.setRealNameStatus(StoreBeautician.RealNameStatus.PASS);
        this.storeBeauticianMapper.insertSelective(beautician);
//        // 发送短信 店铺开通通知
//        SmsMessageVo openingSms = new SmsMessageVo();
//        openingSms.setPhone(beautician.getPhone());
//        openingSms.setSmsCode(SmsConstant.SHOP_OPENING.getSmsCode());
//        this.sendSmsFeign.sendSmsMessageCode(openingSms);
//        // 发送短信 店长账号注册成功
//        SmsMessageVo successSms = new SmsMessageVo();
//        successSms.setPhone(beautician.getPhone());
//        successSms.setSmsCode(SmsConstant.STORE_HEAD_REGISTERED_SUCCESS.getSmsCode());
//        Map<String, Object> contentMap = new HashMap<>(16);
//        contentMap.put("name", mrbMemberLoginVo.getMobile());
//        contentMap.put("pwd", mrbMemberLoginVo.getPassword());
//        successSms.setSmsContent(new Gson().toJson(contentMap));
//        this.sendSmsFeign.sendSmsMessageCode(successSms);
    }

    /**
     * 更新门店操作日志
     *
     * @param store      门店
     * @param oldStoreVo 原值
     * @param newStoreVo 新值
     */
    @Async
    public void updateStoreExtendOperationLog(Store store, StoreVo oldStoreVo, StoreVo newStoreVo) {
        StoreExtendOperationLog storeExtendOperationLog = new StoreExtendOperationLog();
        storeExtendOperationLog.setStoreId(store.getId());
        storeExtendOperationLog.setContent("修改\"" + store.getStoreName() + "\"");
        storeExtendOperationLog.setOldValue(oldStoreVo.toString());
        storeExtendOperationLog.setNewValue(newStoreVo.toString());
        this.storeExtendOperationLogMapper.insertSelective(storeExtendOperationLog);
    }

    @Override
    public ResponseMessage modify(StoreVo storeVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = storeVo.getStore();
        StoreExtend storeExtend = storeVo.getStoreExtend();
        // 原门店
        StoreVo oldStoreVo = new StoreVo();
        Store oldStore = this.storeMapper.selectByPrimaryKey(store.getId());
        StoreExtend oldStoreExtend = this.storeExtendMapper.selectByPrimaryKey(storeExtend.getId());
        oldStoreVo.setStore(oldStore);
        oldStoreVo.setStoreExtend(oldStoreExtend);
        // 更新
        this.storeMapper.updateByPrimaryKeySelective(store);
        this.storeExtendMapper.updateByPrimaryKeySelective(storeExtend);
        // 更新门店操作日志
        this.updateStoreExtendOperationLog(store, oldStoreVo, storeVo);
        // 品牌
        this.storeChainBrand(false, store);
        return responseMessage;
    }

    @Override
    public ResponseMessage<StoreVo> detail(int storeId) {
        ResponseMessage<StoreVo> responseMessage = new ResponseMessage<>();
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(storeId);
        StoreVo storeVo = new StoreVo();
        storeVo.setStore(store);
        storeVo.setStoreExtend(storeExtend);
        responseMessage.setData(storeVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage modifyIsEnabled(int storeId, int isEnabled) {
        ResponseMessage responseMessage = new ResponseMessage();
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (null != store) {
            if (1 == isEnabled) {
                store.setStoreState(isEnabled);
                this.storeMapper.updateByPrimaryKeySelective(store);
            } else if (0 == isEnabled) {
                store.setStoreState(isEnabled);
                this.storeMapper.updateByPrimaryKeySelective(store);
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<JSONArray> findListByBaiduMapLocation(String query, String region) {
        System.out.println("=====================>findListByBaiduMapLocation");
        System.out.println("query:" + query);
        System.out.println("region:" + region);
        ResponseMessage<JSONArray> responseMessage = new ResponseMessage<>();
        responseMessage.setData(MapUtil.searchLocation(query, region));
        System.out.println("=====================>end");
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreByMemberCardResultVo>> findByPageForMemberCard(Integer pageNo, Integer pageSize, StoreByMemberCardVo storeByMemberCardVo) {
        ResponseMessage<PageInfo<StoreByMemberCardResultVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreByMemberCardResultVo> list = this.storeMapper.selectListByMemberCard(storeByMemberCardVo);
        PageInfo<StoreByMemberCardResultVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public Store queryDistanceById(StoreByIdVo storeByIdVo) {
        return this.storeMapper.queryDistanceById(storeByIdVo);
    }

    @Override
    public ResponseMessage<JSONArray> findListByPlaceSearch(PlaceSearchVo placeSearchVo) {
        ResponseMessage<JSONArray> responseMessage = new ResponseMessage<>();
        responseMessage.setData(MapUtil.searchLocation(placeSearchVo.getQuery(), placeSearchVo.getRegion()));
        return responseMessage;
    }

    @Override
    public ResponseMessage<Store> findById(int id) {
        ResponseMessage<Store> responseMessage = new ResponseMessage<>();
        Store store = this.storeMapper.selectByPrimaryKey(id);
        if (store == null) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(store);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Store> findByIdForOpen(int id) {
        ResponseMessage<Store> responseMessage = this.findById(id);
        if (ResponseContants.SUCCESS == responseMessage.getCode()) {
            Store store = responseMessage.getData();
            if (!store.getIsEnabled()) {
                responseMessage.setCode(StoreConstant.Query.STORE_DISABLED);
                responseMessage.setMessage(StoreConstant.Query.STORE_DISABLED_MSG);
                return responseMessage;
            }
            switch (store.getStoreState()) {
                case Store.StoreState.CLOSE:
                    responseMessage.setCode(StoreConstant.Update.STORE_CLOSEED);
                    responseMessage.setMessage(StoreConstant.Update.STORE_CLOSEED_MSG);
                    break;
                case Store.StoreState.OPEN:
                    break;
                case Store.StoreState.FREEZE:
                    responseMessage.setCode(StoreConstant.Update.STORE_FERRZEED);
                    responseMessage.setMessage(StoreConstant.Update.STORE_FERRZEED_MSG);
                    break;
                case Store.StoreState.BE_AUDITED:
                    responseMessage.setCode(StoreConstant.Update.STORE_BE_AUDITED);
                    responseMessage.setMessage(StoreConstant.Update.STORE_BE_AUDITED_MSG);
                    break;
                default:
                    responseMessage.setCode(StoreConstant.Update.STORE_STATE_NOT_EXIST);
                    responseMessage.setMessage(StoreConstant.Update.STORE_STATE_NOT_EXIST_MSG);
                    break;
            }
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<Store>> findListByIdBatch(IdBatchVo idBatchVo) {
        ResponseMessage<List<Store>> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(idBatchVo), Map.class);
        Map<String, Object> condMap = new HashMap<>(16);
        condMap.put("storeState", Store.StoreState.OPEN);
        condMap.putAll(voMap);
        List<Store> storeList = this.storeMapper.selectListByIdBatch(condMap);
        if (storeList.isEmpty()) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        responseMessage.setData(storeList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addByCount(StoreByDataCountVo dataCountVo) {
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>();
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        int count = this.storeMapper.addByCount(voMap);
        responseMessage.setData(count);
        return responseMessage;
    }

    @Override
    public ResponseMessage select(int id, boolean isSelect) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (isSelect) {
            Store selectCond = new Store();
            selectCond.setIsEnabled(true);
            selectCond.setIsSelect(true);
            List<Store> selectList = this.storeMapper.selectListByConditions(selectCond);
            if (CommonConstant.Store.SELECT_LIMIT <= selectList.size()) {
                responseMessage.setCode(StoreConstant.Update.STORE_SELECT_LIMIT);
                responseMessage.setMessage(StoreConstant.Update.STORE_SELECT_LIMIT_MSG);
                return responseMessage;
            }
        }
        Store store = new Store();
        store.setId(id);
        store.setIsSelect(isSelect);
        this.storeMapper.updateByPrimaryKeySelective(store);
        return responseMessage;
    }

    @Override
    public ResponseMessage selectByBatch(StoreBySelectBatchVo selectBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.storeMapper.cancelSelectByCityId(selectBatchVo.getCityId());
        this.storeMapper.updateBatchBySelect(selectBatchVo.getStoreList());
        return responseMessage;
    }

    @Override
    public PageInfo<Store> findByPageForFrontByDate(Integer pageNo, Integer pageSize, StoreByDateVo storeByDate) {
        PageHelper.startPage(pageNo, pageSize);
        List<Store> list = this.storeMapper.findByPageForFrontByDate(storeByDate);
        PageInfo<Store> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ResponseMessage<List<Store>> findListByBossUserId(int bossUserId) {
        ResponseMessage<List<Store>> responseMessage = new ResponseMessage<>();
        Store condStore = new Store();
        condStore.setIsEnabled(true);
        List<Store> list = this.storeMapper.selectListByConditions(condStore);
        if (list.isEmpty()) {
            responseMessage.setCode(StoreConstant.Query.BOSS_USER_STORE_NOT_EXIST);
            responseMessage.setMessage(StoreConstant.Query.BOSS_USER_STORE_NOT_EXIST_MSG);
            return responseMessage;
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage qualificationAudit(StoreByQualificationAuditVo auditVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(auditVo.getStoreId());
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        // 门店扩展
        StoreExtend storeExtend = this.storeExtendMapper.selectByStoreId(auditVo.getStoreId());
        if (null == storeExtend) {
            throw new ResponseException(StoreConstant.Query.STORE_EXTEND_NULL, StoreConstant.Query.STORE_EXTEND_NULL_MSG);
        }
        // 资质状态=待审核
        if (Store.QualificationStatus.PENDING != store.getQualificationStatus()) {
            throw new ResponseException(StoreConstant.Query.STORE_QUALIFICATION_STATUS_CHANGED, StoreConstant.Query.STORE_QUALIFICATION_STATUS_CHANGED_MSG);
        }
        if (auditVo.getQualificationStatus()) {
            store.setQualificationStatus(Store.QualificationStatus.PASS);
            // 门店状态=1-开启
            store.setStoreState(Store.StoreState.OPEN);
            store.setSellerName(storeExtend.getLegalPersonName());
            // 获取店长数据
            StoreBeautician managerBeautician = this.storeBeauticianMapper.selectByPhone(store.getSellerPhone());
            if (null == managerBeautician) {
                throw new ResponseException(StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL, StoreConstant.Query.BEAUTICIAN_STORE_MANAGER_NULL_MSG);
            }
            // 更新店长信息
            managerBeautician.setBeauticianName(storeExtend.getLegalPersonName());
            managerBeautician.setRealNameStatus(StoreBeautician.RealNameStatus.PASS);
            this.storeBeauticianMapper.updateByPrimaryKeySelective(managerBeautician);
            //更新门店下美容师的门店名称
            StoreBeautician storeBeautician = new StoreBeautician();
            storeBeautician.setStoreId(store.getId());
            storeBeautician.setStoreName(store.getStoreName());
            this.storeBeauticianMapper.updateByStoreId(storeBeautician);
            // 成长值
            GrowthRuleVo growthRuleVo = new GrowthRuleVo();
            growthRuleVo.setCode(StoreGrowthRuleEnum.VERIFIED.getCode());
            growthRuleVo.setRuleType(GrowthRuleVo.RuleTypes.STORE);
            growthRuleVo.setSourceId(store.getId());
            this.growthRuleService.saveGrowthRuleV111(growthRuleVo);
        } else {
            store.setQualificationStatus(Store.QualificationStatus.NOT_PASS);
            store.setQualificationReason(auditVo.getQualificationReason());
        }
        //更新店铺数据
        store.setQualificationAuditTime(new Date());
        this.storeMapper.updateByPrimaryKeySelective(store);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<StoreListQualificationResVo>> listQualification(Integer pageNo, Integer pageSize, StoreListQualificationVo qualificationVo) {
        ResponseMessage<PageInfo<StoreListQualificationResVo>> responseMessage = new ResponseMessage<>();
        PageHelper.startPage(pageNo, pageSize);
        List<StoreListQualificationResVo> list = this.storeMapper.listQualification(qualificationVo);
        PageInfo<StoreListQualificationResVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }

    @Override
    public ResponseMessage accumulateGrowthValueV111(int storeId, int growthValue) {
        ResponseMessage responseMessage = new ResponseMessage();
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (null == store) {
            throw new ResponseException(StoreConstant.Query.STORE_NULL, StoreConstant.Query.STORE_NULL_MSG);
        }
        store.setGrowupValue(store.getGrowupValue() + growthValue);
        this.storeMapper.updateByPrimaryKeySelective(store);
        responseMessage.setData(store.getGrowupValue());
        return responseMessage;
    }

    @Override
    public ResponseMessage close(int storeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (store == null) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        // 门店状态
        switch (store.getStoreState()) {
            case Store.StoreState.CLOSE:
                responseMessage.setCode(StoreConstant.Update.STORE_CLOSEED);
                responseMessage.setMessage(StoreConstant.Update.STORE_CLOSEED_MSG);
                break;
            case Store.StoreState.OPEN:
            case Store.StoreState.FREEZE:
                // 门店
                store.setStoreState(Store.StoreState.CLOSE);
                this.storeMapper.updateByPrimaryKeySelective(store);
                // 更新店铺连锁品牌 -1
                if (null != store.getBrandId()) {
                    Map<String, Object> condMap = new HashMap<>(16);
                    condMap.put("brandId", store.getBrandId());
                    condMap.put("number", StoreChainBrand.TOTAL_SUBTRACT);
                    this.storeChainBrandMapper.accumStoreTotalByByBrandId(condMap);
                }
                // 项目-门店-关联
                this.productStoreRefFeign.storeByOffShelves(storeId);
                // 店长账号禁用
                this.baseUserFeign.updateUserSatuts(store.getSellerPhone(), 1);
                // 发送短信 门店关闭
                SmsMessageVo smsMessageVo = new SmsMessageVo();
                smsMessageVo.setPhone(store.getSellerPhone());
                smsMessageVo.setSmsCode(SmsConstant.STORE_CLOSE.getSmsCode());
                Map<String, Object> contentMap = new HashMap<>(16);
                contentMap.put("name", store.getSellerPhone());
                contentMap.put("phone", "4001080666");
                smsMessageVo.setSmsContent(new Gson().toJson(contentMap));
                this.sendSmsFeign.sendSmsMessageCode(smsMessageVo);
                break;
            case Store.StoreState.BE_AUDITED:
                responseMessage.setCode(StoreConstant.Update.STORE_BE_AUDITED);
                responseMessage.setMessage(StoreConstant.Update.STORE_BE_AUDITED_MSG);
                break;
            default:
                responseMessage.setCode(StoreConstant.Update.STORE_STATE_NOT_EXIST);
                responseMessage.setMessage(StoreConstant.Update.STORE_STATE_NOT_EXIST_MSG);
                break;
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage open(int storeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (store == null) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        // 门店状态
        switch (store.getStoreState()) {
            case Store.StoreState.CLOSE:
            case Store.StoreState.BE_AUDITED:
                // 门店
                store.setStoreState(Store.StoreState.OPEN);
                this.storeMapper.updateByPrimaryKeySelective(store);
                // 门店连锁品牌，门店总数+1
                if (null != store.getBrandId()) {
                    Map<String, Object> condMap = new HashMap<>(16);
                    condMap.put("brandId", store.getBrandId());
                    condMap.put("number", StoreChainBrand.TOTAL_ADD);
                    this.storeChainBrandMapper.accumStoreTotalByByBrandId(condMap);
                }
                // 店长账号启用
                this.baseUserFeign.updateUserSatuts(store.getSellerPhone(), 0);
                break;
            case Store.StoreState.OPEN:
                responseMessage.setCode(StoreConstant.Update.STORE_OPENED);
                responseMessage.setMessage(StoreConstant.Update.STORE_OPENED_MSG);
                break;
            case Store.StoreState.FREEZE:
                // 门店
                store.setStoreState(Store.StoreState.OPEN);
                this.storeMapper.updateByPrimaryKeySelective(store);
                this.productStoreRefFeign.freezeByStoreId(storeId, false);
                // 店长账号启用
                this.baseUserFeign.updateUserSatuts(store.getSellerPhone(), 0);
                break;
            default:
                responseMessage.setCode(StoreConstant.Update.STORE_STATE_NOT_EXIST);
                responseMessage.setMessage(StoreConstant.Update.STORE_STATE_NOT_EXIST_MSG);
                break;
        }
        return responseMessage;
    }

    @Override
    public ResponseMessage freeze(int storeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        // 门店
        Store store = this.storeMapper.selectByPrimaryKey(storeId);
        if (store == null) {
            responseMessage.setCode(StoreConstant.Query.STORE_NULL);
            responseMessage.setMessage(StoreConstant.Query.STORE_NULL_MSG);
            return responseMessage;
        }
        // 门店状态
        switch (store.getStoreState()) {
            case Store.StoreState.CLOSE:
                throw new ResponseException(StoreConstant.Update.STORE_CLOSEED, StoreConstant.Update.STORE_CLOSEED_MSG);
            case Store.StoreState.OPEN:
                // 门店
                store.setStoreState(Store.StoreState.FREEZE);
                this.storeMapper.updateByPrimaryKeySelective(store);
                // 店长账号禁用
                this.baseUserFeign.updateUserSatuts(store.getSellerPhone(), 1);
                this.productStoreRefFeign.freezeByStoreId(storeId, true);
                // 发送短信 门店冻结
                SmsMessageVo smsMessageVo = new SmsMessageVo();
                smsMessageVo.setPhone(store.getSellerPhone());
                smsMessageVo.setSmsCode(SmsConstant.STORE_FREEZING.getSmsCode());
                Map<String, Object> contentMap = new HashMap<>(16);
                contentMap.put("name", store.getSellerPhone());
                contentMap.put("phone", "4001080666");
                smsMessageVo.setSmsContent(new Gson().toJson(contentMap));
                this.sendSmsFeign.sendSmsMessageCode(smsMessageVo);
                break;
            case Store.StoreState.BE_AUDITED:
                throw new ResponseException(StoreConstant.Update.STORE_BE_AUDITED, StoreConstant.Update.STORE_BE_AUDITED_MSG);
            case Store.StoreState.FREEZE:
                throw new ResponseException(StoreConstant.Update.STORE_FERRZEED, StoreConstant.Update.STORE_FERRZEED_MSG);
            default:
                throw new ResponseException(StoreConstant.Update.STORE_STATE_NOT_EXIST, StoreConstant.Update.STORE_STATE_NOT_EXIST_MSG);
        }
        return responseMessage;
    }

    /**
     * 商品待审核
     *
     * @param resVo
     * @param dataCountVo
     */
    private void countByProduct(StoreByDataCountResVo resVo, StoreByDataCountVo dataCountVo) {
        ResponseMessage<Integer> countRes = this.productFeign.pendingByCount(dataCountVo);
        ResponseUtil.isFailThrowException(countRes);
        resVo.setPendingProductCount(countRes.getData());
    }

    /**
     * 美容师待审核
     *
     * @param resVo
     * @param dataCountVo
     */
    private void countByPendingBeautician(StoreByDataCountResVo resVo, StoreByDataCountVo dataCountVo) {
        dataCountVo.setRealNameStatus(StoreBeautician.RealNameStatus.PENGING);
        Map<String, Object> condMap = new HashMap<>(16);
        Map<String, Object> voMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        condMap.put("storeId", dataCountVo.getStoreId());
        condMap.putAll(voMap);
        int beauticianCount = this.storeBeauticianMapper.pendingByCount(condMap);
        resVo.setPendingBeauticianCount(beauticianCount);
    }

    /**
     * 新增会员
     *
     * @param resVo
     * @param dataCountVo
     */
    private void countByAddMember(StoreByDataCountResVo resVo, StoreByDataCountVo dataCountVo) {
        dataCountVo.setRealNameStatus(StoreBeautician.RealNameStatus.PASS);
        Map<String, Object> addCondMap = new HashMap<>(16);
        Map<String, Object> addVoMap = JSONObject.parseObject(JSON.toJSONString(dataCountVo), Map.class);
        addCondMap.put("storeId", dataCountVo.getStoreId());
        addCondMap.putAll(addVoMap);
        int memberCount = this.storeBeauticianMapper.pendingByCount(addCondMap);
        resVo.setAddMemberCount(memberCount);
    }

    /**
     * 新增订单服务
     *
     * @param resVo
     * @param dataCountVo
     */
    private void countByAddProductOrder(StoreByDataCountResVo resVo, StoreByDataCountVo dataCountVo) {
        QueryNewAddOrder queryNewAddOrder = new QueryNewAddOrder();
        if (dataCountVo.getStoreId() != 0 && dataCountVo.getStoreId() != null) {
            queryNewAddOrder.setType(1);
            queryNewAddOrder.setStoreId(dataCountVo.getStoreId());
        } else {
            queryNewAddOrder.setType(0);
        }
        switch (dataCountVo.getDays()) {
            case 1:
                queryNewAddOrder.setQuery(0);
                break;
            case 7:
                queryNewAddOrder.setQuery(1);
                break;
            case 30:
                queryNewAddOrder.setQuery(2);
                break;
            default:
                break;
        }
        ResponseMessage<Integer> responseMessage2 = this.orderBaseFeign.newAddOrderNums(queryNewAddOrder);
        ResponseUtil.isFailThrowException(responseMessage2);
        resVo.setAddProductOrderCount(responseMessage2.getData());
    }

    @Override
    public ResponseMessage<StoreByDataCountResVo> dataCount(StoreByDataCountVo dataCountVo) {
        ResponseMessage<StoreByDataCountResVo> responseMessage = new ResponseMessage<>();
        //统计天数设置
        try {
            dataCountVo.setStartTime(DateUtil.getFrontDay(new Date(), dataCountVo.getDays() - 1, "yyyy-MM-dd") + " 00:00:00");
            dataCountVo.setEndTime(DateUtil.getStrByDate(new Date()));
        } catch (ParseException e) {
            throw new ResponseException(ResponseContants.PARAMS_ERROR, ResponseContants.PARAMS_ERROR_MSG);
        }
        StoreByDataCountResVo resVo = new StoreByDataCountResVo();
        // 待审核商品统计
        this.countByProduct(resVo, dataCountVo);
        // 待审核员工统计
        this.countByPendingBeautician(resVo, dataCountVo);
        // 新增美容师统计
        this.countByAddMember(resVo, dataCountVo);
        // 新增门店统计
        ResponseMessage<Integer> countRes = this.addByCount(dataCountVo);
        if (ResponseUtil.isSuccess(countRes)) {
            resVo.setAddStoreCount(countRes.getData());
        } else {
            return (ResponseMessage) countRes;
        }
        // 新增商品统计
        countRes = this.productFeign.addByCount(dataCountVo);
        if (ResponseUtil.isSuccess(countRes)) {
            resVo.setAddProductCount(countRes.getData());
        } else {
            return (ResponseMessage) countRes;
        }
        // 交易额统计
        StatisticsOrderVo statisticsOrderVo = new StatisticsOrderVo();
        statisticsOrderVo.setStartTime(dataCountVo.getStartTime());
        statisticsOrderVo.setEndTime(dataCountVo.getEndTime());
        if (dataCountVo.getStoreId() != 0 && dataCountVo.getStoreId() != null) {
            statisticsOrderVo.setStoreId(dataCountVo.getStoreId());
            statisticsOrderVo.setType(1);
        } else {
            statisticsOrderVo.setType(0);
        }
        ResponseMessage<Integer> responseMessage1 = this.orderBaseFeign.sumOrderAmountByStoreIdAndDays(statisticsOrderVo);
        ResponseUtil.isFailThrowException(responseMessage1);
        resVo.setTurnoverCount(responseMessage1.getData());
        //新增服务订单
        this.countByAddProductOrder(resVo, dataCountVo);
        // 新增服务订单统计
        ResponseMessage<HashMap<String, Integer>> orderRes = this.orderBaseFeign.countOrderInfoByDays(dataCountVo.getType(), dataCountVo.getStoreId(), dataCountVo.getDays());
        ResponseUtil.isFailThrowException(orderRes);
        responseMessage.setData(resVo);
        return responseMessage;
    }

}