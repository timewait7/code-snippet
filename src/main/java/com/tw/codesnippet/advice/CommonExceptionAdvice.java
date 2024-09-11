package com.tw.codesnippet.advice;

import com.tw.codesnippet.common.Result;
import com.tw.codesnippet.common.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice("com.tw.codesnippet")
public class CommonExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final BindingResult bindingResult = ex.getBindingResult();
        String msg = bindingResult.getFieldError().getField() + ":" + bindingResult.getFieldError().getDefaultMessage();
        return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), msg);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return Result.failed(ResultEnum.VALIDATE_FAILED.getCode(), ex.getMessage());
    }
}
