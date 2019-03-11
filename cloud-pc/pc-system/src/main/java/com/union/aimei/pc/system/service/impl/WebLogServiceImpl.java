//package com.union.aimei.pc.system.service.impl;
//
//import com.union.aimei.common.model.system.WebLog;
//import com.union.aimei.pc.system.service.WebLogService;
//import com.union.aimei.common.vo.system.WebLogVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Service;
//
///**
// * WebLogServiceImpl
// *
// * @author liufeihua
// * @date 2018/4/11 11:29
// */
//@Service
//public class WebLogServiceImpl implements WebLogService {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void save(WebLog log) {
//        mongoTemplate.save(log);
//    }
//
//    @Override
//    public WebLogVo findList(Integer pageNo, Integer pageSize, WebLog record) {
//        WebLogVo response = new WebLogVo();
//
//        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
//
//        Criteria criteria = null;
//        if (record != null) {
//            if (record.getRequestURL() != null) {
//                criteria = Criteria.where("requestURL").is(record.getRequestURL());
//            }
//            if (record.getRequestURI() != null) {
//                criteria = Criteria.where("requestURI").is(record.getRequestURI());
//            }
//            if (record.getQueryString() != null) {
//                criteria = Criteria.where("queryString").is(record.getQueryString());
//            }
//            if (record.getRemoteAddr() != null) {
//                criteria = Criteria.where("remoteAddr").is(record.getRemoteAddr());
//            }
//            if (record.getRemoteHost() != null) {
//                criteria = Criteria.where("remoteHost").is(record.getRemoteHost());
//            }
//            if (record.getRemotePort() != null) {
//                criteria = Criteria.where("remotePort").is(record.getRemotePort());
//            }
//            if (record.getLocalAddr() != null) {
//                criteria = Criteria.where("localAddr").is(record.getLocalAddr());
//            }
//            if (record.getLocalName() != null) {
//                criteria = Criteria.where("localName").is(record.getLocalName());
//            }
//            if (record.getMethod() != null) {
//                criteria = Criteria.where("method").is(record.getMethod());
//            }
//            if (record.getHeaders() != null) {
//                criteria = Criteria.where("headers").is(record.getHeaders());
//            }
//            if (record.getParameters() != null) {
//                criteria = Criteria.where("parameters").is(record.getParameters());
//            }
//            if (record.getClassMethod() != null) {
//                criteria = Criteria.where("classMethod").is(record.getClassMethod());
//            }
//            if (record.getArgs() != null) {
//                criteria = Criteria.where("args").is(record.getArgs());
//            }
//            if (record.getOperateId() != null) {
//                criteria = Criteria.where("operateId").is(record.getOperateId());
//            }
//            if (record.getOperateName() != null) {
//                criteria = Criteria.where("operateName").is(record.getOperateName());
//            }
//        }
//
//        if (criteria != null) {
//            response.setTotal(mongoTemplate.find(new Query(criteria).with(sort), WebLog.class).size());
//            response.setList(mongoTemplate.find(new Query(criteria).with(sort).skip(pageNo).limit(pageSize), WebLog.class));
//        } else {
//            response.setTotal(mongoTemplate.find(new Query().with(sort), WebLog.class).size());
//            response.setList(mongoTemplate.find(new Query().with(sort).skip(pageNo).limit(pageSize), WebLog.class));
//        }
//
//        return response;
//    }
//
//
//}
