package net.callirgos.contMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    private void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.isEmpty() || number < lowers.peek()) {
           lowers.add(number);
        } else {
            highers.add(number);
        }
    }
    private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap =  lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if((biggerHeap.size() - smallerHeap.size())>=2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }
    private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        if(lowers.size() == highers.size()) {
            return ((double)lowers.peek() + highers.peek()) / 2;
        }
        else {
            PriorityQueue<Integer> biggerHeap =  lowers.size() > highers.size() ? lowers : highers;
            return biggerHeap.peek();
        }
    }
    public double[] getMedians(int[] array) {
        //max heap to the keep the highest number in one half.
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        //min heap to keep the lowest number of another half.
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        double[] medians = new double[array.length];
        for(int i=0; i<array.length; i++) {
            int number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers,highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }
}
