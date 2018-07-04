package net.callirgos.Facebook;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FacebookTest {
    @Test
    void sumOfKTest(){
        int n = 50;
        int target = new Random().nextInt(100);
        int[] input = new int[n];
        for(int i=0; i<n; i++) {
            int toAdd = 0;
            while(toAdd==0 || toAdd==target){
                toAdd = new Random().nextInt(20);
            }
            input[i] = toAdd;
        }

        int output = new Facebook.PhoneScreen().sumOfK(input, target);
        System.out.print("input [ ");
        for(Integer i : input) {
            System.out.printf("%d ",i);
        }
        System.out.println("]");
        System.out.printf("Target = %d\r\n", target);
        System.out.printf("output = %d\r\n", output);
    }
    @Test
    void subSetTest() {
        int n = 10;
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i]=i+1;
        }
        List<List<Integer>> subsets = new Facebook.PhoneScreen().subSets(nums);
        for(List<Integer> subset : subsets){
            System.out.print("[ ");
            for(Integer i: subset){
                System.out.printf("%d ",i);
            }
            System.out.println("]");
        }
    }
    @Test
    void isBalancedTest(){
        String input = "{}{}{}{}()()()()[][][][]";
        boolean expectedOutput = true;
        boolean actualOutput = new Facebook.PhoneScreen().isBalanced(input);

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void alienDictionaryTest() {
        //String input[] = {};//c -> b -> a words = ['ab', 'bc', 'cd',* 'da']
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cc");
        dictionary.add("cb");
        dictionary.add("bb");
        dictionary.add("ac");
        dictionary.add("ad");

        List<Character> expectedOutput = new ArrayList<>() ;
        expectedOutput.add('a');
        expectedOutput.add('b');
        expectedOutput.add('c');

        List<Character> actualOutput = new Facebook.PhoneScreen().alienDictionary(dictionary);

        assertEquals(expectedOutput, actualOutput);

    }

}