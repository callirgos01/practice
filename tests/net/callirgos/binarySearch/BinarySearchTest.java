package net.callirgos.binarySearch;

import net.callirgos.mergeSort.MergeSort;
import net.callirgos.quickSort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private void printArray(int[] toPrint) {
        System.out.print("[ ");
        for(int i=0; i<toPrint.length; i++) {
            System.out.printf("%d ", toPrint[i]);
        }
        System.out.println("]");
    }

    @Test
    void binarySearchRecursive() {
        int[] sampleArray = new int[500];
        for(int i=0; i<sampleArray.length; i++) {
            sampleArray[i] = new Random().nextInt(sampleArray.length);
        }
        System.out.println("input");
        printArray(sampleArray);

        new QuickSort().sortQ(sampleArray);
        System.out.println("sorted");
        printArray(sampleArray);

        int target1 = new Random().nextInt(sampleArray.length);
        int target2 = new Random().nextInt(sampleArray.length);

        System.out.printf("Searching for %d\r\n", target1);
        int actualIndexToTarget1 = new BinarySearch().binarySearchRecursive(sampleArray, target1);
        System.out.printf("Index of %d is %d\r\n", target1, actualIndexToTarget1);

        System.out.printf("Searching for %d\r\n", target2);
        int actualIndexToTarget2 = new BinarySearch().binarySearchRecursive(sampleArray, target2);
        System.out.printf("Index of %d is %d\r\n", target2, actualIndexToTarget2);

    }

    @Test
    void binarySearchIterative() {
        int[] sampleArray = new int[20];
        for(int i=0; i<sampleArray.length; i++) {
            sampleArray[i] = new Random().nextInt(sampleArray.length);
        }
        System.out.println("input");
        printArray(sampleArray);

        new MergeSort().mergeSort(sampleArray);
        System.out.println("sorted");
        printArray(sampleArray);
/*

        int target1 = new Random().nextInt(sampleArray.length);
        int target2 = new Random().nextInt(sampleArray.length);
        //System.out.printf("Searching for %d\r\n", target1);
        int actualIndexToTarget1 = new BinarySearch().binarySearchIterative(sampleArray, target1);
        System.out.printf("itera Index of %d is %d\r\n", target1, actualIndexToTarget1);
        int actualIndexToTarget3 = new BinarySearch().binarySearchRecursive(sampleArray, target1);
        System.out.printf("recur Index of %d is %d\r\n", target1, actualIndexToTarget3);

        //System.out.printf("Searching for %d\r\n", target2);
        int actualIndexToTarget2 = new BinarySearch().binarySearchIterative(sampleArray, target2);
        System.out.printf("itera Index of %d is %d\r\n", target2, actualIndexToTarget2);
        int actualIndexToTarget4 = new BinarySearch().binarySearchRecursive(sampleArray, target2);
        System.out.printf("recur Index of %d is %d\r\n", target2, actualIndexToTarget4);
        //System.out.printf("Searching for %d\r\n", target1);

        //System.out.printf("Searching for %d\r\n", target2);
*/

    }
}