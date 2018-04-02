package net.callirgos.googleFriend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {
    void printCircularLinkedList(CircularBuffer.Node root){
        CircularBuffer.Node iterator = root;
        while(iterator.next != root) {
            System.out.printf("%d -> ", iterator.val);
            iterator = iterator.next;
        }
        System.out.println(iterator.val);
    }
    @Test
    void removeEveryOtherNode() {
        CircularBuffer.Node root = new CircularBuffer.Node(2);
        root.next = new CircularBuffer.Node(1);
        root.next.next = new CircularBuffer.Node(3);
        root.next.next.next = new CircularBuffer.Node(4);
        root.next.next.next.next= root;

        printCircularLinkedList(root);

        CircularBuffer.Node result = new CircularBuffer().removeEveryOtherNode(root);

        printCircularLinkedList(result);

    }
}