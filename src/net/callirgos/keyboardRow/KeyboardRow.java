package net.callirgos.keyboardRow;

import java.util.ArrayList;

public class KeyboardRow {
    /*
    * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
    * American keyboard
    * Example 1:
    *   Input: ["Hello", "Alaska", "Dad", "Peace"]
    *   Output: ["Alaska", "Dad"]
    * Note:
    *   You may use one character in the keyboard more than once.
    *   You may assume the input string will only contain letters of alphabet.
    * */
    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for(String word : words)
        {
            if(word.matches("[qwertyuiopQWERTYUIOP]*" ) )
            {
                result.add(word);
            }
            if(word.matches("[asdfghjklASDFGHJKL]*" ) )
            {
                result.add(word);
            }
            if(word.matches("[zxcvbnmZXCVBNM]*" ) )
            {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
