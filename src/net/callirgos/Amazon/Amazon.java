package net.callirgos.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Amazon {
    public static class PhoneScreen {
        /*
        * given a string, break up the string by k digits
        * make sure there are no repeating characters
        * do not repeat outputs
        **/
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<String> subStringsKDist(String inputStr, int num) {
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            while(!inputStr.isEmpty()) {
                Character c = inputStr.charAt(0);
                int indexOfChar = sb.indexOf(String.valueOf(c));
                if(indexOfChar!=-1) {
                    //we have a repeat coming in
                    //System.out.println(sb.toString());
                    sb = new StringBuilder(sb.substring(indexOfChar+1));
                }
                sb.append(c);
                if(sb.length()==4) {
                    if(!res.contains(sb.toString()))
                        res.add(sb.toString());
                    sb = new StringBuilder(sb.substring(1));
                }
                inputStr = inputStr.substring(1);
            }
            return res;
        }
    }
    public class OnSite {

    }
}
