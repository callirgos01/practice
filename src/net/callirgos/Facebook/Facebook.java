package net.callirgos.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Facebook {
    public static class PhoneScreen {
        // on the phone screen I have gotten
        // I got one question
        // find the length of any sub array that sums up to the target
        //Given and array, give me the length of the array of the sums
        public int sumOfK(int[] nums, int k) {
            int res = 0;
            int runningSum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length; i++) {
                runningSum += nums[i];

                int j = map.getOrDefault(runningSum-k, i);
                if(j!=i) {
                    return i - j;
                }
                map.put(runningSum,i);
            }
            return res;
        }
        // These problems I have not gotten
        //but I need preactice with these for facebook
        private void backtrack(int[] nums, int index, List<List<Integer>> subSets, Integer[] subSet) {
            if(index == nums.length ) {
                List<Integer> subset = new ArrayList<>();
                for( Integer i : subSet) {
                    if( i!=null ) {
                        subset.add(i);
                    }
                }
                subSets.add(subset);
            } else {
                subSet[index] = nums[index];
                backtrack(nums,index+1, subSets, subSet);
                subSet[index] = null;
                backtrack(nums,index+1, subSets, subSet);
            }
        }
        //combinations / permutations
        public List<List<Integer>> subSets(int[] nums) {
            List<List<Integer>> subSets = new ArrayList<>();
            Integer[] subSet = new Integer[nums.length];
            Arrays.fill(subSet, null);

            backtrack(nums, 0, subSets, subSet);
            return subSets;
        }

    }
}
