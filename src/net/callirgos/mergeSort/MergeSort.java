package net.callirgos.mergeSort;

public class MergeSort {
    private void printArray(int[] nums, int start, int end) {
        System.out.printf("[%d][%d][ ", start, end);

        for(int i=start;i<=end; i++ ) {
            System.out.printf("%d ",nums[i]);
        }
        System.out.println("]");
    }
    private void mergeArrays(int[] nums, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int right = rightStart;
        int left = leftStart;
        int size = rightEnd - leftStart + 1;
        int index = leftStart;
        printArray(nums,leftStart, leftEnd);
        printArray(nums,rightStart,rightEnd);
        while(right<=rightEnd && left<=leftEnd) {
            if(nums[left]<nums[right]) {
                temp[index] = nums[left];
                left++;
            }
            else{
                temp[index] = nums[right];
                right++;
            }
            index++;
        }

        System.arraycopy(nums, left, temp, index, leftEnd - left + 1);
        System.arraycopy(nums, right, temp, index, rightEnd - right +1);
        System.arraycopy(temp, leftStart, nums, leftStart, size);
        System.out.print("nums");
        printArray(nums,0, nums.length-1);
        System.out.print("temp");
        printArray(temp,0, temp.length-1);
    }
    private void mergeSortRec(int[] nums, int[] temp, int left, int right) {
        if(left>=right) {
            return;
        }
        int mid = (left+right)/2;
        System.out.printf("left %d\r\n", left);
        System.out.printf("right %d\r\n", right);
        System.out.printf("mid %d\r\n", mid);
        //sort right
        mergeSortRec(nums, temp, left, mid);
        //sort left left
        mergeSortRec(nums, temp, mid+1, right);
        //merge arrays
        mergeArrays(nums, temp, left, mid, mid+1, right);
    }
    public void mergeSort(int[] nums) {

        mergeSortRec(nums, new int[nums.length], 0, nums.length-1);

    }
}
