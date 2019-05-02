package problems;

import TreeNode.TreeNode;

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
