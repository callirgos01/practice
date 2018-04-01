package net.callirgos.Google;

public class Google {
    public static class PhoneScreen {
        //3 questions
        // question 1
        // Give me a character array, write a function that will convert the character array into an integer.
        // it is possible this might have been the starting question
        // and that this might have lead to other questions
        // I took so long to get this simple answer out he did not ask anything further.
        // I will input this into leetcode, and go through all the edge cases of a ral atoi
        public int atoi(String toConvert) {
            //this was an easy one
            //no edge cases to cover at first
            //assume the input is an integer
            int result = 0;
            int sign = 1;
            for(Character c : toConvert.toCharArray()) {
                if(c=='-') {
                    sign = -1;
                } else {
                    result *= 10;
                    result += (c-'0');
                }
            }

            return result*sign;
        }
        //question 2
        //implement lazy copy string

        //question 3
        // Given an array of ints
        // How many combinations of ints will add up to target
        //this is a classic dynamic programming question

    }
}
