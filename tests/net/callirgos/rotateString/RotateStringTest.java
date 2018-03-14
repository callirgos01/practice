package net.callirgos.rotateString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateStringTest {

    @Test
    void rotateString() {
        String example1Input1 = "abcde";
        String example1Input2 = "cdeab";
        boolean expectedResult1= true;
        boolean actualResult1= new RotateString().rotateString(example1Input1, example1Input2);

        String example2Input1 = "aa";
        String example2Input2 = "a";
        boolean expectedResult2 = false;
        boolean actualResult2= new RotateString().rotateString(example2Input1, example2Input2);

        assertEquals(expectedResult1,actualResult1);
        assertEquals(expectedResult2,actualResult2);
    }
}