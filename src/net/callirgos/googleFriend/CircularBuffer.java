package net.callirgos.googleFriend;

import java.util.ArrayList;
import java.util.List;

public class CircularBuffer {
    public static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public Node removeEveryOtherNode(Node root) {
        Node iterator = root;
        Node res = new Node(0);
        Node res_iterator = res;
        boolean include = false;

        do {
            if(include) {
                include = false;
                res_iterator.next = new Node(iterator.val);
                res_iterator = res_iterator.next;
            }
            else {
                include = true;
            }

            iterator = iterator.next;
        } while(iterator != root);

        res_iterator.next = res.next;
        return res.next;
    }

}
