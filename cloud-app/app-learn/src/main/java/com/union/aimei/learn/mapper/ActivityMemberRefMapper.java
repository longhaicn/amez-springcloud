package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.ActivityMemberRef;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefDetailsVo;
import com.union.aimei.common.vo.learn.app.ActivityMemberRefVo;
import com.union.aimei.common.vo.learn.app.CheckRepeatActivityVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/13  11:46
 */
public interface ActivityMemberRefMapper extends BaseMapper<ActivityMemberRef> {

    /**
     * 检查用户是否重复报名
     * @param checkRepeatActivityVo
     * @return
     */
    public int checkRepeatActivity(CheckRepeatActivityVo checkRepeatActivityVo);

    /**
     * 批量添加用户报名信息
     * @param list
     */
    public void insertBatch(@Param("list")List<ActivityMemberRef> list);

    /**
     * 根据交易记录id来修改活动的报名状态
     * @param tradeRefId
     * @return
     */
    int updateStatusByTradeRefId(@Param("tradeRefId") Integer tradeRefId);


    /**
     * 查询美容师报名是否重复
     * @param activityMemberRefVo
     * @return
     */
    List<ActivityMemberRef> selectRepeatBeauticianIdBatch(ActivityMemberRefVo activityMemberRefVo);


    /**
     * 门店(美容师)查询活动报名详情
     * @param activityMemberRefDetailsVo
     * @return
     */
    List<ActivityMemberRefDetailsVo> queryActivityMemberRefDetail(ActivityMemberRefDetailsVo activityMemberRefDetailsVo);

}