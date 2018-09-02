package com.one.guava;

import com.google.common.base.Objects;
import org.junit.Test;

/*
- 提供帮助函数，适用于所有对象
- Coding By One ON 09/02
*/
public class ObjectsExamples {

    /**
     * static boolean	equal(Object a, Object b)
     * 判断两对象是否相同
     */
    @Test
    public void equalTest() {
        String a = "a";
        String A = null;
        boolean equal = Objects.equal(a, A);
        System.out.println(equal); //false
        A = "a";
        equal = Objects.equal(a, A);
        System.out.println(equal);//true
        System.out.println(Objects.equal(null,null ));//true

    }

    /**
     * static int hashCode(Object... objects)
     * 为多个值生成一个哈希代码。
     */
    @Test
    public void hashCodeTest() {
        String a= "a";
        String b= "b";
        String c= "c";
        int i = Objects.hashCode(a, b, c);
        System.out.println(i); //126145
    }



}
