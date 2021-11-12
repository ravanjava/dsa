package ram.dsa.graph;

import java.util.*;

public class Graph {

    Map<String, Node> map = new HashMap<>();

    public Graph(List<String> nodes) {
        for (String node : nodes) {
            map.put(node, new Node(node));
        }
    }

    public Set<String> getVertices() {
        return map.keySet();
    }

    public Node getNode(String key) {
        return map.get(key);
    }

    public void addNgbr(String source, String ngbr, boolean directed) {
        map.get(source).addNgbr(ngbr);
        if (!directed) {
            map.get(ngbr).addNgbr(source);
        }
    }

    public void addNgbrs(String source, List<String> ngbrs) {
        map.get(source).addNgbrS(ngbrs);
    }

    public void printGraph() {
        for (String key : map.keySet()) {
            System.out.print(key + " -->");
            for (String val : map.get(key).ngbrs) {
                System.out.print(val + ",");
            }
            System.out.println();
        }
    }

}

class Node {
    String name;
    List<String> ngbrs;

    public Node(String name) {
        this.name = name;
        this.ngbrs = new ArrayList<>();
    }

    public List<String> getNgbrs() {
        return ngbrs;
    }

    public String getName() {
        return name;
    }

    public void addNgbr(String name) {
        this.ngbrs.add(name);
    }


    public void addNgbrS(List<String> names) {
        this.ngbrs.addAll(names);
    }

}

