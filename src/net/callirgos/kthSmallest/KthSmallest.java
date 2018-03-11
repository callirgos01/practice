package net.callirgos.kthSmallest;

import java.util.Arrays;

public class KthSmallest {
    /*
    * Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from
    * the multiplication table?
    * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return
    * the k-th smallest number in this table.
    * Example 1:
    * Input:
    *       m = 3, n = 3, k = 5
    * Output:
    *       5
    * Explanation:
    *   The Multiplication Table:
    *  1	2    3
    *  2	4	 6
    *  3	6	 9
    * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
    * Example 2:
    * Input:
    *       m = 2, n = 3, k = 6
    * Output:
    *       6
    * Explanation:
    *   The Multiplication Table:
    *   1	 2	  3
    *   2	 4	  6
    * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
    * Note:
    *   The m and n will be in the range [1, 30000].
    *   The k will be in the range [1, m * n]
    * */
   /* public int findKthNumber(int m, int n, int k) {
        int [] mTable = new int[m*n];
        for(int row=0; row<m; row++)
        {
            for(int col=0; col<n; col++)
            {
                mTable[(row*n)+(col)] = (row+1)*(col+1);
            }
        }
        Arrays.sort(mTable);
        return mTable[k-1];
    }*/
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}
