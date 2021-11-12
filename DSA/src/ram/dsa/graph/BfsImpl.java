package ram.dsa.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BfsImpl {
    Map<String,String> parentMap = new HashMap<>();
    Map<String,Integer> distance = new HashMap<>();
    Map<String, Boolean> vistedMap = new HashMap<>();
    Graph graph;

    public BfsImpl(Graph g) {
        this.graph=g;
        for(String key: g.getVertices()){
            vistedMap.put(key,false);
        }
    }

    public  void bfs( String startNode){
        Queue<Node> queue = new LinkedList<>();
        Node source = graph.getNode(startNode);
        queue.offer(source);

        vistedMap.put(startNode,true);
        parentMap.put(startNode,startNode);
        distance.put(startNode,0);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.name + "->");
            for(String ngbr: node.ngbrs){
                if(!vistedMap.get(ngbr)){
                    queue.offer(graph.getNode(ngbr));
                    vistedMap.put(ngbr,true);
                    // for Shortest Distance
                    parentMap.put(ngbr,node.name);
                    distance.put(ngbr,distance.get(node.name)+1);
                }
            }
        }



        for(String dist:distance.keySet()){
            System.out.println("Shortest dist from "+startNode+" to  "+ dist +" is " + distance.get(dist));
        }

    }
}
