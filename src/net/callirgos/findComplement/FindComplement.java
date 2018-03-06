package net.callirgos.findComplement;

public class FindComplement {

    /*
    * Given a positive integer, output its complement number.
    * The complement strategy is to flip the bits of its binary representation.
    * Note:
    * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    * You could assume no leading zero bit in the integer’s binary representation.
    * Example 1:
    *   Input: 5  101
    *   Output: 2 010
    * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
    * Example 2:
    *   Input: 1
    *   Output: 0
    * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
    * */
    public int findComplement(int num) {

        int result = 0;
        int rolling = 0;
        int checkInput = num;
        System.out.printf("num %d\r\n",num);
        while ( num != 0 )
        {
            if( (checkInput & ( 1 << (rolling))) == 0 ) {//if the current bit is 0, set the corresponding bit to 1
                result |= ( 1 << (rolling));
            }
            num>>=1;
            rolling++;
        }


        return result;
    }

}
