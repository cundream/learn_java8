package com.lc.leran;

import com.lc.learn.LearnJava8;
import org.junit.Test;

import java.util.OptionalInt;

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
           for(int i : s){
               System.out.println(i);
           }
       }
    }




    private void print(OptionalInt optionalInt){
        System.out.println(optionalInt.getAsInt());
    }
}
