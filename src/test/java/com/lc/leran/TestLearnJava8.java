package com.lc.leran;

import com.lc.learn.LearnJava8;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @program: learn_java8
 * @description: 测试
 * @author: lic
 * @create: 2018-03-29 15:14
 **/
public class TestLearnJava8 {

    @Test
    public void test() throws Exception {
    }

    @Test
    public void gcd_test_1_to_5_is_1() {
        OptionalInt gcd = LearnJava8.gcd(new int[]{1, 2, 3, 4, 5});
        print(gcd);
    }

    @Test
    public void gcd_test_4_8_and_12_is_4() {
        OptionalInt gcd = LearnJava8.gcd(new int[]{4, 8, 12});
        print(gcd);
    }

    @Test
    public void lcm_test_4_8_12_is_24() throws Exception {
        OptionalInt lcm = LearnJava8.lcm(new int[]{4, 8, 12});
        print(lcm);

    }

    @Test
    public void max_test() throws Exception {
        OptionalInt max = LearnJava8.arrayMax(new int[]{10, 1, 5, 4});
        print(max);
    }


    @Test
    public void min_test() throws Exception {
        OptionalInt max = LearnJava8.arrayMin(new int[]{10, 1, 5, 4});
        print(max);
    }

    @Test
    public void chunk_breaks_input_array__with_odd_length() throws Exception {
        int[][] chunks = LearnJava8.chunk(new int[]{1, 2, 3, 4, 5}, 2);
        for (int[] s : chunks) {
            System.out.println("数组大小-----" + s.length);
            print(s);
        }
    }

    @Test
    public void contOccurrences_test() throws Exception {
        long count = LearnJava8.contOccurrences(new int[]{1, 1, 2, 1, 2, 3}, 1);
        System.out.println(count);
    }


    @Test
    public void deepFlatten_test() throws Exception {
        int[] flatten = LearnJava8.deepFlatten(new Object[]{1, new Object[]{2}, new Object[]{3, 4, 5}});
        print(flatten);

    }


    @Test
    public void difference_test() throws Exception {
        int[] difference = LearnJava8.difference(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        print(difference);
    }


    @Test
    public void differenceWith_test() throws Exception {
        int[] difference = LearnJava8.differenceWith(
                new int[]{1, 4, 9, 16, 25},
                new int[]{1, 2, 3, 6, 7},
                (o1, o2) -> o1 - (o2 * o2)
        );
        print(difference);
    }


    @Test
    public void distinctValuesOfArray_tset() throws Exception {
        int[] distinct = LearnJava8.distinctValuesOfArray(new int[]{1, 2, 2, 1, 3, 4, 5});
        print(distinct);
    }

    @Test
    public void dropElements_test() throws Exception {
        int[] drop = LearnJava8.dropElements(new int[]{1, 2, 3, 4}, i -> i >= 3);
        print(drop);
    }

    @Test
    public void dropRight_test() throws Exception {
        int[] drop = LearnJava8.dropRight(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);
        print(drop);
    }


    @Test
    public void everyNth_test() throws Exception {
        int[] every = LearnJava8.everyNth(new int[]{1, 2, 4, 3, 5, 6}, 3);
        print(every);
    }

    @Test
    public void filterNonUnique_test() throws Exception {
        int[] filter = LearnJava8.filterNonUnique(new int[]{1, 2, 4, 3, 5, 6, 1});
        print(filter);
    }


    @Test
    public void faltten_test() throws Exception {
        int[] faltten = LearnJava8.flatten(new Object[]{1, new int[]{1, 2, 3}, 4, 5});
        print(faltten);

    }

    @Test
    public void groupBy_test() throws Exception {
        Map<Integer, List<String>> group = LearnJava8.groupBy(new String[]{"one", "two", "three"}, String::length);

        print(group);
    }


    @Test
    public void initializeArrayWithRange_test() throws Exception {
        int[] numbers = LearnJava8.initializeArrayWithRange(1, 5);
        print(numbers);

    }

    @Test
    public void initializeArrayWithValues_test() throws Exception {
        int[] numbers = LearnJava8.initializeArrayWithValues(5, 3);
        print(numbers);
    }


    @Test
    public void intersection_test() throws Exception {
        int[] elements = LearnJava8.intersection(new int[]{7, 1, 2, 3}, new int[]{4, 3, 2, 1, 6, 7, 5, 7});
        print(elements);
    }


    @Test
    public void isSorted_test() throws Exception {
        int t = LearnJava8.isSorted(new Integer[]{1, 2, 3, 7, 8});
        int t2 = LearnJava8.isSorted(new Integer[]{1, 2, 3, 7, 6});
        int t3 = LearnJava8.isSorted(new Integer[]{8, 7, 6, 5});
        int t4 = LearnJava8.isSorted(new Integer[]{8, 5, 6});
        print(t);
        print(t2);
        print(t3);
        print(t4);
    }


    @Test
    public void join_different_sep_and_end_test() throws Exception {
        String joined = LearnJava8.join(new String[]{"pen", "pineapple", "apple", "pensssss", "pensssss"}, ",", "&");
        print(joined);
    }

    @Test
    public void join_with_sep_only_test() throws Exception {
        String joined = LearnJava8.join(new String[]{"pen", "pineapple", "apple", "pensssss", "pensssss"}, "-");
        print(joined);
    }

    @Test
    public void join_with_default_sep_test() throws Exception {
        String joined = LearnJava8.join(new String[]{"pen", "pineapple", "apple", "pensssss", "pensssss"});
        print(joined);
    }


    @Test
    public void nthElement_positive_sequence_test() throws Exception {
        String ngElement = LearnJava8.nthElement(new String[]{"a", "b", "c"}, 1);
        print(ngElement);
    }

    @Test
    public void nthElement_reverse_test() throws Exception {
        String ngElement = LearnJava8.nthElement(new String[]{"a", "b", "c"}, -3);
        print(ngElement);
    }


    @Test
    public void pick_test() throws Exception {
        Map<String, Integer> obj = new HashMap<>();
        obj.put("a", 1);
        obj.put("b", 2);
        obj.put("c", 3);
        Map<String, Integer> picked = LearnJava8.pick(obj, new String[]{"a", "c"});
        System.out.println(picked);
    }

    @Test
    public void reducedFilter_test() throws Exception {
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("name", "john");
        item1.put("age", 24);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("name", "mike");
        item2.put("age", 50);
        Map<String, Object> item3 = new HashMap<>();
        item3.put("id", 3);
        item3.put("name", "cun");
        item3.put("age", 45);

        Map<String, Object>[] filtered = LearnJava8.reducedFilter((Map<String, Object>[]) new Map[]{item1, item2, item3}, new String[]{"id", "name", "age"}, item -> (Integer) item.get("age") > 24);

        print(filtered);
    }


    @Test
    public void sample_random_test() throws Exception {

        Integer sample = LearnJava8.sample(new Integer[]{3, 4, 5, 6, 7, 9, 11});
        print(sample);
    }


    @Test
    public void sampleSize_random_than_array_size() throws Exception {
        Integer[] sample = LearnJava8.sampleSize(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, 1);

        print(sample);
    }

    @Test
    public void shuffle__test() throws Exception {
        Integer[] sample = LearnJava8.shuffle(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        print(sample);
    }

    @Test
    public void empty_array() throws Exception {
        String[] empty = LearnJava8.emptyArray(String.class);
    }









    private void print(Object[] obj) {
        for (Object o : obj) {
            if (o instanceof Object[]) {
                print((Object[]) o);
            } else {
                System.out.println(o);
            }

        }
    }

    private void print(int[] arrays) {
        Arrays.stream(arrays).forEach(System.out::println);
    }

    private void print(Object o) {
        System.out.println(o);
    }

    private void print(OptionalInt optionalInt) {
        System.out.println(optionalInt.getAsInt());
    }
}
