package net.callirgos.Google;

import java.util.*;

public class Google {
    public static class Banned {
        public static class ListNode {
            int val;
            ListNode next;
            public ListNode(int val) {
                this.val=val;
            }
        }
        private long backtrack(List<Integer> patterns, int max ) {
            if(patterns.size() == max) {
                //print list
                /*System.out.printf("%d[ ", max);
                for( Integer number : patterns){
                    System.out.printf("%d ", number);
                }
                System.out.println("]");
                */
                return 1;
            }
            long count = 0;
            for( int i=1; i< 10; i++ ) {
                patterns.add(i);
                count += backtrack(patterns, max);
                patterns.remove(patterns.size()-1);
            }
            return count;
        }
        // how many different security codes can you create with the numbers 1 to 9;
        public long combinations() {
            long count = 0;
            for( int i = 9; i< 10; i++) {
                long _count = backtrack(new ArrayList<>(), i);
                System.out.printf("[%d] %d\r\n", i, _count);
                count += _count;
            }
            return count;
        }

        private int dfs( int[][] matrix, int row, int col, HashMap<String,Integer> memo, List<Integer> path ) {

            if( row < 0 || row > matrix.length || col <0 || col > matrix[0].length ) {
                return 0;
            }

            path.add(matrix[row][col]);

            String key = String.format("%d-%d", row, col);
            //if(memo.containsKey(key)) {
              // path.remove(path.size()-1);
               // return memo.get(key);
          //  }
            int distance = 1;
            int longestDistance = 0;
            System.out.printf("[%d][%d] = %d\r\n", row, col, matrix[row][col] );
            // go search through all children
            // children are all adjacent points
            // where current number is less than child
            // down
            if ( row < matrix.length-1 && matrix[row][col] < matrix[row+1][col]) {
                System.out.printf("=>[%d][%d] = %d\r\n", row+1, col, matrix[row+1][col] );
                distance = 1 + dfs(matrix, row+1, col, memo, path);
                longestDistance = Math.max(longestDistance, distance);
            }
            //right
            if (col < matrix[0].length-1 && matrix[row][col] < matrix[row][col+1]) {
                System.out.printf("=>[%d][%d] = %d\r\n", row, col+1, matrix[row][col+1] );
                distance = 1 + dfs(matrix, row, col+1, memo, path);
                longestDistance = Math.max(longestDistance, distance);
            }

            //up
            if (row>0 && matrix[row][col] < matrix[row-1][col]) {
                System.out.printf("=>[%d][%d] = %d\r\n", row-1, col, matrix[row-1][col] );
                distance = 1 + dfs(matrix, row-1, col, memo, path);
                longestDistance = Math.max(longestDistance, distance);
            }
            // left
            if (col>0 && matrix[row][col] < matrix[row][col-1]) {
                System.out.printf("=>[%d][%d] = %d\r\n", row, col-1, matrix[row][col-1] );
                distance = 1 + dfs(matrix, row, col-1, memo, path);
                longestDistance = Math.max(longestDistance, distance);
            }

            System.out.printf("path (%d) [ ", path.size());
            for(Integer step : path) {
                System.out.printf("%d ", step);
            }
            System.out.println("]");

            path.remove(path.size()-1);

            longestDistance = Math.max(longestDistance, distance);

            memo.put(key, longestDistance);
            return memo.get(key);
        }
        // longest incrementing path
        public int longestIncPath( int[][] matrix) {

            int length_max = 0;
            int length = 0;
            List<Integer> longestPath = new ArrayList<>();
            // iterate through the length starting at every node
            // record longest
            for( int row=0; row < matrix.length; row++ ){
                for( int col=0; col < matrix[0].length; col++ ) {
                    List<Integer> path = new ArrayList<>();
                    length = dfs(matrix, row, col, new HashMap<>(), path );


                    System.out.printf(" longest path from [%d][%d] (%d) [ ",row,col,length);
                    for(Integer step : path) {
                        System.out.printf("%d ", step);
                    }
                    System.out.println("]");

                    length_max = Math.max( length, length_max );
                    if(length_max == length){
                        longestPath = path;
                    }
                }
            }
            System.out.printf("longest (%d) [ ", longestPath.size());
            for(Integer step : longestPath) {
                System.out.printf("%d ", step);
            }
            System.out.println("]");
            return length_max;
        }

        public ListNode everyOtherNodeInTheList( ListNode root ) {
            ListNode result = new ListNode(0);
            ListNode result_ptr = result;

            while(root!=null && root.next != null ) {
               // nodes.add(root);
                result.next = root;
                result = result.next;
                root = root.next.next;
            }
            result.next = null;
            return result_ptr.next;
        }
    }
    public static class GooglePrepSession {
        //determine whether a circular array of relative indices is composed of a single complete cycle
        // what's a circular array?
        // relative indeces?
        // An array of integers, where each cell's value points to another cell relative to it.
        // Clarify the problem
        // circular buffer - you know this, you have implemented this before
        // what's a cycle when you can start at a point and return to that point by following relative indices
        // a cycle that hits every element of the array
        // consider a good example
        // start with brute foce
        // pick a node
        // go through
        // make sure you have hit every node
        // make sure you have reached the starting node
        // Determine wheter a circular array of relative indeces is composed of a single coimplete cycle
        public boolean isCompleteCycle( int[] input ) {
            int currentPosition = 0;
            for(int i=0; i< input.length; i++ ) {
                //System.out.println(i);
                // we will start on the first index.
                /// only the last element should take me to index 0 after being normalized
                currentPosition += input[i]; // get new position
                // normalize
                currentPosition %= input.length;
                if( currentPosition<0 ) {
                    currentPosition += input.length;
                }
                // if this current position is 0 after normalization, then it better be the last cycle
                // i == input.length -1
                // watch  the end of the iteration
                if((i < (input.length - 1)) && (currentPosition == 0)) {
                    return false;
                }
            }
            return currentPosition == 0;
        }
    }
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
        //its a combination of deep copy and shadow copy

        //question 3
        // Given an array of ints
        // How many combinations of ints will add up to target
        //this is a classic dynamic programming question
        private int backtrackMemo(int[] nums, int target, int index, HashMap<String, Integer> memo) {
            String key = String.format("%d-%d", target,index);
            if(memo.containsKey(key)){
                return memo.get(key);
            }
            if(target == 0) {
                return 1;
            }
            if(target<0){
                return 0;
            }
            if(index >= nums.length) {
                return 0;
            }
            //if target is smaller than the current number
            // then we cant add the current number
            // there is no way this number can ADD UP to the target
            //so we move on to the next index

            int toReturn;
            if(target < nums[index]) {
                toReturn = backtrackMemo(nums,target,index+1, memo);
            } else {
                toReturn = backtrackMemo(nums, target - nums[index], index + 1, memo) +
                        backtrackMemo(nums, target, index + 1, memo);
            }

            //System.out.println(key);
            memo.put(key, toReturn);
            return toReturn;
        }
        private int backtrackRec(int[] nums, int target, int index) {
            if(target == 0) {
                return 1;
            }
            if(target<0){
                return 0;
            }
            if(index >= nums.length) {
                return 0;
            }
            //if target is smaller than the current number
            // then we cant add the current number
            // there is no way this number can ADD UP to the target
            //so we move on to the next index

            if(target < nums[index]) {
                return backtrackRec(nums,target,index+1);
            } else {
                return backtrackRec(nums, target - nums[index], index + 1) +
                        backtrackRec(nums, target, index + 1);
            }
        }
        public int possibleSumsRec(int[] nums, int target) {
            return backtrackRec(nums, target, 0);

        }
        public int possibleSumsMemo(int[] nums, int target) {

            return backtrackMemo(nums, target, 0, new HashMap<>());
        }


    }
}
