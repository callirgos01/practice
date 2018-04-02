package net.callirgos.Facebook;

import org.junit.jupiter.api.Test;

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
}