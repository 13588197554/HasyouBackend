package com.fly.handler;

import com.fly.exception.ModelNotFoundException;
import com.fly.pojo.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author david
 * @date 27/08/18 14:15
 */
@ControllerAdvice
public class IntegrateExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        Result result = new Result();
        result.error(501, e.getMessage(), e.getStackTrace());
        return result;
    }

}