package com.lc.learn;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: learn_java8
 * @description:
 * @author: lic
 * @create: 2018-03-29 15:11
 **/
public class LearnJava8 {

    /**
     * 计算最大公约数（GCD）
     *
     * @param arrays
     * @return
     */
    public static OptionalInt gcd(int[] arrays) {
        return Arrays.stream(arrays).reduce((a, b) -> gcd(a, b));
    }

    /**
     * 计算最小公倍数
     *
     * @param arrays
     * @return
     */
    public static OptionalInt lcm(int[] arrays) {
        // IntBinaryOperator  表示对两个int值操作数的运算，并产生一个int值结果
        IntBinaryOperator lcm = (x, y) -> (x * y) / gcd(x, y);
        return Arrays.stream(arrays).reduce((a, b) -> lcm.applyAsInt(a, b));

    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 查找数组中最大值
     *
     * @param arrays
     * @return
     */
    public static OptionalInt arrayMax(int[] arrays) {
        return Arrays.stream(arrays).max();
    }

    /**
     * 查找数组中最小值
     *
     * @param arrays
     * @return
     */
    public static OptionalInt arrayMin(int[] arrays) {
        return Arrays.stream(arrays).min();
    }


    /**
     * 将数组分为指定大小的较小数组
     *
     * @param arrays
     * @param size
     * @return
     */
    public static int[][] chunk(int[] arrays, int size) {
        return IntStream.iterate(0, i -> i + size)
                .limit((long) Math.ceil((double) arrays.length / size))
                .mapToObj(cur -> Arrays.copyOfRange(arrays, cur, cur + size > arrays.length ? arrays.length : cur + size))
                .toArray(int[][]::new);
    }

    /**
     * 统计数组中某值出现的次数
     *
     * @param arrays
     * @param value
     * @return
     */
    public static long contOccurrences(int[] arrays, int value) {
        return Arrays.stream(arrays).filter(i -> i == value).count();
    }


    /**
     * 深化数组
     *
     * @param input
     * @return
     */
    public static int[] deepFlatten(Object[] input) {
        return Arrays.stream(input).flatMapToInt(o -> {
            if (o instanceof Object[]) {
                return Arrays.stream(deepFlatten((Object[]) o));
            }
            return IntStream.of((Integer) o);
        }).toArray();

    }

    /**
     * 比较两个数组的差异
     *
     * @param first
     * @param second
     * @return 第一个不在第二个的元素
     */
    public static int[] difference(int[] first, int[] second) {
        Set<Integer> set = Arrays.stream(second).boxed().collect(Collectors.toSet());
        return Arrays.stream(first).filter(v -> !set.contains(v)).toArray();
    }


    /**
     * @param first
     * @param second
     * @param comparator 表示对两个int值操作数的运算，并产生一个int值结果
     * @return
     */
    public static int[] differenceWith(int[] first, int[] second, IntBinaryOperator comparator) {
        return Arrays.stream(first)
                .filter(a ->
                        Arrays.stream(second)
                                .noneMatch(b -> comparator.applyAsInt(a, b) == 0)).toArray();
    }

    /**
     * 返回数组的所有不同值。去重
     * @param arrays
     * @return
     */
    public static int[] distinctValuesOfArray(int[] arrays){
        return Arrays.stream(arrays).distinct().toArray();
    }

    /**
     * 移除数组中的元素，直到传递的函数返回true。返回数组中剩余的元素。
     * @param elements
     * @param condition  IntPredicate 表示一个整数值参数谓词（布尔值函数）
     * @return
     */
    public static int[] dropElements(int[] elements, IntPredicate condition){
        //Arrays.copyOfRange(T[ ] original,int from,int to)
        // 将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
        // 注意这里包括下标from，不包括下标to。
        while(elements.length > 0 && !condition.test(elements[0])){
            elements = Arrays.copyOfRange(elements,1,elements.length);
        }
        return elements;

    }

    /**
     * 返回一个从右边移除n个元素的新数组。
     * @param elements
     * @param n
     * @return
     */
    public static int[] dropRight(int[] elements, int n){
        if(n < 0){
            throw new IllegalArgumentException("n is less than 0");
        }
        return n < elements.length
                ?Arrays.copyOfRange(elements,0,elements.length - n)
                :new int[0];
    }


    /**
     *
     * @param elements
     * @param nth
     * @return
     */
    public static int[] everyNth(int[] elements, int nth) {
        return IntStream.range(0, elements.length)
                .filter(i ->  i % nth == nth - 1)
                .map(i -> elements[i])
                .toArray();
    }




}
