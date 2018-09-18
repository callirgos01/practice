package net.callirgos.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    void push(int val) {
        queue1.add(val);
    }
    public int pop( ) {
        //reverse order
        //return top

        while(queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int result = queue1.remove();
        while(!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return result;
    }
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

}

