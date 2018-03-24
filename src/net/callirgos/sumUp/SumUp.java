package net.callirgos.sumUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumUp {

    // Given an array of ints
    // Return the length of the array that adds up to 8

    public int getArrayLengthSun(int[] nums, int k){
        int numCombinations = 0;
        List<Integer> map = new ArrayList<>();
        map.add(0);//manually add the 0 case
        int runningSum = 0;
        for(int i=0; i<nums.length; i++)
        {
            runningSum += nums[i];
            if(map.contains(runningSum-k)) {
                numCombinations++;
            }
            //maxLength = Math.max(maxLength, i - map.getOrDefault(runningSum-k, i));

            //System.out.printf("[%d] = %d\r\n", runningSum,i);
            map.add(runningSum);
        }
        for(Integer value : map){
            System.out.printf("%d\r\n", value);
        }
        return numCombinations;
    }
}
