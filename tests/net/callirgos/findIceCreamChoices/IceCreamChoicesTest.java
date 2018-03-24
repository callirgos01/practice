package net.callirgos.findIceCreamChoices;

import org.junit.jupiter.api.Test;

class IceCreamChoicesTest {

    @Test
    void choices() {

        int[] menu = new int[]{2,7,13,5,4,13,5};
        int money = 10;

        int[] results = new IceCreamChoices().choices(menu,money);

        for(Integer index : results) {
            System.out.println(index);
        }
    }
}