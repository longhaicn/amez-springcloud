package com.union.aimei.common.util.system;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.google.gson.Gson;
import com.union.aimei.common.constant.common.MongoConstant;
import com.union.aimei.common.constant.common.RedisConstant;
import com.union.aimei.common.constant.system.BaseHomeTemplateConstant;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.product.pc.ProductByCategoryRefVo;
import com.union.aimei.common.vo.system.app.*;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.common.utils.exception.ServerException;
import com.union.redis.RedisService;
import lombok.extern.apachecommons.CommonsLog;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 首页楼层数据缓存工具类
 *
 * @author caizhaoming
 * @create 2018-08-15 10:15
 **/

@Lazy
@Component
@CommonsLog
public class BaseHomeTemplateUtil {

    @Autowired
    private RedisService redisService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存基础楼层数据到缓存
     *
     * @param useType            用户类型
     * @param baseHomeTemplateRo 保存体
     * @param cityId             城市id
     */
    public void saveBaseHomeTemplateByRedis(Integer useType, BaseHomeTemplateRo baseHomeTemplateRo, Integer cityId) {
        String value = new Gson().toJson(baseHomeTemplateRo);
        switch (useType) {
            case SelectBaseHomeTemplateVo.USER_TYPE_USER:
                this.redisService.set(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_USER + "_" + String.valueOf(cityId), value);
                break;
            case SelectBaseHomeTemplateVo.USER_TYPE_HELP_GIRL:
                this.redisService.set(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_HELP_GIRL, value);
                break;
            case SelectBaseHomeTemplateVo.USER_TYPE_STORE_SIDE:
                this.redisService.set(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_STORE_SIDE, value);
                break;
            default:
                throw new ServerException(BaseHomeTemplateConstant.Query.NOT_TEMPALTE_CODE, BaseHomeTemplateConstant.Query.NOT_MESSAGE_BY_REDIS);
        }
    }


    /**
     * 在redis中获取楼层基本数据
     *
     * @param selectBaseHomeTemplateVo 查询对象
     * @return
     */
    public BaseHomeTemplateRo getBaseHomeTemplateByRedis(SelectBaseHomeTemplateVo selectBaseHomeTemplateVo) {
        BaseHomeTemplateRo baseHomeTemplateRo = null;
        String value = "";
        switch (selectBaseHomeTemplateVo.getUseType()) {
            case SelectBaseHomeTemplateVo.USER_TYPE_USER:
                String key = RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_USER + "_" + String.valueOf(selectBaseHomeTemplateVo.getBaseHomeArea().getCityId());
                boolean isExists = this.redisService.exists(key);
                if (isExists) {
                    log.info("*************** actual redis get data start *************** ");
                    long start = System.currentTimeMillis();
                    value = this.redisService.get(key).toString();
                    long end = System.currentTimeMillis();
                    log.info("actual get data time = " + (end - start));
                    log.info("*************** actual redis get data end *************** ");
                }
                break;
            case SelectBaseHomeTemplateVo.USER_TYPE_HELP_GIRL:
                boolean isExistsGirl = this.redisService.exists(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_HELP_GIRL);
                if (isExistsGirl) {
                    value = this.redisService.get(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_HELP_GIRL).toString();
                }
                break;
            case SelectBaseHomeTemplateVo.USER_TYPE_STORE_SIDE:
                boolean isExistsSide = this.redisService.exists(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_STORE_SIDE);
                if (isExistsSide) {
                    value = this.redisService.get(RedisConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_STORE_SIDE).toString();
                }
                break;
            default:
                throw new ServerException(BaseHomeTemplateConstant.Query.NOT_TEMPALTE_CODE, BaseHomeTemplateConstant.Query.NOT_MESSAGE_BY_REDIS);
        }
        //反序列化
        if (StringUtils.isNotEmpty(value)) {
            baseHomeTemplateRo = new Gson().fromJson(value, BaseHomeTemplateRo.class);
        }
        return baseHomeTemplateRo;
    }

    /**
     * 保存楼层数据到mongo
     *
     * @param baseHomeFloorPageRoList
     */
    public void saveBaseHomeFloorDataByMongo(List<BaseHomeFloorPageRo> baseHomeFloorPageRoList, Integer cityId) {
        if (null != baseHomeFloorPageRoList) {
            String collectionName = MongoConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_USER + "_" + cityId;
            //根据collectionName删除数据
            this.mongoTemplate.dropCollection(collectionName);
            //保存
            baseHomeFloorPageRoList.forEach(x -> {
                this.mongoTemplate.save(x, collectionName);
            });
        }
    }

    /**
     * 根据cityId获取楼层数据
     *
     * @param pageNo
     * @param pageSize
     * @param cityId
     * @return
     */
    public PageInfo<BaseHomeFloorPageRo> getBaseHomeFloorDataByMongo(Integer pageNo, Integer pageSize, Integer cityId) {
        String collectionName = MongoConstant.BaseHomeTemplate.BASE_HOME_TEMPLATE_USER_TYPE_USER + "_" + cityId;
        List<BaseHomeFloorPageRo> list = this.mongoTemplate.find(new Query().skip((pageNo - 1) * pageSize).limit(pageSize), BaseHomeFloorPageRo.class, collectionName);
        Long count = this.mongoTemplate.count(new Query(), collectionName);
        PageInfo page = new PageInfo();
        page.setList(list);
        page.setTotal(count);
        int pages = (int) (((count - 1) / pageSize) + 1);
        page.setPages(pages);
        return page;
    }

    /**
     * 根据商品list 设置楼层list里面所有商品的商品数据
     *
     * @param baseHomeFloorPageVoList
     * @param productInfoByList
     */
    public static void setProductInfoByFloorPageList(List<BaseHomeFloorPageVo> baseHomeFloorPageVoList, List<ProductByCategoryRefVo> productInfoByList) {
        if (null != baseHomeFloorPageVoList && null != productInfoByList) {
            Map<Integer, ProductByCategoryRefVo> idMap = productInfoByList.stream().collect(Collectors.toMap(ProductByCategoryRefVo::getId, Function.identity()));
            //插入项目名字、项目类型到集合内
            for (BaseHomeFloorPageVo baseHomeFloorPageVo : baseHomeFloorPageVoList) {
                for (BaseHomeFloorListVo baseHomeFloorListVo : baseHomeFloorPageVo.getBaseHomeFloorListVoList()) {
                    if (idMap.containsKey(baseHomeFloorListVo.getProductId())) {
                        ProductByCategoryRefVo productByCategoryRefVo = idMap.get(baseHomeFloorListVo.getProductId());
                        baseHomeFloorListVo.setProductName(productByCategoryRefVo.getServerName());
                        baseHomeFloorListVo.setProductClass(productByCategoryRefVo.getCategoryName());
                        baseHomeFloorListVo.setSalePrice(productByCategoryRefVo.getSalePrice());
                        baseHomeFloorListVo.setOriginalPrice(productByCategoryRefVo.getOriginalPrice());
                        baseHomeFloorListVo.setCoverImg(productByCategoryRefVo.getCoverImg());
                        baseHomeFloorListVo.setIsSupportHome(productByCategoryRefVo.getIsSupportHome());
                        baseHomeFloorListVo.setIsSupportStore(productByCategoryRefVo.getIsSupportStore());
                    }
                }
            }
        }
    }

    /**
     * 获取每个楼层里面的所有商品的id
     *
     * @param baseHomeFloorPageVoList
     * @return
     */
    public static Set<Integer> getProductIdByFloorVo(List<BaseHomeFloorPageVo> baseHomeFloorPageVoList) {
        Set<Integer> productIdSet = new HashSet<>();
        if (baseHomeFloorPageVoList != null && baseHomeFloorPageVoList.size() != 0) {
            baseHomeFloorPageVoList.forEach(x -> {
                if (null != x.getBaseHomeFloorListVoList() && x.getBaseHomeFloorListVoList().size() != 0) {
                    x.getBaseHomeFloorListVoList().forEach(y -> {
                        productIdSet.add(y.getProductId());
                    });
                }
            });
        }
        return productIdSet;
    }


    /**
     * 根据jsonArray获取里面的分类id
     *
     * @param jsonArray
     * @return
     */
    public static Set<Integer> getCategoryByJsonArray(JSONArray jsonArray) {
        Set<Integer> categorySet = new HashSet<>();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = JSONObject.fromObject(obj);
            String id = String.valueOf(jsonObject.get("id"));
            if (StringUtil.isNotEmpty(id)) {
                categorySet.add(Integer.parseInt(id));
            }
        }
        return categorySet;
    }

    /**
     * 根据旧的数组对象 获取一个新的商品分类数组对象
     *
     * @param productCategoryList
     * @return
     */
    public static JSONArray getNewProductCategoryByJsonArray(JSONArray jsonArray, List<ProductCategory> productCategoryList) {
        JSONArray newJSONArray = new JSONArray();
        if (null != productCategoryList) {
            Map<Integer, ProductCategory> productCategoryMap = productCategoryList.stream().collect(Collectors.toMap(ProductCategory::getId, Function.identity()));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(obj);
                String id = String.valueOf(jsonObject.get("id"));
                if (StringUtil.isNotEmpty(id)) {
                    Integer integerId = Integer.parseInt(id);
                    if (productCategoryMap.containsKey(integerId)) {
                        jsonObject.put("url", productCategoryMap.get(integerId).getCategoryLogo());
                        if (StringUtil.isNotEmpty(String.valueOf(jsonObject.get("name")))) {
                            jsonObject.put("name", productCategoryMap.get(integerId).getCategoryName());
                        }
                    }
                    newJSONArray.add(jsonObject);
                }
            }
        }
        return newJSONArray;
    }

    /**
     * 将首页模版基本数据类的vo转ro(去除重复相应数据)
     *
     * @param baseHomeTemplateVo
     * @return
     */
    public static BaseHomeTemplateRo packedToRo(BaseHomeTemplateVo baseHomeTemplateVo) {
        BaseHomeTemplateRo baseHomeTemplateRo = new BaseHomeTemplateRo();
        if (null != baseHomeTemplateVo) {
            Map<String, BaseHomeTemplateBaseRo> baseHomeTemplateMap = new HashMap<>(baseHomeTemplateVo.getBaseHomeTemplateMap().size());
            List<BaseHomeFloorRo> baseHomeFloorList = new ArrayList<>();
            if (null != baseHomeTemplateVo.getBaseHomeTemplateMap()) {
                baseHomeTemplateVo.getBaseHomeTemplateMap().forEach((k, v) -> {
                    BaseHomeTemplateBaseRo baseHomeTemplateBaseRo = new BaseHomeTemplateBaseRo();
                    BeanUtils.copyProperties(v, baseHomeTemplateBaseRo);
                    baseHomeTemplateMap.put(k, baseHomeTemplateBaseRo);
                });
            }
            if (null != baseHomeTemplateVo.getBaseHomeFloorList()) {
                baseHomeTemplateVo.getBaseHomeFloorList().forEach(x -> {
                    BaseHomeFloorRo baseHomeFloorRo = new BaseHomeFloorRo();
                    BeanUtils.copyProperties(x, baseHomeFloorRo);
                    baseHomeFloorList.add(baseHomeFloorRo);
                });
            }
            baseHomeTemplateRo.setBaseHomeFloorList(baseHomeFloorList);
            baseHomeTemplateRo.setBaseHomeTemplateMap(baseHomeTemplateMap);
        }
        return baseHomeTemplateRo;
    }

    /**
     * 将首页楼层数据的vo转 ro（去除重复相应数据）
     *
     * @param baseHomeFloorPageVo
     * @return
     */
    public static BaseHomeFloorPageRo packedToRo(BaseHomeFloorPageVo baseHomeFloorPageVo) {
        BaseHomeFloorPageRo baseHomeFloorPageRo = new BaseHomeFloorPageRo();
        if (null != baseHomeFloorPageVo) {
            List<BaseHomeFloorListRo> baseHomeFloorListRoList = new ArrayList<>();
            baseHomeFloorPageVo.getBaseHomeFloorListVoList().forEach(x -> {
                BaseHomeFloorListRo baseHomeFloorListRo = new BaseHomeFloorListRo();
                BeanUtils.copyProperties(x, baseHomeFloorListRo);
                baseHomeFloorListRoList.add(baseHomeFloorListRo);
            });
            BeanUtils.copyProperties(baseHomeFloorPageVo, baseHomeFloorPageRo);
            baseHomeFloorPageRo.setBaseHomeFloorListRoList(baseHomeFloorListRoList);
        }
        return baseHomeFloorPageRo;
    }


}
