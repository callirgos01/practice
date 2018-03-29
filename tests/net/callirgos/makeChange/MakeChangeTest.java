package net.callirgos.makeChange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeChangeTest {

    private String arrayToString(int[] toConvert){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for( Integer i : toConvert) {
            sb.append(String.format("%d ",i));
        }
        sb.append("}");

        return sb.toString();
    }
    @Test
    void makeChange() {
        int[] coins = {25, 10, 5, 1};
        MakeChange makeChange = new MakeChange();
       // makeChange.makeChangeMemo(coins,100000);
        for(int money = 0; money < 1000; money++) {
            assertEquals(makeChange.makeChangeMemo(coins,money) ,new MakeChange().makeChange(coins, money) );
        }
    }
}
