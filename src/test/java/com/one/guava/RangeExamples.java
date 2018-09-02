package com.one.guava;

import com.google.common.collect.Range;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
- 代表一个间隔或一个序列。 它被用来获取一组数字 / 字符串位于一个特定的范围

- Coding By One ON 09/02
*/
public class RangeExamples {
    /**
     * static <C extends Comparable<?>> Range<C> all()
     * 返回包含类型 c 的每个值的范围。
     */
    @Test
    public void allTest() {
        Range<Comparable<?>> all = Range.all();
    }

    /**
     * static <C extends Comparable<?>> Range<C> atLeast(C endpoint)
     */
    @Test
    public void atLeastTest() {
        Range<Integer> integerRange = Range.atLeast(5);
    }

    /**
     * static <C extends Comparable<?>> Range<C> atMost(C endpoint)
     */
    @Test
    public void atMostTest() {
        Range<Integer> integerRange = Range.atMost(5);

    }

    /**
     * Range<C> canonical(DiscreteDomain<C> domain)
     */
    @Test
    public void canonicalTest() {
        // TODO
    }

    /**
     * static <C extends Comparable<?>> Range<C> closed(C lower, C upper)
     * 表示闭区间的范围,[x..y]
     */
    @Test
    public void closedTest() {
        Range<Integer> closed = Range.closed(1, 5);
        System.out.println(closed);
    }

    /**
     * static <C extends Comparable<?>> Range<C> closedOpen(C lower, C upper)
     * 上开区间的范围, [x..y)
     */
    @Test
    public void closedOpenTest() {
        Range<Integer> closedOpen = Range.closedOpen(1, 5);
        System.out.println(closedOpen);
    }

    /**
     * boolean containsAll(Iterable<? extends C> values)
     * 若果集合所有元素在此范围内,返回 true
     */
    @Test
    public void containsAllTest() {
        Range<Integer> closed = Range.closedOpen(1, 4);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        boolean b = closed.containsAll(list); // false
        System.out.println(b);
    }

    /**
     * static <C extends Comparable<?>> Range<C> open(C lower, C upper)
     * 表示闭区间的范围, (x..y)
     *
     * static <C extends Comparable<?>> Range<C> openClosed(C lower, C upper)
     * 表示下开区间的范围 (x..y]
     */
    @Test
    public void openTest() {
        Range<Integer> closed = Range.open(1, 4);
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.add(4);
        boolean b = closed.containsAll(list);
        System.out.println(b);// false;
        Range<Integer> openClosed = Range.openClosed(1, 4);
        boolean b1 = openClosed.containsAll(list);
        System.out.println(b1); // true
    }
}
