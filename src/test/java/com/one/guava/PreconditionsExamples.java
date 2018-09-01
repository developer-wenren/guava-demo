package com.one.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

/*
- Preconditions 用来检查方法或者构造器的参数是否正确,
- 若不符合期望,则会抛出 IllegalArgumentException 异常
- Coding By One ON 09/01
*/
public class PreconditionsExamples {


    /**
     * 检查一个或者多个参数的正确性,若expression为false,则抛异常
     * static void checkArgument(boolean expression)
     */
    @Test
    public void checkArgumentTest() {
        Preconditions.checkArgument(1==1);
        Preconditions.checkArgument(1==2);
    }

    /**
     * 检查一个或者多个参数的正确性,若expression为false,则抛出异常,允许自定义异常描述
     * static void checkArgument(boolean expression)
     * static void checkArgument(boolean expression, Object errorMessage)
     * static void checkArgument(boolean expression, String errorMessageTemplate, Object. errorMessageArgs)
     */
    @Test
    public void checkArgumentMessageTest() {
        Preconditions.checkArgument(1==2,"两者不相等");
    }

    /**
     * 检查一个或者多个参数的正确性,若expression为false,可以根据模板,抛出带变量信息的异常
     * static void checkArgument(boolean expression, String errorMessageTemplate, Object. errorMessageArgs)
     */
    @Test
    public void checkArgumentMessageTemplateTest() {
        Preconditions.checkArgument(1 == 2, "%s,%s不相等",1,2);
    }

    /**
     * 检查访问数组的索引是否超过其大小,若超过则抛异常
     * static int	checkElementIndex(int index, int size)
     * static int checkElementIndex(int index, int size, String desc)
     */
    @Test
    public void checkElementIndexTest() {
        String[] strings = new String[6];
        Preconditions.checkElementIndex(5,strings.length);
        Preconditions.checkElementIndex(6,strings.length);
    }

    /**
     * 检查访问数组的索引是否超过其大小,若超过则抛带描述信息的异常
     * static int checkElementIndex(int index, int size, String desc)
     */
    @Test
    public void checkElementIndexDescTest() {
        String[] strings = new String[6];
        Preconditions.checkElementIndex(6,strings.length,"访问索引过界");
    }

    /**
     * 检查引用是否为null,若为null抛异常
     * static <T> T checkNotNull(T reference)
     * static <T> T checkNotNull(T reference, Object errorMessage)
     * static <T> T checkNotNull(T reference, String errorMessageTemplate, Object... errorMessageArgs)
     */
    @Test
    public void checkNotNullTest() {
        String a= null;
//        Preconditions.checkNotNull(a);
//        Preconditions.checkNotNull(a,"a不能为null");
        Preconditions.checkNotNull(a,"a变量不能为%s",a);

    }

    /**
     * 检查索引是否在指定数组、列表或大小字符串中的有效位置,否则抛异常
     * static int	checkPositionIndex(int index, int size)
     * static int checkPositionIndex(int index, int size, String desc)
     */
    @Test
    public void checkPositionIndexTest() {
        String string = "abcd";
        int size = string.length();
        int index = 5;
//        Preconditions.checkPositionIndex(index,size);
        Preconditions.checkPositionIndex(index,size,"超过字符串长度");
    }

    /**
     * 用于检查状态变量的正确性,不正确则抛异常处理,允许对异常描述信息自定义
     * static void checkState(boolean expression)
     * static void checkState(boolean expression, Object errorMessage)
     * static void checkState(boolean expression, Object errorMessage)
     */
    @Test
    public void checkStateTest() {
        boolean isTrue = false;
//        Preconditions.checkState(isTrue);
//        Preconditions.checkState(isTrue,"flag is false");
        Preconditions.checkState(isTrue,"flag is %s",isTrue);
    }

}
