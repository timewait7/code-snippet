package com.tw.codesnippet.style;

public class GuardClause {

    /**
     * 卫语句用于检查某些前置条件，如果条件不满足，直接返回或抛出异常，避免继续执行后续的代码块。
     * 通过使用卫语句，可以减少代码的嵌套程度，提高代码的可读性和可维护性。
     *
     * @param str
     */
    public void processOrder(String str) {
        // 检查订单是否为空
        if (str == null) {
            return; // 使用卫语句直接返回
        }

        // 检查订单状态
        if (str.equals("")) {
            return; // 使用卫语句直接返回
        }

        // 执行订单处理逻辑
        // ...
    }
}
