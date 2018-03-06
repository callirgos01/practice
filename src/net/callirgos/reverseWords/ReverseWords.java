package net.callirgos.reverseWords;

import java.util.ArrayList;

public class ReverseWords {

    /*
    * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    * Example 1:
    * Input: "Let's take LeetCode contest"
    * Output: "s'teL ekat edoCteeL tsetnoc"
    * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
    * */


    private String reverseString(String s) {
        int[] allChars = s.chars().toArray();
        char[] reversedString = new char[allChars.length];
        for(int i = s.length()-1, j = 0; i>=0;i--, j++){
            reversedString[j] = (char)allChars[i];
        }
        return new String(reversedString);
    }


    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for( int i =0; i< words.length; i++) {
            words[i] = reverseString((words[i]));
        }
        return String.join(" ", words);
    }

}
