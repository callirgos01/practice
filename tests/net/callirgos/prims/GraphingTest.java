package net.callirgos.prims;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphingTest {

    @Test
    void minSpan() {
        //create a graph
            //create all nodes
        List<Graphing.Node> nodes = new ArrayList<>();
        for( int i=0; i <= ('G'-'A'); i++) {
            nodes.add(new Graphing.Node((char)(i+'A')));
        }
        // 0 = A
        // 6 = G
        List<Graphing.Weight> vertices = new ArrayList<>();
        //A
        vertices.add(new Graphing.Weight(nodes.get(0), nodes.get(1),2));
        vertices.add(new Graphing.Weight(nodes.get(0), nodes.get(2),3));
        vertices.add(new Graphing.Weight(nodes.get(0), nodes.get(3),3));
        //B
        vertices.add(new Graphing.Weight(nodes.get(1), nodes.get(0),2));
        vertices.add(new Graphing.Weight(nodes.get(1), nodes.get(2),4));
        vertices.add(new Graphing.Weight(nodes.get(1), nodes.get(4),3));
        //C
        vertices.add(new Graphing.Weight(nodes.get(2), nodes.get(0),3));
        vertices.add(new Graphing.Weight(nodes.get(2), nodes.get(1),4));
        vertices.add(new Graphing.Weight(nodes.get(2), nodes.get(3),5));
        vertices.add(new Graphing.Weight(nodes.get(2), nodes.get(5),6));
        vertices.add(new Graphing.Weight(nodes.get(2), nodes.get(4),1));
        //D
        vertices.add(new Graphing.Weight(nodes.get(3), nodes.get(0),3));
        vertices.add(new Graphing.Weight(nodes.get(3), nodes.get(2),5));
        vertices.add(new Graphing.Weight(nodes.get(3), nodes.get(5),6));
        //E
        vertices.add(new Graphing.Weight(nodes.get(4), nodes.get(1),3));
        vertices.add(new Graphing.Weight(nodes.get(4), nodes.get(2),1));
        vertices.add(new Graphing.Weight(nodes.get(4), nodes.get(5),8));
        //F
        vertices.add(new Graphing.Weight(nodes.get(5), nodes.get(3),7));
        vertices.add(new Graphing.Weight(nodes.get(5), nodes.get(2),6));
        vertices.add(new Graphing.Weight(nodes.get(5), nodes.get(4),8));
        vertices.add(new Graphing.Weight(nodes.get(5), nodes.get(6),9));
        //G
        vertices.add(new Graphing.Weight(nodes.get(6), nodes.get(5),9));

        for( Graphing.Weight weight : vertices ){
            System.out.printf("%c->%d->%c\r\n", weight.src.val, weight.weight, weight.dst.val);
        }

        System.out.println(new Graphing().minSpan(nodes, vertices) );
    }
}