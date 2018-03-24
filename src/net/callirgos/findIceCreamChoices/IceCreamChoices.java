package net.callirgos.findIceCreamChoices;

import java.util.HashMap;

public class IceCreamChoices {
    //find two  indices that together will add up to all our money
    //gotta be two unique indices
    public int[] choices(int[] menu, int money) {
        int[] results = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<menu.length; i++) {
            int compliment = money - menu[i];
            if(map.containsKey(compliment)) {
                results[0] = map.get(compliment)+1;
                results[1] = i+1;
                break;
            }
            map.put(menu[i], i);
        }
        return results;
    }
}
