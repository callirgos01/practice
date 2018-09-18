package net.callirgos.stacksAndQueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        for( int i = 1; i< 6; i++) {
            int actual = stack.pop();
            int expected = i;
            System.out.printf("%d = %d\r\n", actual, expected);
            assertEquals(actual, expected);
        }
    }

    @Test
    void pop() {
    }

    @Test
    void isEmpty() {
    }
}