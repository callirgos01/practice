package net.callirgos.dailyTemperatures;

import java.util.ArrayList;
import java.util.List;

public class DailyTemperatures {
    /*
    * Given a list of daily temperatures, produce a list that, for each day in the input, tells
    * you how many days you would have to wait until a warmer temperature.
    * If there is no future day for which this is possible, put 0 instead.
    * For example, given the
    *   list temperatures =
    *       [73, 74, 75, 71, 69, 72, 76, 73],
    * your output should be
    *       [1, 1, 4, 2, 1, 1, 0, 0].
    * Note: The length of temperatures will be in the range [1, 30000].
    * Each temperature will be an integer in the range [30, 100].
    */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        //iterate through the array.
        //for every array iterate the remaining array comparing temp.
        //if greater, add dfiference in indexes to the result list. and break out of the inner loop
        //if less continue searching.
        //if we get to the end of the list,
        //add 0 to the result list
        for( int i=0; i < temperatures.length; i++)
        {
            for( int j = i+1; j< temperatures.length; j++)
            {
                if( temperatures[i] < temperatures[j])
                {
                    results[i] = j - i;
                    break;
                }
            }
        }
        return results;
    }
}
