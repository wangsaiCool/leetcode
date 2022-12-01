package problems;

import myUtils.TreeNode;

import java.util.Stack;

/**
 * Created by WangSai on 2021/8/5
 */
public class P0000_1_TreeTraversal {

    // 前序遍历 递归
    public void preOrderTraversalV1(TreeNode node) {
        if (null != node) {
            System.out.print(node.val + " ");
            preOrderTraversalV1(node.left);
            preOrderTraversalV1(node.right);
        }
    }

    // 前序遍历 非递归
    public void preOrderTraversalV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode index = node;
        while (null != index || !stack.isEmpty()) {
            while (null != index) {
                System.out.print(index.val + " ");
                stack.push(index);
                index = index.left;
            }

            if (stack.isEmpty()) {
                index = stack.pop();
                index = index.right;
            }
        }
    }


    // 中序遍历 递归
    public void midOrderTraversalV1(TreeNode node) {
        if (null != node) {
            midOrderTraversalV1(node.left);
            System.out.println(node.val + " ");
            midOrderTraversalV1(node.right);
        }
    }

    // 中序遍历 非递归
    public void midOrderTraversalV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode index = node;
        while (null != index || !stack.isEmpty()) {
            while (index != null) {
                stack.push(index);
                index = index.left;
            }

            if (!stack.isEmpty()) {
                index = stack.pop();
                System.out.print(index.val + " ");
                index = index.right;
            }
        }
    }

    // 后序遍历 递归
    public void postOrderTraversalV1(TreeNode node) {
        if (null != node) {
            postOrderTraversalV1(node.left);
            postOrderTraversalV1(node.right);
            System.out.println(node.val + " ");
        }
    }

    // 后序遍历 非递归
    public void postOrderTraversalV2(TreeNode node) {
        Stack<TreeNode> stack = new Stack();

        TreeNode index = node;
        TreeNode last = node;

        while (index != null || !stack.isEmpty()) {
            while (index != null) {
                stack.push(index);
                index = index.left;
            }

            TreeNode peek = stack.peek();
            if (!stack.isEmpty()) {
                


            }



        }


    }
}
