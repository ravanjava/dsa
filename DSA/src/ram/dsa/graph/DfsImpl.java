package ram.dsa.graph;

import java.util.HashMap;
import java.util.Map;

public class DfsImpl {

    Map<String, Boolean> vistedMap = new HashMap<>();
    Graph graph;

    public DfsImpl(Graph g) {
        this.graph=g;
        for(String key: g.getVertices()){
            vistedMap.put(key,false);
        }
    }

    public void dfs(String source){
        vistedMap.put(source,true);
        Node node = graph.getNode(source);
        System.out.print(graph.getNode(source).name + "->");
        for(String ngbr:node.getNgbrs()){
            if(!vistedMap.get(ngbr)){
                dfs(ngbr);
            }
        }
    }

}
