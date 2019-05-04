package Problems;

import myUtils.TreeNode;

/**
 * 题目链接：https://leetcode.com/problems/merge-two-binary-trees/
 * <p>
 * 题目描述：
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3  2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */

public class P617_MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        int val = 0;
        if (t1 != null) {
            val += t1.val;
        }
        if (t2 != null) {
            val += t2.val;
        }
        TreeNode node = new TreeNode(val);

        if (t1 != null && t2 != null) {
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);

        } else if (t1 != null) {
            node.left = mergeTrees(t1.left, null);
            node.right = mergeTrees(t1.right, null);
        } else {
            node.left = mergeTrees(null, t2.left);
            node.right = mergeTrees(null, t2.right);
        }
        return node;

    }

    public TreeNode mergeTreesSolution2(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTreesSolution2(t1.left, t2.left);
        node.right = mergeTreesSolution2(t1.right, t2.right);
        return node;
    }


}
