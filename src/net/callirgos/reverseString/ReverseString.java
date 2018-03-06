package net.callirgos.reverseString;

public class ReverseString {
    /*
     * Write a function that takes a string as input and returns the string reversed.
     * Example:
     * Given s = "hello", return "olleh".
    */

    public String reverseString(String s) {
        int[] allChars = s.chars().toArray();
        char[] reversedString = new char[allChars.length];
        for(int i = s.length()-1, j = 0; i>=0;i--, j++){
            reversedString[j] = (char)allChars[i];
        }
        return new String(reversedString);
    }

}
