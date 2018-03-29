package net.callirgos.anagramMapping;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramMapping {
    /*
    * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by
    * randomizing the order of the elements in A.
    * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element
    * in A appears in B at index j.
    * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
    * For example, given
    *   A = [12, 28, 46, 32, 50]
    *   B = [50, 12, 32, 46, 28]
    * We should return
    *   [1, 4, 3, 2, 0]
    * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element
    * of A appears at B[4], and so on.
    * Note:
    *   A, B have equal lengths in range [1, 100].
    *   A[i], B[i] are integers in range [0, 10^5].
    * */
    /* general algorithm for all sliding window algos

    * public class Solution {
            public List<Integer> findAnagrams(String s, String t) {
                List<Integer> result = new LinkedList<>();
                if(t.length()> s.length()) return result;
                Map<Character, Integer> map = new HashMap<>();
                for(char c : t.toCharArray()){
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                int counter = map.size();

                int begin = 0, end = 0;
                int head = 0;
                int len = Integer.MAX_VALUE;


                while(end < s.length()){
                    char c = s.charAt(end);
                    if( map.containsKey(c) ){
                        map.put(c, map.get(c)-1);
                        if(map.get(c) == 0) counter--;
                    }
                    end++;

                    while(counter == 0){
                        char tempc = s.charAt(begin);
                        if(map.containsKey(tempc)){
                            map.put(tempc, map.get(tempc) + 1);
                            if(map.get(tempc) > 0){
                                counter++;
                            }
                        }
                        if(end-begin == t.length()){
                            result.add(begin);
                        }
                        begin++;
                    }

                }
                return result;
            }
        }
    * */
    public int[] anagramMappings(int[] A, int[] B) {
        int[] P = new int[A.length];
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                if(A[i] == B[j])
                {
                    P[i] = j;
                    break;
                }
            }
        }
        return P;
    }
    /*
    * Given two strings (lower case a->z) how many characters do we need to remove (from either)
    * to make them anagrams?
    * */
    public int anagramSteps(String A, String B) {
        int [] occuranceA = new int[26];
        int [] occuranceB = new int[26];
        for(Character c : A.toCharArray()) {
            occuranceA[c-'a']++;
        }
        for(Character c : B.toCharArray()) {
            occuranceB[c-'a']++;
        }
        //differences
        int differences = 0;
        for(int i = 0; i<26; i++) {
            if(occuranceA[i] != occuranceB[i]) {
                differences +=  Math.abs(occuranceA[i]-occuranceB[i]);
            }
        }
        return differences;
    }
}
