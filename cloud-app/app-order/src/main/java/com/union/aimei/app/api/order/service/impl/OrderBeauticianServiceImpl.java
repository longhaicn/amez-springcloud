package com.union.aimei.app.api.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.app.api.order.mapper.OrderBeauticianMapper;
import com.union.aimei.app.api.order.service.OrderBeauticianService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.constant.ResponseContants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/** 
  * @author GaoWei
  * @Date 18-8-13 下午1:51
  * @description
  */
@Service("orderBeauticianService")
public class OrderBeauticianServiceImpl implements OrderBeauticianService {


    @Resource
    private OrderBeauticianMapper orderBeauticianMapper;


    @Override
    public ResponseMessage<PageInfo<BeauticianReserved>> reservedBoard(Integer pageNo, Integer pageSize, Integer storeId, String chooseTime) {
        String startTime = getFormatTimeString(chooseTime, "00:00:00");
        String endTime = getFormatTimeString(chooseTime, "23:59:59");
        Map<String, Object> map = new HashMap<>(16);
        map.put("storeId", storeId);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        List<Map<String, Object>> listMap = orderBeauticianMapper.queryStoreBeauticianByGroup(map);
        boolean isTrue = CollectionUtils.isEmpty(listMap);
        List<BeauticianReserved> brList = new ArrayList<>(0);
        if (!isTrue) {
            for (Map<String, Object> ob : listMap) {
                Object beauticianName = ob.get("beauticianName");
                Object imgUrl = ob.get("imgUrl");
                Object beauticianId = ob.get("beauticianId");
                Object orderId=ob.get("orderId");
                BeauticianReserved beauticianReserved = new BeauticianReserved();
                if(orderId!=null){
                    String ordId=orderId.toString();
                    beauticianReserved.setOrderId(Integer.parseInt(ordId));
                }
                if (beauticianName != null) {
                    beauticianReserved.setName(beauticianName.toString());
                }
                if (imgUrl != null) {
                    beauticianReserved.setImgUrl(imgUrl.toString());
                }
                if (beauticianId != null) {
                    Integer id = Integer.parseInt(beauticianId.toString());
                    beauticianReserved.setId(id);
                    map.put("beauticianId", id);
                }
                int num = orderBeauticianMapper.queryBeauticianOrderNum(map);
                beauticianReserved.setNum(num);
                List<Map<String, Object>> mapList = orderBeauticianMapper.queryBeauticianOrderInfo(map);
                beauticianReserved.setBeauticianOrder(mapList);
                brList.add(beauticianReserved);
            }
        }
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BeauticianReserved> page = new PageInfo<>(brList);
        ResponseMessage<PageInfo<BeauticianReserved>> res = new ResponseMessage<>();
        res.setData(page);
        return res;
    }




    /**
     * @param chooseTime
     * @param suffix
     * @return
     */
    private String getFormatTimeString(String chooseTime, String suffix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chooseTime);
        stringBuilder.append(" ");
        stringBuilder.append(suffix);
        return stringBuilder.toString();
    }

    /**
     * 美容师安排详情查询
     *
     * @param pageNo
     * @param pageSize
     * @param storeId    门店ID
     * @param id         美容师ID
     * @param chooseTime 选择时间
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<BeauticianArrangeVo>> beauticianArrange(Integer pageNo, Integer pageSize, Integer storeId, Integer id, String chooseTime) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("storeId", storeId);
        map.put("id", id);
        map.put("startTime", getFormatTimeString(chooseTime, "00:00:00"));
        map.put("endTime", getFormatTimeString(chooseTime, "23:59:59"));
        ResponseMessage responseMessage = new ResponseMessage();
        PageHelper.startPage(pageNo, pageSize);
        List<BeauticianArrangeVo> list = orderBeauticianMapper.queryBeauticianArrange(map);
        PageInfo<BeauticianArrangeVo> page = new PageInfo<>(list);
        responseMessage.setData(page);
        return responseMessage;
    }


    /**
     * 查询美容师繁忙时间
     *
     * @param chooseBeauticianListVo
     * @return
     */
    @Override
    public ResponseMessage<List<BeauticianBusyTimeVo>> queryBeauticianBusyTime(ChooseBeauticianListVo chooseBeauticianListVo) {
        ResponseMessage<List<BeauticianBusyTimeVo>> responseMessage = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>(16);
        String chooseTime = chooseBeauticianListVo.getChooseTime();
        String chooseStartTime = getFormatTimeString(chooseTime, "00:00:00");
        String chooseEndTime = getFormatTimeString(chooseTime, "23:59:59");
        map.put("chooseStartTime", chooseStartTime);
        map.put("chooseEndTime", chooseEndTime);
        List<Integer> beauticianList = chooseBeauticianListVo.getBeauticianIdList();
        List<BeauticianBusyTimeVo> busyTimeVos = new ArrayList<>(10);
        beauticianList.forEach(x -> {
            BeauticianBusyTimeVo busyTimeVo = new BeauticianBusyTimeVo();
            busyTimeVo.setBeauticianId(x);
            map.put("beauticianId", x);
            Set<OrderTimeVo> set = orderBeauticianMapper.queryStoreBeauticianOrderTime(map);
            busyTimeVo.setOrderTimeVoSet(set);
            busyTimeVos.add(busyTimeVo);
        });
        responseMessage.setData(busyTimeVos);
        return responseMessage;
    }

    /**
     * 通过订单ID查询订单美容师信息
     *
     * @param orderId
     * @return
     */
    @Override
    public ResponseMessage<OrderBeautician> queryByOrderId(Integer orderId) {
        ResponseMessage responseMessage = new ResponseMessage();
        OrderBeautician orderBeautician = orderBeauticianMapper.queryByOrderId(orderId);
        if (orderBeautician != null) {
            responseMessage.setData(orderBeautician);
        } else {
            responseMessage.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            responseMessage.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return responseMessage;
    }

    /**
     * 查询美容师当前时间是否已安排
     *
     * @param chooseBeauticianListVo
     * @return
     */
    @Override
    public ResponseMessage<List<Integer>> queryBeauticianChooseTimeTimeForBusy(ChooseBeauticianListVo chooseBeauticianListVo) {
        ResponseMessage<List<Integer>> responseMessage = new ResponseMessage();
        List<Integer> list = orderBeauticianMapper.queryBeauticianChooseTimeTimeForBusy(chooseBeauticianListVo);
        responseMessage.setData(list);
        return responseMessage;
    }


    @Override
    public ResponseMessage<OrderBeautician> queryByOrderNo(String orderNo) {
        ResponseMessage<OrderBeautician> res = new ResponseMessage<>();
        OrderBeautician orderBeautician = orderBeauticianMapper.queryByOrderNo(orderNo);
        if (orderBeautician != null) {
            res.setData(orderBeautician);
        } else {
            res.setCode(ResponseContants.QUERY_RESULT_EMPTY);
            res.setMessage(ResponseContants.QUERY_RESULT_EMPTY_MESSAGE);
        }
        return res;
    }


}