package Problems;

import myUtils.Node;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by WangSai on 2019-05-12 21:24
 * 题目链接：https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 * <p>
 * 题目描述：N叉树前序遍历
 */


public class P589_NaryTreePreorderTraversal {

    //递归调用
    private List<Integer> list = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Node> chiledren = root.children;
        for (Node child : chiledren) {
            preorder(child);
        }
        return list;
    }


    //迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            List<Node> children = node.children;
            for (int index = children.size() - 1; index >=0; index--) {
                stack.push(children.get(index));
            }
        }

        return list;
    }
}
