package com.one.guava;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
- 包含一个not-null对象的不可变对象,用来表示null 不存在的值,帮助代码处理检查可以或者不可用来代替null的检查
- Coding By One ON 09/01
*/
public class OptionalExamples {
//    public static void main(String args[]) {
//        GuavaTester guavaTester = new GuavaTester();
//
//        Integer invalidInput = null;
//        Optional<Integer> a =  Optional.of(invalidInput);
//        Optional<Integer> b =  Optional.of(new Integer(10));
//        System.out.println(guavaTester.sum(a,b));
//    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }

    @Test
    public void optionalMehtod2absent() {
        Optional<Object> absent = Optional.absent();
        System.out.println(absent.isPresent()); // false
    }

    @Test
    public void optionalMehtod2asSet() {
        System.out.println("begin");
        Optional<String> haha = Optional.of("haha");
        System.out.println(haha.asSet());// [haha]
        Optional<Object> absent = Optional.absent();
        Set<Object> objects = absent.asSet();
        System.out.println(objects); //[]
        System.out.println(objects.isEmpty()); //true
        System.out.println("done");
    }

    @Test
    public void optionalMehtod2equals() {
        System.out.println("begin");
        Optional<Integer> num1 = Optional.of(5);
        Optional<Integer> num2 = Optional.of(5);
        System.out.println(num1.equals(num2)); // true
        System.out.println(num1.equals(null)); // false
        Optional<Integer> empty1 = Optional.absent();
        Optional<Integer> empty2 = Optional.absent();
        System.out.println(empty1.equals(empty2)); // true
        System.out.println(empty1.equals(null)); // false

        System.out.println("done");
    }

    @Test
    public void optionalMehtod2fromNullable() {
        System.out.println("begin");
        String a = null;
        Optional<String> stringOptional = Optional.fromNullable(a);
        System.out.println(stringOptional.isPresent()); // false
        a = "5";
        Optional<String> secondOptional = Optional.fromNullable(a);
        System.out.println(secondOptional.isPresent()); // false
        System.out.println(secondOptional.get()); // 5
        System.out.println("end");

    }

    @Test
    public void optionalMehtod2hashCode() {
        System.out.println("begin");
        Optional<String> abc = Optional.of("abc");
        System.out.println(abc.hashCode()); // 1502572926
        System.out.println("end");
    }

    @Test
    public void optionalMehtod2or() {
        System.out.println("begin");
        Integer a = null;
        Optional<Integer> integerOptional = Optional.fromNullable(a);
        System.out.println(integerOptional.or(5)); // 5
        Optional<Integer> integer2Optional = Optional.fromNullable(5);
        System.out.println(integer2Optional.or(integer2Optional)); //Optional.of(5)
        System.out.println("end");
    }

    @Test
    public void optionalMehtod2orNull() {
        System.out.println("begin");
        Optional<Integer> integerOptional = Optional.of(5);
        System.out.println(integerOptional.orNull());// 5
        integerOptional = Optional.fromNullable(null);
        System.out.println(integerOptional.orNull());// null

        System.out.println("done");
    }

    @Test
    public void optionalMehtod2presentInstances() {
        System.out.println("begin");
        List<Optional<String>> list = new ArrayList<>();
        list.add(Optional.of("5"));
        list.add(Optional.<String>absent());
        list.add(Optional.of("7"));
        Iterable<String> objects = Optional.presentInstances(list);
        for (Object obj : objects) {
            System.out.println(obj);
        }
        // 5,7
    }

    @Test
    public void optionalMehtod2transform() {
        Optional<Integer> integerOptional = Optional.of(5);
        Function<? super Integer, Integer> function = new Function<Integer, Integer>() {
            @NullableDecl
            @Override
            public Integer apply(@NullableDecl Integer input) {
                return input * 2;
            }
        };
        Optional<Integer> transform = integerOptional.transform(function);
        System.out.println(transform); // 10

    }


}
