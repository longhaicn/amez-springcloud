package com.union.aimei.pc.api.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.ExpressCompanyFeign;
import com.union.aimei.common.model.order.ExpressCompany;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 快递公司信息表
 *
 * @author liurenkai
 * @time 2018/8/22 15:45
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Api(tags = "快递公司信息表")
@RestController
@RequestMapping(value = "expressCompany")
public class ExpressCompanyApiController {


    @Resource
    private ExpressCompanyFeign expressCompanyFeign;

    /**
     * 分页查询
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param expressCompany 查询条件
     * @return ResponseMessage<ExpressCompany>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询快递公司信息表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<ExpressCompany>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                      Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                      Integer pageSize, @ApiParam(value = "查询条件") @RequestBody ExpressCompany expressCompany) {

        return expressCompanyFeign.findByPageForFront(pageNo, pageSize, expressCompany);
    }

    /**
     * 添加ExpressCompany
     *
     * @param expressCompany
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "添加快递公司信息表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody ExpressCompany expressCompany) {
        ResponseMessage res=new ResponseMessage();
        expressCompanyFeign.insert(expressCompany);
        return res;
    }

    /**
     * 删除ExpressCompany
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除快递公司信息表")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        ResponseMessage res=new ResponseMessage();
        expressCompanyFeign.deleteById(id);
        return res;
    }

    /**
     * 修改ExpressCompany
     *
     * @param expressCompany
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑快递公司信息表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody ExpressCompany expressCompany) {
        ResponseMessage res=new ResponseMessage();
        expressCompanyFeign.edit(expressCompany);
        return res;
    }

    /**
     * 根据ID查询ExpressCompany
     *
     * @param id
     * @returnexpressCompany
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询快递公司信息表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<ExpressCompany> queryById(@PathVariable(value = "id") int id) {
        ResponseMessage res=new ResponseMessage();
        expressCompanyFeign.queryById(id);
        return res;
    }
}