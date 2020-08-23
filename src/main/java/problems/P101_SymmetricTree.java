package problems;

import myUtils.TreeNode;

/**
 * Created by WangSai on 2020/8/23
 */
public class P101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right) ;
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left) && node1.val == node2.val;

    }
}
