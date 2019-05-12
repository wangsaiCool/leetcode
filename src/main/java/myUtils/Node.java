package myUtils;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> children) {
        val = _val;
        this.children = children;
    }
}
