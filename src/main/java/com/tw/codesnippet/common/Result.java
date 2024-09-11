package com.tw.codesnippet.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        return success(ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static Result<?> failed() {
        return failed(ResultEnum.FAILED.getMessage());
    }

    public static Result<?> failed(String message) {
        return failed(ResultEnum.FAILED.getCode(), message);
    }

    public static Result<?> failed(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static Result<?> failed(IResult result) {
        return new Result<>(result.getCode(), result.getMessage(), null);
    }
}
