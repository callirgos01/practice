package net.callirgos.findRightInterval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRightIntervalTest {

    @Test
    void findRightInterval() {
        FindRightInterval.Interval[] example1Input = new FindRightInterval.Interval[1];
        example1Input[0] = new FindRightInterval.Interval(1,2);
        int[] expectedResult1 = new int[] {-1};
        int[] actualResult1 = new FindRightInterval().findRightInterval(example1Input);

        FindRightInterval.Interval[] example2Input = new FindRightInterval.Interval[3];
        example2Input[0] = new FindRightInterval.Interval(3,4);
        example2Input[1] = new FindRightInterval.Interval(2,3);
        example2Input[2] = new FindRightInterval.Interval(1,2);
        int[] expectedResult2 = new int[] {-1, 0, 1};
        int[] actualResult2 = new FindRightInterval().findRightInterval(example2Input);

        FindRightInterval.Interval[] example3Input = new FindRightInterval.Interval[3];
        example3Input[0] = new FindRightInterval.Interval(1,4);
        example3Input[1] = new FindRightInterval.Interval(2,3);
        example3Input[2] = new FindRightInterval.Interval(3,4);
        int[] expectedResult3 = new int[] {-1, 2, -1};
        int[] actualResult3 = new FindRightInterval().findRightInterval(example3Input);

        assertEquals(expectedResult3.length,actualResult3.length);
        for(int i=0; i<expectedResult3.length;i++)
        {
            assertEquals(expectedResult3[i],actualResult3[i]);
        }

        assertEquals(expectedResult2.length,actualResult2.length);
        for(int i=0; i<expectedResult2.length;i++)
        {
            assertEquals(expectedResult2[i],actualResult2[i]);
        }

        assertEquals(expectedResult1.length,actualResult1.length);
        for(int i=0; i<expectedResult1.length;i++)
        {
            assertEquals(expectedResult1[i],actualResult1[i]);
        }
    }
}