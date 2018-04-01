package net.callirgos.Amazon;

import java.util.*;

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
                char c = inputStr.charAt(0);
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
        //there was one more in the phone screen
        //but I honestly did not understand the question
        //it was something about scenes and making shots out of none repeating shots
        //here's my attempt at it
        //I got it to build within the alloted time
        //I did not get the right answer
        private class ShotInfo{
            public int startIndex;
            public int endingIndex;
            public boolean included;
            public ShotInfo(){}
            public ShotInfo(int start, int end, boolean included) {
                this.startIndex = start;
                this.endingIndex = end;
                this.included = included;
            }
        }
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<Integer> LengthEachScene(List<Character> inputList) {
            List<Integer> result = new ArrayList<>();
            HashMap<Character, ShotInfo> trackingShots = new HashMap<>();
            // WRITE YOUR CODE HERE
            //iterate through the input List
            for (int i = 0; i < inputList.size(); i++) {
                //keep track of the first and last instance of each character.
                if (trackingShots.containsKey(inputList.get(i))) {
                    ShotInfo temp = new ShotInfo();
                    temp.startIndex = trackingShots.get(inputList.get(i)).startIndex;
                    temp.endingIndex = i;
                    temp.included = false;
                    trackingShots.put(inputList.get(i), temp);// = temp;
                } else {
                    trackingShots.put(inputList.get(i), new ShotInfo( i, i, false));
                }
                //we can now now the minimum length for each shot to only appear once.
            }
            for(Character key : trackingShots.keySet()) {// (KeyValuePair<char, ShotInfo> shotInfo in trackingShots)
                ShotInfo shotInfo = trackingShots.get(key);
                if (!shotInfo.included) {
                    //shotInfo.Value.included = true;
                    int startingIndex = shotInfo.startIndex;
                    int endingIndex = shotInfo.endingIndex;
                    int sequenceLength = 0;
                    if (startingIndex == endingIndex) {
                        sequenceLength = 1;
                    } else {
                        // sequenceLength = getSequenceLength(trackingShots, );
                        for (int i = startingIndex; i < endingIndex; i++) {
                            //update ending index, if any shot inside your sequence has another instance
                            int subSequenceStart = trackingShots.get(inputList.get(i)).startIndex;
                            int sunSequenceEnd = trackingShots.get(inputList.get(i)).endingIndex;
                            if (endingIndex < sunSequenceEnd)
                            {
                                endingIndex = sunSequenceEnd;
                            }
                            //update included for all the shots in your sequence so they are ignored on the next pass
                            trackingShots.put(inputList.get(i), new ShotInfo( subSequenceStart, sunSequenceEnd, true ));
                        }
                        sequenceLength = endingIndex - startingIndex;
                    }
                    result.add(sequenceLength);
                }
            }
            //then go through the list of shotsInfor.
            //compare starting and end indexes of each shot.
            //to determine the length of each sequence.
            //per the characters in each sequence.
            return result;

        }
    }

    public static class OnSite {
        /*
        * Given a binary tree
        * serialize and deserialize it
        *
        * */
        public static class Codec {
            public static class TreeNode {
                int val;
                TreeNode right;
                TreeNode left;

                public TreeNode(int val) {
                    this.val = val;
                }
            }

            private void buildString(TreeNode root, StringBuilder sb) {
                if (root == null) {
                    sb.append("n ");
                } else {
                    sb.append(root.val).append(" ");
                    buildString(root.right, sb);
                    buildString(root.left, sb);
                }

            }

            public String encodeTree(TreeNode root) {
                StringBuilder sb = new StringBuilder();
                buildString(root, sb);
                return sb.toString();
            }

            private TreeNode buildTree(Queue<String> nodes) {
                String val = nodes.poll();
                if (val.equals("n")) {
                    return null;
                } else {
                    TreeNode newNode = new TreeNode(Integer.valueOf(val));
                    newNode.right = buildTree(nodes);
                    newNode.left = buildTree(nodes);
                    return newNode;
                }

            }

            public TreeNode decodeTree(String data) {
                Queue<String> nodes = new LinkedList<>();
                nodes.addAll(Arrays.asList(data.split(" ")));
                return buildTree(nodes);
            }
        }
        /* Given an array of value
         * where the position of the value in the array
         * correlates to the time the reading what taken
         * return the greatest positive change between two values in the array.
         */
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
}
