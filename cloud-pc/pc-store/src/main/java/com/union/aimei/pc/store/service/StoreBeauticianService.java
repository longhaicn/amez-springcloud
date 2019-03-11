package com.union.aimei.pc.store.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.store.StoreBeautician;
import com.union.aimei.common.vo.product.pc.StoreByDataCountVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductResVo;
import com.union.aimei.common.vo.store.app.BeauticianListSelectOnSaleProductVo;
import com.union.aimei.common.vo.store.pc.BeauticianByStarBatchVo;
import com.union.aimei.common.vo.store.pc.StoreBeaByFullTimeAndPartTimeVo;
import com.union.aimei.common.vo.store.pc.StoreBeauticianByRecruitVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 店铺美容师
 *
 * @author liurenkai
 * @time 2018/1/12 17:34
 */
public interface StoreBeauticianService extends SpringCloudBaseService<StoreBeautician> {
    /**
     * 分页查询店铺美容师
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param storeBeautician 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFront(Integer pageNo, Integer pageSize, StoreBeautician storeBeautician);

    /**
     * 根据用户ID查询店铺美容师
     *
     * @param userId 用户ID
     * @return
     */
    ResponseMessage<StoreBeautician> findByUserId(int userId);

    /**
     * 根据用户ID查询店铺美容师
     *
     * @param userId 用户ID
     * @return
     */
    ResponseMessage<StoreBeautician> findByUserIdForNormal(int userId);

    /**
     * 根据手机号查询店铺美容师
     *
     * @param phone 手机号
     * @return
     */
    ResponseMessage<StoreBeautician> findByPhone(String phone);

    /**
     * 根据会员id查询店铺美容师
     *
     * @param memberId
     * @return
     */
    ResponseMessage<StoreBeautician> findByMemberId(Integer memberId);

    /**
     * 分页查询店铺美容师（招募）
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页数量
     * @param storeBeauticianByRecruitVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForRecruit(Integer pageNo, Integer pageSize, StoreBeauticianByRecruitVo storeBeauticianByRecruitVo);

    /**
     * 根据ID查询店铺美容师
     *
     * @param id
     * @return
     */
    ResponseMessage<StoreBeautician> findById(int id);

    /**
     * 根据店铺ID查询店长
     *
     * @param storeId 店铺ID
     * @return
     */
    ResponseMessage<StoreBeautician> findByStoreIdForManager(int storeId);

    /**
     * 分页查询美容师（正式与兼职）
     *
     * @param pageNo                分页索引
     * @param pageSize              每页数量
     * @param fullTimeAndPartTimeVo 查询条件
     * @return
     */
    ResponseMessage<PageInfo<StoreBeautician>> findByPageForFullTimeAndPartTime(Integer pageNo, Integer pageSize, StoreBeaByFullTimeAndPartTimeVo fullTimeAndPartTimeVo);

    /**
     * 待审核美容师统计
     *
     * @param dataCountVo 条件
     * @return
     */
    ResponseMessage<Integer> pendingByCount(StoreByDataCountVo dataCountVo);

    /**
     * 明星美容师
     *
     * @param id     美容师ID
     * @param isStar 明星标记，1-是，0-否
     * @return
     */
    ResponseMessage star(int id, boolean isStar);

    /**
     * 批量明星美容师
     *
     * @param starBatchVo
     * @return
     */
    ResponseMessage starByBatch(BeauticianByStarBatchVo starBatchVo);


    /**
     * 根据店铺id 统计 工牌号相同的员工数量
     *
     * @param storeId 门店ID
     * @param workCardNo 工牌号
     * @param notId 不存在门店ID
     * @return
     */
    ResponseMessage workCardNoByStoreIdCount(int storeId, String workCardNo, int notId);

    /**
     * 修改员工信息 限定 工号牌不可重复
     *
     * @param storeBeautician 数据
     * @return
     */
    ResponseMessage editLimitWorkCardNoByStoreId(StoreBeautician storeBeautician);

    /**
     * 保存美容师
     *
     * @param beautician 美容师
     * @return
     */
    ResponseMessage<StoreBeautician> add(StoreBeautician beautician);

    /**
     * 修改美容师
     *
     * @param storeBeautician 美容师
     * @return
     */
    ResponseMessage modify(StoreBeautician storeBeautician);

    /**
     * 根据门店ID查询全职美容师
     *
     * @param storeId 门店ID
     * @return
     */
    ResponseMessage<List<StoreBeautician>> listFullTimeByStoreId(int storeId);

    /**
     * 累积成长值
     *
     * @param beauticianId 美容师ID
     * @param growthValue  成长值
     * @return
     */
    ResponseMessage accumulateGrowthValueV111(int beauticianId, int growthValue);

    /**
     * 上架项目选择美容师列表
     *
     * @param pageNo    分页索引
     * @param pageSize  每页数量
     * @param productVo 条件
     * @return
     */
    ResponseMessage<PageInfo<BeauticianListSelectOnSaleProductResVo>> listSelectOnSaleProduct(Integer pageNo, Integer pageSize, BeauticianListSelectOnSaleProductVo productVo);

}