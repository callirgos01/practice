package net.callirgos.Facebook;

import java.util.*;

public class Facebook {
    public static class PhoneScreen {
        // on the phone screen I have gotten
        // I got one question
        // find the length of any sub array that sums up to the target
        // Given and array, give me the length of the array of the sums
        public int sumOfK(int[] nums, int k) {
            int res = 0;
            int runningSum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                runningSum += nums[i];

                int j = map.getOrDefault(runningSum - k, i);
                if (j != i) {
                    return i - j;
                }
                map.put(runningSum, i);
            }
            return res;
        }

        // These problems I have not gotten
        // but I need preactice with these for facebook
        private void backtrack(int[] nums, int index, List<List<Integer>> subSets, Integer[] subSet) {
            if (index == nums.length) {
                List<Integer> subset = new ArrayList<>();
                for (Integer i : subSet) {
                    if (i != null) {
                        subset.add(i);
                    }
                }
                subSets.add(subset);
            } else {
                subSet[index] = nums[index];
                backtrack(nums, index + 1, subSets, subSet);
                subSet[index] = null;
                backtrack(nums, index + 1, subSets, subSet);
            }
        }

        // combinations / permutations
        public List<List<Integer>> subSets(int[] nums) {
            List<List<Integer>> subSets = new ArrayList<>();
            Integer[] subSet = new Integer[nums.length];
            Arrays.fill(subSet, null);

            backtrack(nums, 0, subSets, subSet);
            return subSets;
        }

        // Given a string containing parenthesis (), braces {}, brackets [], and angle
        // brackets <>,
        // write a function to check if that string is balanced, and False otherwise.

        // A string is considered balanced if each opening bracket is followed by a
        // matching
        // closing bracket at the same nesting level, and each closing bracket has been
        // preceded
        // by a matching opening bracket also at the same nesting level.
        // Some examples:

        // "some string" => True

        // "[abc(def)gh{i}j]" => True

        // "[abcdef" => False (no closing bracket)

        // "abcd(egf))" => False (extra closing parenthesis)

        private boolean isValid(char c, char parenth, Stack<Character> parenths) {
            if (!parenths.isEmpty() || parenths.pop() != parenth) {
                return false;
            }
            return true;
        }

        private boolean isOpenning(char c) {
            return c == '(' || c == '{' || c == '[' || c == '<';
        }

        private boolean processCharacter(char c, Stack<Character> stack) {
            if (isOpenning(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (c) {
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
            return true;
        }
        public boolean isBalanced(String s) {
            Stack<Character> parenths = new Stack<Character>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!processCharacter(c, parenths)) {
                    return false;
                }
            }
            return parenths.isEmpty();
        }

        public List<Character> alienDictionary(List<String> dictionary) {
            List<Character> result = new ArrayList<>();

            for(int i=0; i< dictionary.size()-1; i++) {
                String first = dictionary.get(i);
                String next = dictionary.get(i + 1);
                if (!result.contains(first.charAt(0))) {
                    result.add(first.charAt(0));
                }
                if (!result.contains(next.charAt(0))) {
                    result.add(next.charAt(0));
                }
            }

            for(int i=0; i< dictionary.size()-1; i++) {
                String first = dictionary.get(i);
                String next = dictionary.get(i + 1);
                for(int j=0; j< Math.min(first.length(), next.length()); j++) {
                    if(first.charAt(j) != next.charAt(j)) {
                        if (!result.contains(first.charAt(j))) {
                            result.add(first.charAt(j));
                        }
                        if (!result.contains(next.charAt(j))) {
                            result.add(next.charAt(j));
                        }
                        break;
                    }
                }
            }
            return result;
        }
        /*
         * words = ['cc', 'cb', 'bb', 'ac', 'ad'] c -> b -> a words = ['ab', 'bc', 'cd',
         * 'da']
         *
         * Array<string> => Array<char>
         *
         * // c (c) b a (a) cba
         *
         * // c b (b) (c) d cbd
         *
         * 'cca' 'cbx'
         *
         * // => c b
         *
         * //cb 'bb' // => c b
         *
         * // bb 'ac' // b a
         *
         *
         *
         * //cbad //cdba //cbda
         *
         * // if the first letter is the same // ignore //
         */
        void comparison(String word1, String word2, List<Character> alphabet) {
            // edge cases
            //
            for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {

                if (word1.charAt(i) != word2.charAt(i)) {
                    if (!alphabet.contains(word1.charAt(i))) {
                        alphabet.add(word1.charAt(i));
                    }
                    if (!alphabet.contains(word2.charAt(i))) {
                        alphabet.add(word2.charAt(i));
                    }
                }
            }

        }

    }
}
