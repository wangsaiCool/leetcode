package problems;

import myUtils.TreeNode;

/**
 * Created by WangSai on 6/6/19
 *
 * 题目链接:https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * 题目描述：
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class P104_MaximumDepthofBinaryTree {

    //solution1:后序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

}
