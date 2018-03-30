
package net.callirgos.Amazon;
import org.junit.jupiter.api.Test;

import java.util.List;

class AmazonTest {

    @Test
    public void subStringTest(){
        String input = "awaglknagawunagwkwagl";
        int input2 = 4;
        List<String> output =  new Amazon.PhoneScreen().subStringsKDist(input, input2);

        System.out.println(input);
        for(String cut : output) {
            System.out.println(cut);
        }

    }
}