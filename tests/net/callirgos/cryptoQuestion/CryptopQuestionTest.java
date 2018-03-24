package net.callirgos.cryptoQuestion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptopQuestionTest {

    @Test
    void maxProfit() {
        //basic example
        int [] example1 = new int[]{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40};
        int maxProfile = new CryptopQuestion().maxProfit(example1);
        System.out.println(maxProfile);
    }
}