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
        String input1 = "{}{}{}{}()()()()[][][][]";
        boolean expectedOutput1 = true;
        boolean actualOutput1 = new Facebook.PhoneScreen().isBalanced(input1);


        String input2 = "{}{}{}{}()()()()[][][][{]";
        boolean expectedOutput2 = false;
        boolean actualOutput2 = new Facebook.PhoneScreen().isBalanced(input2);

        assertEquals(expectedOutput1, actualOutput1);
        assertEquals(expectedOutput2, actualOutput2);
    }
    @Test
    void alienDictionaryTest() {
        /*
        * Example 1:
            Given the following words in dictionary,
            [
              "wrt",
              "wrf",
              "er",
              "ett",
              "rftt"
            ]
            The correct order is: "wertf".
        * */
        List<String> dictionary1 = new ArrayList<>();
        dictionary1.add("wrt");
        dictionary1.add("wrf");
        dictionary1.add("er");
        dictionary1.add("ett");
        dictionary1.add("rftt");

        List<Character> expectedOutput1 = new ArrayList<>() ;
        expectedOutput1.add('w');
        expectedOutput1.add('e');
        expectedOutput1.add('r');
        expectedOutput1.add('t');
        expectedOutput1.add('f');

        List<String> dictionary2 = new ArrayList<>();
        dictionary2.add("z");
        dictionary2.add("x");

        List<Character> expectedOutput2 = new ArrayList<>() ;
        expectedOutput2.add('z');
        expectedOutput2.add('x');

        List<Character> actualOutput1 = new Facebook.PhoneScreen().alienDictionary(dictionary1);
        List<Character> actualOutput2 = new Facebook.PhoneScreen().alienDictionary(dictionary2);

        assertEquals(expectedOutput2.size(), actualOutput2.size());
        for(int i=0; i<actualOutput2.size(); i++) {
            assertEquals(expectedOutput2.get(i), actualOutput2.get(i));
        }

        assertEquals(expectedOutput1.size(), actualOutput1.size());
        for(int i=0; i<actualOutput1.size(); i++) {
            assertEquals(expectedOutput1.get(i), actualOutput1.get(i));
        }

    }

}