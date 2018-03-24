package net.callirgos.fib;

public class Fib {
    public float fib(int toFib) {

        if (toFib <= 1) {
            return 1;
        }

        return fib(toFib - 2) + fib(toFib - 1);
    }
    private float fibMemoMem(int toFib, float[] memo) {
        if(toFib <= 1) {
            return 1;
        }
        if(memo[toFib] == 0) {
            memo[toFib] = fibMemoMem(toFib-2, memo) + fibMemoMem(toFib-1, memo);
        }
        return memo[toFib];
    }
    public float fibMemo(int toFib) {
        return fibMemoMem(toFib, new float[toFib+1]);
    }
}
