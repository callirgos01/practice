package net.callirgos.findMaxLength;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {

    /*
    * Given a binary array, find the maximum length of a contiguous subarray
    * with equal number of 0 and 1.
    * Example 1:
    *       Input: [0,1]
    *       Output: 2
    * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
    * Example 2:
    *       Input: [0,1,0]
    *       Output: 2
    * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
    * Note: The length of the given binary array will not exceed 50,000.
    * */

    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;

        for( int i=0; i<nums.length; i++) {
            count += (nums[i]==1?1:-1);
            if(map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            else {
                map.put(count,i);
            }
        }
        map.containsKey(1);
        map.putIfAbsent()
        return maxLength;
    }

    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,24,null,4,-1,30,null,12,11,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,24,null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]


}
