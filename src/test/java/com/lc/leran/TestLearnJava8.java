package com.lc.leran;

import com.lc.learn.LearnJava8;
import org.junit.Test;

import java.util.Arrays;
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
    public void test() throws  Exception{}

    @Test
    public void gcd_test_1_to_5_is_1(){
        OptionalInt gcd = LearnJava8.gcd(new int[]{1,2,3,4,5});
        print(gcd);
    }

    @Test
    public void gcd_test_4_8_and_12_is_4(){
        OptionalInt gcd = LearnJava8.gcd(new int[]{4,8,12});
        print(gcd);
    }

    @Test
    public void lcm_test_4_8_12_is_24() throws  Exception{
        OptionalInt lcm = LearnJava8.lcm(new int[]{4,8,12});
        print(lcm);

    }

    @Test
    public void max_test() throws  Exception{
        OptionalInt max = LearnJava8.arrayMax(new int[]{10,1,5,4});
        print(max);
    }


    @Test
    public void min_test() throws  Exception{
        OptionalInt max = LearnJava8.arrayMin(new int[]{10,1,5,4});
        print(max);
    }

    @Test
    public void chunk_breaks_input_array__with_odd_length() throws Exception {
        int[][] chunks = LearnJava8.chunk(new int[]{1, 2, 3, 4, 5}, 2);
       for (int[] s: chunks){
           System.out.println("数组大小-----"+s.length);
           print(s);
       }
    }

    @Test
    public void contOccurrences_test() throws Exception{
        long count = LearnJava8.contOccurrences(new int[]{1, 1, 2, 1, 2, 3}, 1);
        System.out.println(count);
    }


    @Test
    public void deepFlatten_test()throws Exception{
        int[] flatten = LearnJava8.deepFlatten(new Object[]{1,new Object[]{2},new Object[]{3,4,5}});
        print(flatten);

    }


    @Test
    public void difference_test() throws  Exception{
        int[] difference = LearnJava8.difference(new int[]{1,2,3},new int[]{1,2,4});
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
    public void distinctValuesOfArray_tset() throws  Exception{
        int[] distinct = LearnJava8.distinctValuesOfArray(new int[]{1,2,2,1,3,4,5});
        print(distinct);
    }

    @Test
    public void dropElements_test() throws  Exception {
        int[] drop = LearnJava8.dropElements(new int[]{1,2,3,4},i -> i >= 3);
        print(drop);
    }

    @Test
    public void dropRight_test() throws  Exception{
        int[] drop = LearnJava8.dropRight(new int[]{1,2,3,4,5,6,7,8},3);
        print(drop);
    }


    @Test
    public void everyNth_test() throws  Exception{
        int[] every = LearnJava8.everyNth(new int[]{1,2,3,4,5,6},3);
        print(every);
    }


    private void print(int[] arrays){
        Arrays.stream(arrays).forEach(System.out::println);
    }

    private void print(OptionalInt optionalInt){
        System.out.println(optionalInt.getAsInt());
    }
}
