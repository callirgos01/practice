package net.callirgos.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    /*
     * Write a program that outputs the string representation of numbers from 1 to n.
     * But for multiples of three it should output “Fizz” instead of the number and for
     * the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     * Example:
     *  n = 15,
     *  Return:
     *  [
     *      "1",
     *      "2",
     *      "Fizz",
     *      "4",
     *      "Buzz",
     *      "Fizz",
     *      "7",
     *      "8",
     *      "Fizz",
     *      "Buzz",
     *      "11",
     *      "Fizz",
     *      "13",
     *      "14",
     *      "FizzBuzz"
     *   ]
     */
    public List<String> fizzBuzz(int n) {
        String[][] fizzBuzzTable = new String[][]{{"FizzBuzz","Fizz"},{"Buzz",""}};
        ArrayList<String> result = new ArrayList<String>();
        for( int i = 1; i<=n; i++)
        {
            fizzBuzzTable[1][1] = String.format("%d",i);
            result.add(fizzBuzzTable[((i%3)==0)?0:1][((i%5)==0)?0:1]);
        }
        return result;
    }

}
