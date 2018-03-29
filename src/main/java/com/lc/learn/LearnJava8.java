package com.lc.learn;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
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


}
