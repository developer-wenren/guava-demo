package com.one.guava;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.util.List;

/*
- 提供 Throwable 接口相关的工具方法

- Coding By One ON 09/02
*/
public class ThrowablesExample {

    /**
     * static List<Throwable> getCausalChain(Throwable throwable)
     * 获得异常链的list集合
     */
    @Test
    public void getCausalChainTest() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            List<Throwable> causalChain = Throwables.getCausalChain(e);
            System.out.println(causalChain);
            // [java.lang.ArithmeticException: / by zero]
        }
    }

    /**
     * static Throwable getRootCause(Throwable throwable)
     * 获取造成异常的顶层异常信息
     */
    @Test
    public void getRootCauseTest() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(Throwables.getRootCause(e));
            //java.lang.ArithmeticException: / by zero
        }
    }

    /**
     * static Throwable getStackTraceAsString(Throwable throwable)
     * 获取造成异常的所有栈信息
     */
    @Test
    public void getStackTraceAsStringTest() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
            //java.lang.ArithmeticException: / by zero
        }
    }

    /**
     * static void propagateIfPossible(Throwable throwable)
     */
    @Test
    public void propagateIfPossibleTest() throws ArithmeticException {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            Throwables.propagateIfPossible(e, ArithmeticException.class);
            throw new RuntimeException("unexpected", e);
            //java.lang.ArithmeticException: / by zero
        }
    }
}
