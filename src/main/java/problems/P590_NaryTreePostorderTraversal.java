package problems;

import myUtils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by WangSai on 2019-05-12 19:03now
 * 题目链接:https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */


public class P590_NaryTreePostorderTraversal {

    List<Integer> list = new ArrayList<Integer>();

    //recursive，递归调用
    public List<Integer> postorder1(Node root) {
        if (root == null) {
            return list;
        }

        List<Node> children = root.children;
        for (Node child : children) {
            postorder1(child);
        }
        list.add(root.val);

        return list;

    }

    //iterative，迭代
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();

        if (root == null) {
            return list;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);

            List<Node> children = node.children;
            for (Node child : children) {
                stack.push(child);
            }

        }
        return list;
    }
}
