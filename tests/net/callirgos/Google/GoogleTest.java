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
    @Test
    void combinations() {
        System.out.println(new Google.Banned().combinations());
    }
    @Test
    void longestPathInMatrix(){
        int[][] matrix = new int[3][4];
        matrix[0] = new int[] {10, 15, 2, 5};
        matrix[1] = new int[] {8, 25, 7, 16};
        matrix[2] = new int[] {1, 4, 9, 21};
        System.out.printf("Longest path = %d\r\n", new Google.Banned().longestIncPath(matrix));

    }
    @Test
    void everyOtherNode(){
        Google.Banned.ListNode node = new Google.Banned.ListNode(0);
        Google.Banned.ListNode input = node;
        for( int i=1; i<10; i++ ){
            node.next = new Google.Banned.ListNode(i);
            node=node.next;
        }
        node = input;
        System.out.print("input ");
        while(input != null) {
            System.out.printf("%d ", input.val);
            input = input.next;
        }
        System.out.println();
        input = node;
        Google.Banned.ListNode output = new Google.Banned().everyOtherNodeInTheList(input);
        System.out.print("output ");
        while(output != null) {
            System.out.printf("%d ", output.val);
            output = output.next;
        }
        System.out.println();
    }
/*    @Test
    void testFramingPutFrame() {
        Google.Framing framing = new Google.Framing(1,2);
        byte[] frame  = new byte[] {1,2,3,4,5,6,7,8};
        framing.addFrame(frame);
        framing.addFrame(frame);framing.addFrame(frame);framing.addFrame(frame);framing.addFrame(frame);framing.addFrame(frame);
        for(byte testOutput: framing.getRxRecord()) {
                System.out.println(testOutput);
        }
    }
 */
    @Test
    void testFramingTxRecord() {
        // initialize framing library
        // pass in a full record
        // expect the full record to be broken into frame size chunks
        // check each frame header
        int maxRecordSize = 100;
        int maxFrameSize = 10;
        byte[] fullRecord = new byte[] { 1,2,3,4,5,6,7,8,9,
                                         8,7,6,5,4,3,2,1,1,
                                         2,3,4,5,6,7,4,8,5,
                                         5,2,1,6,2,1,6,8,7,
                                         4,4,3,5,2,5,8,5 };
        byte[][] expectedFrames = new byte[][]{ {0,1,2,3,4,5,6,7,8,9},
                                                {0,8,7,6,5,4,3,2,1,1},
                                                {0,2,3,4,5,6,7,4,8,5},
                                                {0,5,2,1,6,2,1,6,8,7},
                                                {0,4,4,3,5,2,5,8,5}
        };
        Google.Framing framing = new Google.Framing(maxFrameSize, maxRecordSize);
        byte[][] actualFrames = framing.GetTxFrames(fullRecord);
        for( int i=0; i< expectedFrames.length; i++) {
            for( int j=0; i<expectedFrames[i].length; j++)
                assertEquals(expectedFrames[i][j], actualFrames[i][j]);
        }

    }


}