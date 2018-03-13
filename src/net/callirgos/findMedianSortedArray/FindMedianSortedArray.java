package net.callirgos.findMedianSortedArray;

public class FindMedianSortedArray {
    /*
    * There are two sorted arrays nums1 and nums2 of size m and n respectively.
    * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    * Example 1:
    * nums1 = [1, 3]
    * nums2 = [2]
    * The median is 2.0
    * Example 2:
    * nums1 = [1, 2]
    * nums2 = [3, 4]
    * The median is (2 + 3)/2 = 2.5
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length+nums2.length];

        for(int i=0, j=0, k = 0; k < (((nums1.length + nums2.length)/2)+1); k++)
        {
            int nextValue = 0;
            if(i>=nums1.length)
            {
                nextValue = nums2[j];
                j++;
            }
            else if(j>=nums2.length)
            {
                nextValue = nums1[i];
                i++;
            }
            else {
                nextValue = Math.min(nums1[i], nums2[j]);
                if( nextValue == nums1[i] )
                {
                    i++;
                }
                else if( nextValue == nums2[j] )
                {
                    j++;
                }
            }

            mergedArray[k] = (nextValue);
        }
        double median;
        if (mergedArray.length % 2 == 0)
            median = ((double)mergedArray[mergedArray.length/2] + (double)mergedArray[mergedArray.length/2 - 1])/2;
        else
            median = (double) mergedArray[mergedArray.length/2];
        return median;
    }
}
