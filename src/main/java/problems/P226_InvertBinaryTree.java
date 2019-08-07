package Problems;

import myUtils.TreeNode;
import java.util.Stack;

/**
 * Created by WangSai on 2019-08-06 00:01
 *
 * 题目链接：https://leetcode.com/problems/invert-binary-tree/
 *
 * 题目描述：
 * 二叉树反转
 */

public class P226_InvertBinaryTree {

    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    //迭代
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;

        }

        return root;

    }
}
