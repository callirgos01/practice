package net.callirgos.kthSmallest;

import java.util.Arrays;

public class KthSmallest {

    public int findKthNumber(int m, int n, int k) {
        int [] mTable = new int[m*n];
        for(int row=0; row<m; row++)
        {
            for(int col=0; col<n; col++)
            {
                mTable[(row*m)+(col)] = (row+1)*(col+1);
            }
        }
        Arrays.sort(mTable);
        for( int num : mTable)
        {
            System.out.println(num);
        }
        return mTable[k-1];
    }

}
