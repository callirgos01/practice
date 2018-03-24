package net.callirgos.quickSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private void printArray(int[] toPrint) {
        System.out.print("[ ");
        for(Integer i : toPrint) {
            System.out.printf("%d ",i);
        }
        System.out.println("]");
    }
    @Test
    void sortQ() {
        int[] input = {5,7,8,43,2,23,6,9};
        System.out.println("pre");
        printArray(input);
        new QuickSort().sortQ(input);
        System.out.println("post");
        printArray(input);
    }
}