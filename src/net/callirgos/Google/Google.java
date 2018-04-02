package net.callirgos.Google;

import java.util.HashMap;

public class Google {
    public static class PhoneScreen {
        //3 questions
        // question 1
        // Give me a character array, write a function that will convert the character array into an integer.
        // it is possible this might have been the starting question
        // and that this might have lead to other questions
        // I took so long to get this simple answer out he did not ask anything further.
        // I will input this into leetcode, and go through all the edge cases of a ral atoi
        public int atoi(String toConvert) {
            //this was an easy one
            //no edge cases to cover at first
            //assume the input is an integer
            int result = 0;
            int sign = 1;
            for(Character c : toConvert.toCharArray()) {
                if(c=='-') {
                    sign = -1;
                } else {
                    result *= 10;
                    result += (c-'0');
                }
            }

            return result*sign;
        }
        //question 2
        //implement lazy copy string
        //its a combination of deep copy and shadow copy

        //question 3
        // Given an array of ints
        // How many combinations of ints will add up to target
        //this is a classic dynamic programming question
        private int backtrackMemo(int[] nums, int target, int index, HashMap<String, Integer> memo) {
            String key = String.format("%d-%d", target,index);
            if(memo.containsKey(key)){
                return memo.get(key);
            }
            if(target == 0) {
                return 1;
            }
            if(target<0){
                return 0;
            }
            if(index >= nums.length) {
                return 0;
            }
            //if target is smaller than the current number
            // then we cant add the current number
            // there is no way this number can ADD UP to the target
            //so we move on to the next index

            int toReturn;
            if(target < nums[index]) {
                toReturn = backtrackMemo(nums,target,index+1, memo);
            } else {
                toReturn = backtrackMemo(nums, target - nums[index], index + 1, memo) +
                        backtrackMemo(nums, target, index + 1, memo);
            }

            //System.out.println(key);
            memo.put(key, toReturn);
            return toReturn;
        }
        private int backtrackRec(int[] nums, int target, int index) {
            if(target == 0) {
                return 1;
            }
            if(target<0){
                return 0;
            }
            if(index >= nums.length) {
                return 0;
            }
            //if target is smaller than the current number
            // then we cant add the current number
            // there is no way this number can ADD UP to the target
            //so we move on to the next index

            if(target < nums[index]) {
                return backtrackRec(nums,target,index+1);
            } else {
                return backtrackRec(nums, target - nums[index], index + 1) +
                        backtrackRec(nums, target, index + 1);
            }
        }
        public int possibleSumsRec(int[] nums, int target) {
            return backtrackRec(nums, target, 0);

        }
        public int possibleSumsMemo(int[] nums, int target) {

            return backtrackMemo(nums, target, 0, new HashMap<String, Integer>());
        }


    }
}
