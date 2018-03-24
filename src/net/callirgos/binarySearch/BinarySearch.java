package net.callirgos.binarySearch;

import java.util.Arrays;

public class BinarySearch {

    //return the index to the desired tarfget
    //return -1 if we cant find it
    private int binSearchRec(int[] nums, int left, int right, int target) {

        if(left>right) {
            return -1;
        }
        int mid = (left+right)/2;

        if(nums[mid] == target) {
            return mid;
        }
        else if(nums[mid] > target) {
            return binSearchRec(nums, left, mid-1 , target);
        }
        else {
            return binSearchRec(nums, mid +1 , right, target);
        }
    }
    public int binarySearchRecursive(int[] nums, int target) {

        return binSearchRec(nums, 0, nums.length-1, target);

    }

    public int binarySearchIterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = (left + right) /2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }
}
