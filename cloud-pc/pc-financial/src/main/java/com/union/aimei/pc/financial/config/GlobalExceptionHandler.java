package com.union.aimei.pc.financial.config;

import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


/**
 * GlobalExceptionHandler
 *
 * @author liufeihua
 * @date 2018/4/19 10:40
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


    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public ResponseMessage handleSQLException(HttpServletRequest request) {
        return new ResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SQL执行异常.");
    }
}
