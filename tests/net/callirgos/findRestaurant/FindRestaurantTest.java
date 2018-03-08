package net.callirgos.findRestaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindRestaurantTest {

    @Test
    void findRestaurant() {
        String[] example1Input1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] example1Input2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] expectedOutput1 = new String[]{"Shogun"};
        String[] actualOutput1 = new FindRestaurant().findRestaurant(example1Input1,example1Input2);

        String[] example2Input1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] example2Input2 = new String[]{"KFC", "Shogun", "Burger King"};
        String[] expectedOutput2 = new String[]{"Shogun"};
        String[] actualOutput2 = new FindRestaurant().findRestaurant(example2Input1,example2Input2);

        assertEquals(expectedOutput2.length, actualOutput2.length);
        for(int i=0; i<actualOutput2.length; i++)
        {
            assertEquals(expectedOutput2[i],actualOutput2[i]);
        }

        assertEquals(expectedOutput1.length, actualOutput1.length);
        for(int i=0; i<expectedOutput1.length; i++)
        {
            assertEquals(expectedOutput1[i],actualOutput1[i]);
        }
    }

}