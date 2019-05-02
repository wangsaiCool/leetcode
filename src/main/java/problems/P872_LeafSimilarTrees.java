package Problems;

import myUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 3/16/19.
 * Definition for a binary tree node.
 * public class myUtils.TreeNode {
 * int val;
 * myUtils.TreeNode left;
 * myUtils.TreeNode right;
 * myUtils.TreeNode(int x) { val = x; }
 * }
 */

public class P872_LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = reverseTree(root1);
        List<Integer> result2 = reverseTree(root2);
        if (result1.size() == 0 || result2.size() == 0 || result1.size() != result2.size()) {
            return false;
        }
        for (int index = 0; index < result1.size(); index++) {
            if (result1.get(index) != result2.get(index)) {
                return false;
            }
        }
        return true;

    }


    private List<Integer> reverseTree(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        reverseTree(root, result);
        return result;
    }

    private void reverseTree(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        reverseTree(root.left, leaves);
        reverseTree(root.right, leaves);

    }
}
