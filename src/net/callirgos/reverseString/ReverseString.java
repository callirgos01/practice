package net.callirgos.reverseString;

public class ReverseString {
    /*
     * Write a function that takes a string as input and returns the string reversed.
     * Example:
     * Given s = "hello", return "olleh".
    */

    public String reverseString(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] allChars = s.toCharArray();

        while(left<right) {
            char temp = allChars[left];
            allChars[left] = allChars[right];
            allChars[right] = temp;
            left++;
            right--;
        }
        return new String(allChars);
    }

}
