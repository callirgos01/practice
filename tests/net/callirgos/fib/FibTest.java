package net.callirgos.fib;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FibTest {

    @Test
    void fib() {
        int toFib = 37;
        for(int i=0; i< toFib; i++) {
            System.out.printf("recu fib of %d = %f\r\n", i, new Fib().fib(i));
        }
    }

    @Test
    void fibMemo() {

        int toFib = 37;
        for(int i=0; i< toFib; i++) {
            System.out.printf("memo fib of %d = %f\r\n", i, new Fib().fibMemo(i));
        }
    }
}