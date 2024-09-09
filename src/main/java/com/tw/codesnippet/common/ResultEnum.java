package com.tw.codesnippet.common;

public enum ResultEnum implements IResult {

    SUCCESS(2001, "接口调用成功"),

    FAILED(2002, "接口调用失败"),

    VALIDATE_FAILED(2003, "参数校验失败"),

    FORBIDDEN(2004, "禁止访问")

    ;

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
