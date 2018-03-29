package net.callirgos.makeChange;

import java.util.HashMap;

public class MakeChange {
    final static HashMap<String, Long> longMap = new HashMap<>();

    private long makeChangeRec(int[] coins, int money, int index) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        int amountWitCoins = 0;
        int ways = 0;
        while (amountWitCoins <= money) {
            int remaining = money - amountWitCoins;
            ways += makeChangeRec(coins, remaining, index + 1);
            amountWitCoins += coins[index];
        }

        return ways;
    }
    private long makeChangeMem(int[] coins, int money, int index, HashMap<String, Long> map) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        int amountWitCoins = 0;
        long ways = 0;
        String key = String.format("%d-%d",money,index);
        if(map.containsKey(key)) {
            return map.get(key);
        }
        while (amountWitCoins <= money) {
            int remaining = money - amountWitCoins;
            ways += makeChangeMem(coins, remaining, index+1, map);
            amountWitCoins += coins[index];
        }
        map.put(key, ways);
        return ways;
    }


    public long makeChangeMemo(int[] coins, int money) {
        return makeChangeMem(coins,money, 0, longMap);
    }
    public long makeChange(int[] coins, int money) {
        return makeChangeRec(coins,money, 0);
    }
}
