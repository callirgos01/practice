package net.callirgos.prims;

import java.util.ArrayList;
import java.util.List;

public class Graphing {
    // example of prim's algorithm to find the minimum spanning tree
    // create a node class
    // with connected array of nodes
    // List of weights per connection
    public static class Node {
        char val;
        public Node(char val) {
            this.val = val;
        }
    }
    public static class Weight {
        public Node src;
        public Node dst;
        public int weight;
        public Weight( Node src, Node dst, int weight){
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
    // apply prim's algorithm to find a min spanning tree
    public int minSpan( List<Node> nodes, List<Weight> weights) {
        int result = 0;
        List<Node> visited = new ArrayList<>();
        // start with any node
        // perhaps index 0
        visited.add(nodes.get(0));

        // find all nodes connected to any node in the visited list
        // that has not been visited yet
        // find the smallest weight
        // pick the one with smallest weight
        // add to visted
        // continue until all nodes are visited.
        while( visited.size() < nodes.size() ) {
            int smallestDistance = Integer.MAX_VALUE ;
            Node smallestNode = null;
            for( Node vivistedNode : visited) {
                for( Weight weight : weights ){
                    if( (weight.src == vivistedNode) && (!visited.contains(weight.dst))  ) {
                        // if source is visited and destination is not visited
                        // the weight between these two could be the smallest
                        if( weight.weight < smallestDistance ) {
                            smallestDistance = weight.weight;
                            smallestNode = weight.dst;
                        }
                    }
                }
            }
            visited.add(smallestNode);
            result += smallestDistance;
        }
        return result;
    }



}
