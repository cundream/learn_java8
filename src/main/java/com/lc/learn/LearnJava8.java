package com.lc.learn;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
     * @param arrays
     * @param condition  IntPredicate 表示一个整数值参数谓词（布尔值函数）
     * @return
     */
    public static int[] dropElements(int[] arrays, IntPredicate condition){
        //Arrays.copyOfRange(T[ ] original,int from,int to)
        // 将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
        // 注意这里包括下标from，不包括下标to。
        while(arrays.length > 0 && !condition.test(arrays[0])){
            arrays = Arrays.copyOfRange(arrays,1,arrays.length);
        }
        return arrays;

    }

    /**
     * 返回一个从右边移除n个元素的新数组。
     * @param arrays
     * @param n
     * @return
     */
    public static int[] dropRight(int[] arrays, int n){
        if(n < 0){
            throw new IllegalArgumentException("n is less than 0");
        }
        return n < arrays.length
                ?Arrays.copyOfRange(arrays,0,arrays.length - n)
                :new int[0];
    }


    /**
     * 返回数组中每个第 nth 个元素（例如：1,2,4,3   n= 2   返回   2,3）
     * @param arrays
     * @param nth
     * @return
     */
    public static int[] everyNth(int[] arrays, int nth) {
        return IntStream.range(0, arrays.length)
                .filter(i ->  i % nth == nth - 1)
                .map(i -> arrays[i])
                .toArray();
    }


    /**
     * 查找数组中元素的索引。不存在返回-1
     * @param arrays
     * @param el
     * @return
     */
    public static int indexOf(int[] arrays, int el) {
        return IntStream.range(0, arrays.length)
                .filter(i -> arrays[i] == el)
                .findFirst()
                .orElse(-1);
    }


    /**
     *查找数组中元素出现的最后一个索引。不存在返回-1
     * @param arrays
     * @param el
     * @return
     */
    public static int lastIndexOf(int[] arrays, int el) {
        return IntStream.iterate(arrays.length - 1, i -> i - 1)
                .limit(arrays.length)
                .filter(idx -> arrays[idx] == el)
                .findFirst()
                .orElse(-1);
    }


    /**
     * 过滤数组中非唯一的数值
     * @param arrays
     * @return  数组中为唯一的值
     */
    public static int[] filterNonUnique(int[] arrays){
        return Arrays.stream(arrays)
                .filter(el -> indexOf(arrays, el) == lastIndexOf(arrays, el))
                .toArray();
    }


    /**
     * 返回一个数组
     * @param arrays
     * @return
     */
    public static int[] flatten(Object[] arrays){
        return Arrays.stream(arrays).flatMapToInt(a -> a instanceof int[]
                ? Arrays.stream((int[]) a)
                : IntStream.of((int)a)
                ).toArray();
    }


    /**
     *  根据给定函数对数组元素进行分组。
     * @param arrays
     * @param func
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T , R> Map<R , List<T>> groupBy(T[] arrays , Function<T , R> func){

        return Arrays.stream(arrays).collect(Collectors.groupingBy(func));
    }


    /**
     * 返回除数组最后一个元素外的所有元素
     * @param arrays
     * @param <T>
     * @return
     */
    public static <T> T[] initial (T[] arrays){
        return Arrays.copyOfRange(arrays,0,arrays.length - 1);
    }


    /**
     * 初始化包含指定范围内的数字的数组，其中起始和结束都是包含的
     * @param start
     * @param end
     * @return
     */
    public static int[] initializeArrayWithRange(int start,int end ){

        return IntStream.rangeClosed(start,end).toArray();

    }

    /**
     * 初始化 n 个 值为 value 的数组
     * @param value
     * @param n
     * @return
     */
    public static int[] initializeArrayWithValues(int value , int n){
        return  IntStream.generate(() -> value).limit(n).toArray();
    }

    /**
     * 返回两个数组相同值
     * @param first
     * @param second
     * @return
     */
    public static int[] intersection(int[] first,int[] second){
        Set<Integer> set = Arrays.stream(second).boxed().collect(Collectors.toSet());
        return Arrays.stream(first)
                .filter(set::contains)
                .toArray();
    }


    /**
     * 返回数组是否是排序的   正序 1 ，反序 -1 ，无序 0
     * @param arr
     * @param <T>
     * @return
     */

    public static <T extends Comparable<? super T>> int isSorted(T[] arr) {
        final int direction = arr[0].compareTo(arr[1]) < 0 ? 1 : -1;
        for (int i = 0; i < arr.length; i++) {
            T val = arr[i];
            if (i == arr.length - 1) return direction;
            else if ((val.compareTo(arr[i + 1]) * direction > 0)) return 0;
        }
        return direction;
    }


    /**
     * 把数组内的元素拼接字符串
     * @param arr
     * @param separator 分隔符号
     * @param end  最后两个的拼接符号
     * @param <T>
     * @return
     */
    public static <T> String join(T[] arr, String separator, String end) {
        return IntStream.range(0, arr.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, arr[i]))
                .reduce("", (acc, val) -> val.getKey() == arr.length - 2
                        ? acc + val.getValue() + end
                        : val.getKey() == arr.length - 1 ? acc + val.getValue() : acc + val.getValue() + separator, (fst, snd) -> fst);
    }


    /**
     * 指定分隔符号
     * @param arr
     * @param separator
     * @param <T>
     * @return
     */
    public static <T> String join(T[] arr, String separator) {
        return join(arr, separator, separator);
    }

    /**
     * 只分隔
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> String join(T[] arr) {
        return join(arr, ",");
    }


    /**
     * 取数组的 下标 为n  个元素  n > 0 取下标为n ，n < 0  从未向前
     * @param arr
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T nthElement(T[] arr, int n) {
        if (n > 0) {
            return Arrays.copyOfRange(arr, n, arr.length)[0];
        }
        return Arrays.copyOfRange(arr, arr.length + n, arr.length)[0];
    }


    /**
     * 选择键对应的键对
     * @param obj
     * @param arr
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<T, R> pick(Map<T, R> obj, T[] arr) {
        return Arrays.stream(arr)
                .filter(obj::containsKey)
                .collect(Collectors.toMap(k -> k, obj::get));
    }


    /**
     * 根据函数过滤 Map数组中，key在keys数组中的元素
     * @param data
     * @param keys
     * @param fn
     * @return
     */
    public static Map<String, Object>[] reducedFilter(Map<String, Object>[] data, String[] keys, Predicate<Map<String, Object>> fn) {
        return Arrays.stream(data)
                .filter(fn)
                .map(el -> Arrays.stream(keys).filter(el::containsKey)
                        .collect(Collectors.toMap(Function.identity(), el::get)))
                .toArray((IntFunction<Map<String, Object>[]>) Map[]::new);
    }

    /**
     *随机获取数组中的元素
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T sample(T[] arr) {
        return arr[(int) Math.floor(Math.random() * arr.length)];
    }


    /**
     * 随机返回数组中指定个数的元素
     * @param input
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T[] sampleSize(T[] input, int n) {
        T[] arr = Arrays.copyOf(input, input.length);
        int length = arr.length;
        int m = length;
        while (m > 0) {
            int i = (int) Math.floor(Math.random() * m--);
            T tmp = arr[i];
            arr[i] = arr[m];
            arr[m] = tmp;
        }
        return Arrays.copyOfRange(arr, 0, n > length ? length : n);
    }


    /**
     * 随机排序数组
     * @param input
     * @param <T>
     * @return
     */
    public static <T> T[] shuffle(T[] input) {
        T[] arr = Arrays.copyOf(input, input.length);
        int length = arr.length;
        int m = length;
        while (m > 0) {
            int i = (int) Math.floor(Math.random() * m--);
            T tmp = arr[i];
            arr[i] = arr[m];
            arr[m] = tmp;
        }
        return arr;
    }

    /**
     * 创建一个空数组
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T[] emptyArray(Class<T> clz) {
        return (T[]) Array.newInstance(clz, 0);
    }


    /**
     *
     * @param first
     * @param second
     * @param <T>
     * @return  两个数组不同的数据
     */
    public static <T> T[] symmetricDifference(T[] first, T[] second) {
        Set<T> sA = new HashSet<>(Arrays.asList(first));
        Set<T> sB = new HashSet<>(Arrays.asList(second));

        return Stream.concat(
                Arrays.stream(first).filter(a -> !sB.contains(a)),
                Arrays.stream(second).filter(b -> !sA.contains(b))
        ).toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, first.getClass()));
    }

    /**
     * 那数组n长度数据
     * @param arr
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T[] take(T[] arr, int n) {
        return Arrays.copyOfRange(arr, 0, n);
    }


    /**
     * 从右边拿
     * @param arr
     * @param n
     * @param <T>
     * @return
     */
    public static <T> T[] takeRight(T[] arr, int n) {
        return Arrays.copyOfRange(arr, arr.length - n, arr.length);
    }


    /**
     * 合并两个数组 并去重
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> T[] union(T[] first, T[] second) {
        Set<T> set = new HashSet<>(Arrays.asList(first));
        set.addAll(Arrays.asList(second));
        return set.toArray((T[]) Arrays.copyOf(new Object[0], 0, first.getClass()));
    }


    /**
     * 返回参数中与数组中不同的数据
     * @param arr
     * @param elements
     * @param <T>
     * @return
     */
    public static <T> T[] without(T[] arr, T... elements) {
        List<T> excludeElements = Arrays.asList(elements);
        return Arrays.stream(arr)
                .filter(el -> !excludeElements.contains(el))
                .toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, arr.getClass()));
    }


    /**
     * 把多个数组中 下标相同的数据压缩为一个数组
     * @param arrays
     * @return 一个List集合
     */
    public static List<Object[]> zip(Object[]... arrays) {
        OptionalInt max = Arrays.stream(arrays).mapToInt(arr -> arr.length).max();
        return IntStream.range(0, max.getAsInt())
                .mapToObj(i -> Arrays.stream(arrays)
                        .map(arr -> i < arr.length ? arr[i] : null)
                        .toArray())
                .collect(Collectors.toList());
    }


    /**
     * 把数组压缩为Map集合
     * @param props key
     * @param values value
     * @return
     */
    public static Map<String, Object> zipObject(String[] props, Object[] values) {
        return IntStream.range(0, props.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(props[i], i < values.length ? values[i] : null))
                .collect(
                        HashMap::new, (m, v) -> m.put(v.getKey(), v.getValue()), HashMap::putAll);
    }


    /**
     * 求数组中数的平均值
     * @param arr
     * @return
     */
    public static double average(int[] arr) {
        return IntStream.of(arr)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }


    /**
     * 对字符串进行打乱组合
     * @param input
     * @return
     */

    public static List<String> anagrams(String input) {
        if (input.length() <= 2) {
            return input.length() == 2
                    ? Arrays.asList(input, input.substring(1) + input.substring(0, 1))
                    : Collections.singletonList(input);
        }
        return IntStream.range(0, input.length())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, input.substring(i, i + 1)))
                .flatMap(entry ->
                        anagrams(input.substring(0, entry.getKey()) + input.substring(entry.getKey() + 1))
                                .stream()
                                .map(s -> entry.getValue() + s))
                .collect(Collectors.toList());
    }


    /**
     * 字符的字节数
     * @param input
     * @return
     */
    public static int byteSize(String input) {
        return input.getBytes().length;
    }

    /**
     *
     * @param input
     * @param lowerRest
     * @return
     */
    public static String capitalize(String input, boolean lowerRest) {
        return input.substring(0, 1).toUpperCase() +
                (lowerRest
                        ? input.substring(1, input.length()).toLowerCase()
                        : input.substring(1, input.length()));
    }


    /**
     * 单词首字母大写处理
     * @param input
     * @return
     */
    public static String capitalizeEveryWord(final String input) {
        return Pattern.compile("\\b(?=\\w)").splitAsStream(input)
                .map(w -> capitalize(w, false))
                .collect(Collectors.joining());
    }


    /**
     * 判断是不是绝地路径
     * @param url
     * @return
     */
    public static boolean isAbsoluteUrl(String url) {
        return Pattern.compile("^[a-z][a-z0-9+.-]*:").matcher(url).find();
    }


    /**
     * 隐藏字符
     * @param input
     * @param num  num > 0 从右向左显示   num<0  从左向右显示
     * @param mask  隐藏时显示字符
     * @return
     */
    public static String mask(String input, int num, String mask) {
        int length = input.length();
        return num > 0
                ?
                input.substring(0, length - num).replaceAll(".", mask)
                        + input.substring(length - num)
                :
                input.substring(0, Math.negateExact(num))
                        + input.substring(Math.negateExact(num), length).replaceAll(".", mask);
    }


    /**
     * 翻转字符串
     * @param input
     * @return
     */
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * 梳理字符顺序
     * @param input
     * @return
     */
    public static String sortCharactersInString(String input) {
        return Arrays.stream(input.split("")).sorted().collect(Collectors.joining());
    }

    /**
     * 分割行
     * @param input
     * @return
     */
    public static String[] splitLines(String input) {
        return input.split("\\r?\\n");
    }








}
