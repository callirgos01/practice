package net.callirgos.cryptoQuestion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptopQuestionTest {

    @Test
    void maxProfit() {
        //basic example
        //                           0  1  2  3  4  5   6  7  8  9  10
        int [] example1 = new int[]{ 7, 1, 5, 3, 6, 4 };
        int maxProfile = new CryptopQuestion().maxProfit(example1);
        System.out.println(maxProfile);
    }
}