package net.callirgos.quickSort;

import java.util.Random;

public class QuickSort {
    private int partition( int[] array, int pivot, int left, int right) {

        while(left<=right) {
            while(array[left] < pivot) {
                left++;
            }
            while(array[right] > pivot) {
                right--;
            }
            if(left<=right) {
                //swap
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                right--;
                left++;
            }
        }

        return left;
    }
    private void printArray(int[] toPrint) {
        System.out.print("[ ");
        for(Integer i : toPrint) {
            System.out.printf("%d ",i);
        }
        System.out.println("]");
    }
    private void sortQRecursiveQ(int[]array, int left, int right) {

       // printArray(array);

        if(left>=right) {
            return;
        }

        int pivot = array[left];

        int index = partition(array, pivot, left,right);
        sortQRecursiveQ(array, left, index-1);
        sortQRecursiveQ(array, index+1, right);

    }

    public void sortQ(int[]array) {
        sortQRecursiveQ(array, 0, array.length-1);
    }
}
