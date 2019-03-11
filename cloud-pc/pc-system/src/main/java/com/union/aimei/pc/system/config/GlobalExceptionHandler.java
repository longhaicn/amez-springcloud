package com.union.aimei.pc.system.config;

import com.aliyuncs.exceptions.ClientException;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


/**
 * GlobalExceptionHandler
 *
 * @author liufeihua
 * @date 2018/1/2 16:26
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseException.class)
    @ResponseBody
    public ResponseMessage handleException(HttpServletRequest request, ResponseException ex) {
        String message = ex.getMessage();
        return new ResponseMessage(ex.getCode(), message);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseMessage hangdNullPointException(HttpServletRequest request, ResponseException ex) {
        String message = ex.getMessage();
        return new ResponseMessage(ex.getCode(), message);
    }

    @ExceptionHandler(ClientException.class)
    @ResponseBody
    public ResponseMessage clientException(HttpServletRequest request) {
        return new ResponseMessage(201, "啊里云错误");
    }

    @ExceptionHandler(UnsupportedEncodingException.class)
    @ResponseBody
    public ResponseMessage unsupportedEncodingException(HttpServletRequest request) {
        return new ResponseMessage(202, "啊里云错误");
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public ResponseMessage handleSQLException(HttpServletRequest request) {
        return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SQL执行异常.");
    }
}
