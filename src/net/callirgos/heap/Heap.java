package net.callirgos.heap;

import java.util.Arrays;

public class Heap {

    public static class MinHeap {
        private int capacity = 10;
        private int size = 0;

        int[] items = new int[capacity];
        private int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }
        private int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }
        private int getParentIndex(int childIndex) {
            return (childIndex-1) / 2;
        }
        private boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }
        private boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }
        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }
        private int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }
        private int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }
        private int parent(int index) {
            return items[getParentIndex(index)];
        }
        private void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }
        private void ensureExtraCapacity() {
            if(size == capacity) {
                items = Arrays.copyOf(items, capacity*2);
                capacity *= 2;
            }
        }
        private void heapifyDown() {
            int index = 0; // from the root
            //check if we have a left child.
                //we do - am I smaller than it
                    //yes - swap
                    //no - DONE
                //we dont - check if we have a right child
                    //we do - am I smaller than it?
                        //yes - swap
                        //no - DONE
                //we dont
                    //done!
            while(hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (items[smallerChildIndex] > items[index]) {
                    //exit condition
                    // current node is smaller than all children
                    break;
                }
                swap(smallerChildIndex, index);
                index = smallerChildIndex;
            }
        }
        private void heapifyUp() {
            //start with the last value we added
            //then its gonna walk up
            //as long as there is a parent item
            //and as long as we are out of order
            //swap parent with index
            //as long as parent item is bigger than me, then swap
            int index = size-1;
            while(hasParent(index) && parent(index) > items[index]) {
                swap(index,getParentIndex(index));
                index = getParentIndex(index);
            }
        }

        public int peek() {
            if(size == 0) throw new IllegalStateException();
            return items[0];
        }
        public int poll() {
            if(size == 0) throw new IllegalStateException();
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapifyDown();
            return item;
        }

        public void add(int item) {
            ensureExtraCapacity();

            items[size] = item;
            size++;
            heapifyUp();
        }
    }

}
