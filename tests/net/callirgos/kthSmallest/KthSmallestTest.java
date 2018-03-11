package net.callirgos.kthSmallest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestTest {

    @Test
    void findKthNumber() {
        int example1M = 3;
        int example1N = 3;
        int example1K = 5;
        int expectedResult1 = 3;

        int actualResult1 = new KthSmallest().findKthNumber(example1M, example1N, example1K);

        int example2M = 2;
        int example2N = 3;
        int example2K = 6;
        int expectedResult2 = 6;

        int actualResult2 = new KthSmallest().findKthNumber(example2M, example2N, example2K);

        int example3M = 3;
        int example3N = 1;
        int example3K = 3;
        int expectedResult3 = 3;

        int actualResult3 = new KthSmallest().findKthNumber(example3M, example3N, example3K);
        int example4M = 9895;
        int example4N = 28405;
        int example4K = 100787757;
        int expectedResult4 = 31666344;

        int actualResult4 = new KthSmallest().findKthNumber(example4M, example4N, example4K);

         assertEquals(expectedResult1, actualResult1);
         assertEquals(expectedResult2, actualResult2);
         assertEquals(expectedResult3, actualResult3);
         assertEquals(expectedResult4, actualResult4);
    }
}