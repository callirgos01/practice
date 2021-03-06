package net.callirgos.cryptoQuestion;

import java.util.HashMap;

public class CryptopQuestion {
    //given an array of value
    //where the position of the value in the array
    // correlates to the time the reading what taken
    // return the greatest positive change between two values in the array.

    public int maxProfit(int[] prices) {
        // Iterate through the array
        // once you have found that the value in index i
        // added with the value at index i + j
        // is greater than the value calculated previously (or 0)
        // make that value the response
        // save those indexes
        // continue searching through the array
        // for a sum that is greater
        int maxProfit = 0;
        int minPrice = 0;
        for( int i=0; i<prices.length; i++) {
          if(prices[i]< minPrice) {
              minPrice = prices[i];
          }
          else if( prices[i]-minPrice > maxProfit) {
              maxProfit = prices[i] - minPrice;
          }

        }
        return maxProfit;
    }

}
