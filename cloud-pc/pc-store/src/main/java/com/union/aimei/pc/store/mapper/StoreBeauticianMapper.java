package com.union.aimei.pc.store.mapper;

import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreBeauticianMapper extends BaseMapper<StoreBeautician> {

    /**
     * 根据用户ID查询美容师
     *
     * @param userId 用户ID
     * @return
     */
    StoreBeautician selectByUserId(int userId);

    /**
     * 根据手机号查询美容师
     *
     * @param phone 手机号
     * @return
     */
    StoreBeautician selectByPhone(String phone);

    /**
     * 查询美容师（招募）
     *
     * @param storeBeauticianByRecruitVo
     * @return
     */
    List<StoreBeautician> selectListByRecruit(StoreBeauticianByRecruitVo storeBeauticianByRecruitVo);

    /**
     * 根据会员id查询美容师
     *
     * @param memberId 手机号
     * @return
     */
    StoreBeautician getByMemberId(Integer memberId);

    /**
     * 根据店铺ID查询店长
     *
     * @param storeId 店铺ID
     * @return
     */
    StoreBeautician selectByStoreIdForManager(@Param(value = "storeId") int storeId);

    /**
     * 查询美容师（美容师）
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> selectListByBeautician(Map<String, Object> condMap);

    /**
     * 待审核员工统计
     *
     * @param condMap 条件
     * @return
     */
    int pendingByCount(Map<String, Object> condMap);

    /**
     * 根据城市ID取消明星美容师
     *
     * @param cityId 城市ID
     * @return
     */
    int cancelStarByCityId(@Param(value = "cityId") int cityId);

    /**
     * 批量更新明星美容师
     *
     * @param beauticianList 美容师集合
     * @return
     */
    void updateBatchByStar(@Param(value = "beauticianList") List<BeauticianByStarVo> beauticianList);

    /**
     * 根据工牌号查询美容师
     *
     * @param condMap 条件
     * @return
     */
    StoreBeautician getByWorkCardNo(Map<String, Object> condMap);

    /**
     * 解除挂靠
     *
     * @param condMap 条件
     * @return
     */
    int removeAffiliated(Map<String, Object> condMap);

    /**
     * 根据门店ID查询全职美容师
     *
     * @param condMap 条件
     * @return
     */
    List<StoreBeautician> listFullTimeByStoreId(Map<String, Object> condMap);

    /**
     * 根据店铺id批量更新店铺名字
     *
     * @param storeBeautician
     * @return
     */
    int updateByStoreId(StoreBeautician storeBeautician);

    /**
     * 上架到店项目选择美容师列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListSelectOnSaleProductResVo> listSelectOnSaleStoreProduct(Map<String, Object> condMap);

    /**
     * 上架上门项目选择美容师列表
     *
     * @param condMap 条件
     * @return
     */
    List<BeauticianListSelectOnSaleProductResVo> listSelectOnSaleHomeProduct(Map<String, Object> condMap);

}