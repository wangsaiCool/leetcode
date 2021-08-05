package problems;

import myUtils.TreeNode;

/**
 * 题目链接：https://leetcode.com/problems/range-sum-of-bst/
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 * Accepted
 * 40,087
 * Submissions
 * 49,928
 */

public class P938_RangeSumofBST {
    public int rangeSumBST_1(TreeNode root, int L, int R) {
        int[] ret = new int[1];
        traverse(root, L, R, ret);
        return ret[0];

    }

    public void traverse(TreeNode root, int L, int R, int[] record) {
        if (root == null) {
            return;
        }
        if (L <= root.val && root.val <= R) {
            record[0] += root.val;
        }
        traverse(root.left, L, R, record);
        traverse(root.right, L, R, record);

    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);

    }

}
