package com.one.guava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Test;

import java.util.*;

/*
- Ordering 类具具有增强的链式方法,多个工具方法,和多类型排序
- Coding By One ON 09/01
*/
public class OrderingExamples {

    /**
     * static Ordering<Object> allEqual()
     * 返回一个 Ordering 对象,其表示在排序算法中不会改变元素的顺序
     */
    @Test
    public void allEqualTest() {
        Ordering<Object> objectOrdering = Ordering.allEqual();
        System.out.println(objectOrdering);
        List<Integer> numbers = new ArrayList<Integer>();

    }

    /**
     * static Ordering<Object> arbitrary()
     * 返回一个Ordering对象,排序任意
     */
    @Test
    public void arbitrayTest() {
        Ordering<Object> arbitrary = Ordering.arbitrary();
        List<String> list = new ArrayList<>();
        list.add("k");
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        Collections.sort(list, arbitrary);
        System.out.println(list);
    }

    /**
     * abstract int compare(T left, T right)
     * 比较两个元素
     */
    @Test
    public void binarySearchTest() {
        Ordering<Object> arbitrary = Ordering.arbitrary();
        String a = "a";
        String b = "b";
        int compare = arbitrary.compare(b, a);
        System.out.println(compare); //1 表示前者大于后者

    }

    /**
     * <U extends T> Ordering<U> compound(Comparator<? super U> secondaryComparator)
     */
    @Test
    public void compoundTest() {
        Ordering<Object> arbitrary = Ordering.arbitrary();
        Iterable<? extends Comparator<? super Object>> second = null;
//        Ordering<Object> compound = arbitrary.compound(second);

    }

    /**
     * <E extends T> E max(Iterator<E> iterator)
     * <E extends T> E max(Iterable<E> iterable)
     * <E extends T> E max(E a, E b)
     * <E extends T> E max(E a, E b, E c, E... rest)
     * 取两个比较对象的最大值
     */
    @Test
    public void maxTest() {
        Ordering<Comparable> natural = Ordering.natural();
        Integer max = natural.max(2, 8);
        System.out.println(max);

    }

    /**
     * <E extends T> E min(Iterator<E> iterator)
     * <E extends T> E min(Iterable<E> iterable)
     * <E extends T> E min(E a, E b)
     * <E extends T> E min(E a, E b, E c, E... rest)
     * 取两个比较对象的最大值
     */
    @Test
    public void minTest() {
        Ordering<Comparable> natural = Ordering.natural();
        Integer min = natural.min(2, 8);
        System.out.println(min);
    }

    /**
     * static <C extends Comparable> Ordering<C> natural()
     * 返回一个Ordering 对象,可序列化且使用值的自然顺序排序
     */
    @Test
    public void naturalTest() {
        Ordering<Comparable> natural = Ordering.natural();
        System.out.println(natural);
    }

    /**
     * <S extends T> Ordering<S> nullsFirst()
     * 返回一个Ordering对象,会将null视为最小值进行排序
     */
    @Test
    public void nullsFirstTest() {
        Ordering<Comparable> natural = Ordering.natural();
        Ordering<Comparable> nullsFirst = natural.nullsFirst();
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        list.add("k");
        list.add(null);
        Collections.sort(list, nullsFirst);
        System.out.println(list);//[null, 5, 9, a, k, z]
    }

    /**
     * <S extends T> Ordering<S> nullsLast()
     * 返回一个Ordering对象,会将null视为最大值进行排序
     */
    @Test
    public void nullsLastTest() {
        Ordering<Comparable> natural = Ordering.natural();
        Ordering<Comparable> nullsLast = natural.nullsLast();
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        list.add("k");
        list.add(null);
        Collections.sort(list, nullsLast);
        System.out.println(list);//[null, 5, 9, a, k, z]
    }

    /**
     * <S extends T> Ordering<S> reverse()
     * 获得能反序的Ordering对象
     */
    @Test
    public void reverseTest() {
        Ordering<Comparable> natural = Ordering.natural();
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        list.add("k");
        Collections.sort(list, natural.reverse());
        System.out.println(list); // [z, k, a, 9, 5]
    }

    /**
     * <F> Ordering<F> onResultOf(Function<F,? extends T> function)
     * 对元素应用特定的函数,再进行排序
     */
    @Test
    public void onResultOfTest() {
        Ordering<Comparable> natural = Ordering.natural();
        Ordering<String> stringOrdering = natural.onResultOf(new Function<String, Comparable>() {
            @NullableDecl
            @Override
            public Comparable apply(@NullableDecl String input) {
                return Math.random() + input;
            }
        });
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        list.add("k");
        Collections.sort(list, stringOrdering);
        System.out.println(list); // [z, k, a, 9, 5]
    }

    /**
     * static Ordering<Object> usingToString()
     * 返回一个 Ordering,根据其toString()进行自然排序
     */
    @Test
    public void usingToStringTest() {
        Ordering<Comparable> natural = Ordering.natural();
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("a");
        list.add("9");
        list.add("z");
        list.add("k");
        Collections.sort(list, natural.usingToString());
        System.out.println(list); // [5, 9, a, k, z]
    }

}
