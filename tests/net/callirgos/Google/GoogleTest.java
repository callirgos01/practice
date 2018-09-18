package net.callirgos.Google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GoogleTest {
    @Test
    void atoiTest(){
        for(int expectedOutput=Integer.MIN_VALUE; expectedOutput<Integer.MAX_VALUE; expectedOutput++) {
            String input = String.valueOf(expectedOutput);
            int actualOutput = new Google.PhoneScreen().atoi(input);
            assertEquals(expectedOutput, actualOutput);
        }
    }
    @Test
    void possibleSumsTest(){
        int n = 10;
        int[] input = new int[n];
        for(int i=0; i<n; i++) {
            input[i] = new Random().nextInt(n);
        }
        int target = 10;
        Arrays.sort(input);
        int result1 = new Google.PhoneScreen().possibleSumsMemo(input, target);
        int result2 = new Google.PhoneScreen().possibleSumsRec(input, target);

        System.out.printf("input [ ");
        for(Integer i : input) {
            System.out.printf("%d ", i);
        }
        System.out.println("]");
        System.out.printf("target = %d\r\n",target);
        System.out.printf("result1 = %d\r\n", result1);
        System.out.printf("result2 = %d\r\n", result2);

    }
    @Test
    void isCompleteCycleTest() {
        int[] sample = new int[3];
        sample[0] = 2;
        sample[1] = 2;
        sample[2] = -1;
        System.out.println(new Google.GooglePrepSession().isCompleteCycle(sample));
    }
}