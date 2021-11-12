package ram.dsa.graph;

import java.util.Arrays;
import java.util.List;

public class AdjListExample {

    public static void main(String[] args) {

        Graph g = new Graph(List.of("A","B","C","D"));
        g.addNgbr("A","B",true);
        g.addNgbr("B","C",true);
        g.addNgbr("C","D",true);
        g.addNgbr("A","C",true);
        g.addNgbrs("D",List.of("B","C"));
        g.printGraph();

        BfsImpl bsf = new BfsImpl(g);
        bsf.bfs("A");

        DfsImpl dsf = new DfsImpl(g);
        dsf.dfs("A");
    }
}
