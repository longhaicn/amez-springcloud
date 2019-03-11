package com.union.aimei.remote;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.union.aimei.remote.config.AmezRequestConstant;
import com.union.aimei.remote.config.AmezRequestProperties;
import com.union.aimei.remote.config.AmezRequestUrl;
import com.union.aimei.remote.encrypt.Md5Util;
import com.union.aimei.remote.model.*;
import com.union.aimei.remote.util.InetUtil;
import com.union.aimei.remote.util.OkHttp3Util;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.exception.ServerException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/**
 * @author GaoWei
 * @describe 调用艾美一族接口获取返回数据
 * @time 2018/4/11,14:59
*/
@Service
@CommonsLog
public class AmezResponseImpl implements AmezResponse {

    private static final String APP_SYSTEM="200";
    private static final String API= AmezRequestConstant.Path.API;
    private static final String ACCESS_TOKEN= AmezRequestConstant.Path.ACCESS_TOKEN;
    private static final String SUCCESS="success";

    @Resource
    private AmezRequestUrl amezRequestUrl;
    @Resource
    private AmezRequestProperties amezRequestProperties;

    /**
     * 获取accessToken
     * @return
     */
    @Override
    public String getAccessToken(){
        String accessToken="";
        String url=amezRequestUrl.getRequestUrl(ACCESS_TOKEN, AmezRequestConstant.InterfaceName.ACCESS_TOKEN,null);
        JsonObject json=new JsonObject();
        String nonecestr = Md5Util.getRandom(32);
        long time = System.currentTimeMillis();
        json.addProperty("accessKey", amezRequestProperties.getAccessKey());
        json.addProperty("nonecestr", nonecestr);
        json.addProperty("time", time);
        json.addProperty("encrypteStr", Md5Util.getEncrypteStr(amezRequestProperties.getAccessKey(), nonecestr, time, amezRequestProperties.getSecurity()));
        String str= OkHttp3Util.doPost(url,json.toString(),"");
        if(str!=null){
            JsonObject jsonObject=new Gson().fromJson(str,JsonObject.class);
            boolean success="SUCCESS".equals(jsonObject.get("status").getAsString());
            if (success) {
                accessToken = jsonObject.get("data").getAsJsonObject().get("microserviceAccessToken").getAsString();
            }
        }else{
            throw new ServerException(500,"网络异常，请稍后重试");
        }
        return accessToken;
    }

    /**
     * 会员注册
     * @param mrbMemberLoginVo
     * @return
     */
    @Override
    public ResultVo<MemberResult> memberLogin(MrbMemberLoginVo mrbMemberLoginVo){
        Integer loginType=mrbMemberLoginVo.getLoginType();
        JsonObject jsonObject=new JsonObject();
        if(0==loginType){
            jsonObject.addProperty("mobile",mrbMemberLoginVo.getMobile());
        }else if(1==loginType){
            jsonObject.addProperty("mobile",mrbMemberLoginVo.getMobile()==null?"":mrbMemberLoginVo.getMobile());
            jsonObject.addProperty("userName",mrbMemberLoginVo.getUserName());
            jsonObject.addProperty("password",mrbMemberLoginVo.getPassword());
        }
        jsonObject.addProperty("appSystem",APP_SYSTEM);
        jsonObject.addProperty("ip",mrbMemberLoginVo.getIp()==null?"":mrbMemberLoginVo.getIp());
        jsonObject.addProperty("source",mrbMemberLoginVo.getSource()==null?"":mrbMemberLoginVo.getSource());
        String url=amezRequestUrl.getRequestUrl(API,AmezRequestConstant.InterfaceName.REGISTER_BY_USER,null);
        String accessToken=getAccessToken();
        String jsonObj= OkHttp3Util.doPost(url,jsonObject.toString(),accessToken);
        ResultVo<MemberResult> resultResultVo=null;
        if(jsonObj!=null){
            Gson gson=new Gson();
            Type listType = new TypeToken<ResultVo<MemberResult>>(){}.getType();
            resultResultVo=gson.fromJson(jsonObj,listType);
        }
        return resultResultVo;
    }


    @Override
    public ResultVo<AmezMemberInfoVo> queryMemberMoreInfo(MrbMemberLoginVo memberRegisterVo) {
        Integer loginType=memberRegisterVo.getLoginType();
        JsonObject jsonObject=new JsonObject();
        if(0==loginType){
            jsonObject.addProperty("mobile",memberRegisterVo.getMobile());
        }else if(1==loginType){
            jsonObject.addProperty("userName",memberRegisterVo.getUserName());
            jsonObject.addProperty("password",memberRegisterVo.getPassword());
        }
        String url=amezRequestUrl.getRequestUrl(API,AmezRequestConstant.InterfaceName.FIND_BY_MOBILE_OR_USERNAME,null);
        String accessToken=getAccessToken();
        String jsonObj= OkHttp3Util.doPost(url,jsonObject.toString(),accessToken);
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<AmezMemberInfoVo>>(){}.getType();
        ResultVo<AmezMemberInfoVo> resultVo=gson.fromJson(jsonObj,listType);
        return resultVo;
    }


    @Override
    public ResultVo<MemberResult>  initLoginPwdByUuid(String uuid, String password,String ip, String source) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uuid",uuid);
        jsonObject.addProperty("password",password);
        jsonObject.addProperty("ip",ip);
        jsonObject.addProperty("source",source);
        String url=amezRequestUrl.getRequestUrl(API,AmezRequestConstant.InterfaceName.INIT_SET_LOGIN_PASSWORD_BY_UUID,null);
        String jsonObject1= OkHttp3Util.doPost(url,jsonObject.toString(),getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<MemberResult>>(){}.getType();
        ResultVo<MemberResult> resultResultVo=gson.fromJson(jsonObject1,listType);
        return resultResultVo;
    }

    @Override
    public ResultVo<Boolean> initPayPassword(String uuid, String payPassword, String ip, String source) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uuid",uuid);
        jsonObject.addProperty("payPassword",payPassword);
        jsonObject.addProperty("ip",ip);
        jsonObject.addProperty("source",source);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.INIT_SET_PAY_PASSWORD_BY_UUID,null);
        String json= OkHttp3Util.doPost(url,jsonObject.toString(),getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<Boolean>>(){}.getType();
        ResultVo<Boolean>   resultVo=gson.fromJson(json,listType);
        return resultVo;
    }


    @Override
    public ResultVo<MemberResult> updateLoginPassword(String uuid, String oldPassWord, String newPassword, String ip) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uuid",uuid);
        jsonObject.addProperty("oldLoginPassword",oldPassWord);
        jsonObject.addProperty("password",newPassword);
        jsonObject.addProperty("ip",ip);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.UPDATE_LOGIN_PASSWORD_BY_UUID,null);
        String jsonObject1= OkHttp3Util.doPost(url,jsonObject.toString(),getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<MemberResult>>(){}.getType();
        ResultVo<MemberResult>   resultResultVo=gson.fromJson(jsonObject1,listType);
        return resultResultVo;
    }

    @Override
    public ResultVo<Boolean> updatePayPassword(String uuid, String oldPayPassWord, String newPayPassword, String ip) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uuid",uuid);
        jsonObject.addProperty("oldPayPassword",oldPayPassWord);
        jsonObject.addProperty("payPassword",newPayPassword);
        jsonObject.addProperty("ip",ip);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.UPDATE_PAY_PASSWORD_BY_UUID,null);
        String json= OkHttp3Util.doPost(url,jsonObject.toString(),getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<Boolean>>(){}.getType();
        ResultVo<Boolean> resultVo=gson.fromJson(json,listType);
        return resultVo;
    }

    @Override
    public ResultVo<Boolean> matchPayPassword(String uuid, String payPassword) {
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uuid",uuid);
        jsonObject.addProperty("payPassword",payPassword);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.MATCH_PAY_PASSWORD,null);
        String json= OkHttp3Util.doPost(url,jsonObject.toString(),getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<Boolean>>(){}.getType();
        ResultVo<Boolean> resultVo=gson.fromJson(json,listType);
        return resultVo;
    }

    @Override
    public String getForgetCode(String uuid, String accessToken, int type) {
        List<String> list=new LinkedList<>();
        list.add(uuid);
        list.add(String.valueOf(type));
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.GET_FORGET_PWD_CODE,list);
        String str= OkHttp3Util.doGet(url,accessToken);
        JsonObject json=new Gson().fromJson(str,JsonObject.class);
        Optional.ofNullable(json)
                .filter(x->x.get("data")!=null)
                .orElseThrow(()->new ServerException(500,json.get("msg").getAsString()));
        JsonObject jsonObject=json.get("data").getAsJsonObject();
        String resultVo=jsonObject.get("forgetCode").getAsString();
        return resultVo;
    }


    @Override
    public ResultVo<MemberResult> resetUpdateLoginPasswordByUuid(String uuid, String pwd, String forgetPwdCode, String ip, int source,String token) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uuid", uuid);
        jsonObject.addProperty("password", pwd);
        jsonObject.addProperty("foregetPwdCode", forgetPwdCode);
        jsonObject.addProperty("ip", ip);
        jsonObject.addProperty("source", source);
        String url = amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.RESET_UPDATE_LOGIN_PASSWORD_BY_UUID, null);
        String json = OkHttp3Util.doPost(url, jsonObject.toString(), token);
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<MemberResult>>(){}.getType();
        ResultVo<MemberResult>resultResultVo=gson.fromJson(json,listType);
        return resultResultVo;

    }

    @Override
    public ResultVo<Boolean> resetUpdatePayPasswordByUuid(String uuid, String payPwd, String forgetPwdCode, String ip, int source, String token) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uuid", uuid);
        jsonObject.addProperty("payPassword", payPwd);
        jsonObject.addProperty("foregetPwdCode", forgetPwdCode);
        jsonObject.addProperty("ip", ip);
        jsonObject.addProperty("source", source);
        String url = amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.RESET_UPDATE_PAY_PASSWORD_BY_UUID, null);
        String json = OkHttp3Util.doPost(url, jsonObject.toString(), token);
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<Boolean>>(){}.getType();
        ResultVo<Boolean> resultResultVo=gson.fromJson(json,listType);
        return resultResultVo;
    }

    @Override
    public ResultVo<MemberBalanceVo> queryMemberBalance(String uuid) {
        List<String> list=new LinkedList<>();
        list.add(uuid);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.QUERY_MEMBER_BALANCE,list);
        String jsonObject= OkHttp3Util.doGet(url,getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<MemberBalanceVo>>(){}.getType();
        ResultVo<MemberBalanceVo> resultVo=gson.fromJson(jsonObject,listType);
        return resultVo;
    }


    @Override
    public ResultVo<List<MemberOneCardVo>> queryMemberOneCardInfo(String uuid) {
        List<String> list=new LinkedList<>();
        list.add(uuid);
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.QUERY_MEMBER_ONE_CARD_INFO,list);
        String jsonObject= OkHttp3Util.doGet(url,getAccessToken());
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<List<MemberOneCardVo>>>(){}.getType();
        ResultVo<List<MemberOneCardVo>> resultVo=gson.fromJson(jsonObject,listType);
        return resultVo;
    }


    @Override
    public ResultVo<PayRecordVo> createAmezPlatOrder(String token, TradeVo tradeVo, double payPrice) {
        JsonObject json=new JsonObject();
        json.addProperty("appSystem","200");
        json.addProperty("ip", InetUtil.getIp());
        json.addProperty("memberId",tradeVo.getAmUserId());
        json.addProperty("payPrice",payPrice);
        json.addProperty("orderNo",tradeVo.getOrderNo());
        if(tradeVo.getPayType()==TradeVo.PayType.ONE_CARD_PAY){
            json.addProperty("payCardId",tradeVo.getAmPayCardId());
        }
        json.addProperty("payType",tradeVo.getPayType());
        String url=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.CREATE_THIRD_PARTY_ORDER,null);
        String jsonObject= OkHttp3Util.doPost(url,json.toString(),token);
        Gson gson=new Gson();
        Type listType = new TypeToken<ResultVo<PayRecordVo>>(){}.getType();
        ResultVo<PayRecordVo> resultVo=gson.fromJson(jsonObject,listType);
        return resultVo;
    }


    @Override
    public String getPreResult(String orderNo, String tradeNo, String payPassword, String token, Integer payType, Integer memberId) {
        JsonObject json=new JsonObject();
        json.addProperty("appSystem","200");
        json.addProperty("orderNo",orderNo);
        json.addProperty("tradeNo",tradeNo);
        json.addProperty("payPassword",payPassword);
        json.addProperty("spbillCreateIp", InetUtil.getIp());
        json.addProperty("memberId",memberId);
        String requestUrl="";
        if(TradeVo.PayType.ONE_CARD_PAY==payType){
            requestUrl=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.ONE_CARD_PAY,null);
        }else if(TradeVo.PayType.BANLANCE_PAY==payType){
            requestUrl=amezRequestUrl.getRequestUrl(API, AmezRequestConstant.InterfaceName.BALANCE_PAY,null);
        }
        String jsonObject= OkHttp3Util.doPost(requestUrl,json.toString(),token);
        return jsonObject;
    }


    @Override
    public ResponseMessage refund(RefundParamVo vo) {
        String requestUrl=amezRequestUrl.getRequestUrl(API,AmezRequestConstant.InterfaceName.REFUND,null);
        log.info("请求地址："+requestUrl);
        String token=getAccessToken();
        log.info("请求token："+token);
        String json=new Gson().toJson(vo,RefundParamVo.class);
        log.info("请求json："+json);
        String jsonObject=OkHttp3Util.doPost(requestUrl,json,token);
        log.info("艾美返回："+jsonObject);
        String status=new Gson().fromJson(jsonObject,JsonObject.class).get("status").getAsString();
        log.info("返回状态为："+status);
        String msg=new Gson().fromJson(jsonObject,JsonObject.class).get("msg").getAsString();
        log.info("返回信息为："+msg);
        ResponseMessage res=ResponseMessageFactory.newInstance();
        if(!SUCCESS.equalsIgnoreCase(status)){
            res.setCode(500);
            res.setMessage(msg);
        }
        log.info("返回数据为:"+res);
        return res;
    }
}
