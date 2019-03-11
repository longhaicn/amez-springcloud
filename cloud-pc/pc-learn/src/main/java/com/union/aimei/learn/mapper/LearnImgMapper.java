package com.union.aimei.learn.mapper;

import com.union.aimei.common.model.learn.LearnImg;
import com.union.aimei.common.vo.learn.pc.LearnImgParamVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author caizhaoming
 * @create 2018-05-10 10:49
 **/
public interface LearnImgMapper extends BaseMapper<LearnImg> {
    /**
     * 批量添加主图
     *
     * @param map
     */
    void insertBatch(Map<String, Object> map);

    /**
     * 根据条件查询图片数据
     *
     * @param learnImgParamVo
     * @return
     */
    List<LearnImg> selectImgByConditions(LearnImgParamVo learnImgParamVo);

    /**
     * 根据条件查询主图url
     *
     * @param learnImg
     * @return
     */
    List<String> queryImgListByLearnImg(LearnImg learnImg);

    /**
     * 根据LearnImg来查询url集合
     *
     * @param learnImg
     * @return
     */
    List<String> findUrlListByLearnImg(LearnImg learnImg);

    /**
     * 批量添加图片
     *
     * @param list
     * @return
     */
    int addBatch(@Param(value = "list") List<LearnImg> list);

    /**
     * 批量根据id删除数据
     *
     * @param list
     * @return
     */
    int deleteByPrimaryKeyList(List<Integer> list);

    /**
     * 根据sourceId来删除图片
     *
     * @param sourceId 来源id
     */
    void deleteBySourceId(@Param("sourceId") Integer sourceId);

    /**
     * 根据sourceId和sourceType来删除图片
     *
     * @param map 集合参数
     */
    void deleteBySourceIdAndSourceType(Map<String, Integer> map);

}