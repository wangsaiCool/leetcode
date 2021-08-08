package nowcoder;

import myUtils.TreeNode;

/**
 * Created by WangSai on 2021/8/7
 */
public class nc12_重建二叉树 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (null == pre || null == vin || pre.length != vin.length || pre.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);

    }

    public TreeNode reConstructBinaryTree(int[] pre, int pl, int pr, int[] vin, int vl, int vr) {
        if (pl > pr) {
            return null;
        }

        TreeNode treeNode = new TreeNode(pre[pl]);
        int index = vl;
        while (index <= vr && pre[pl] != vin[index]) {
            index++;
        }

        if (index > vr) {
            // bad pre and vin
        }

        treeNode.left = reConstructBinaryTree(pre, pl + 1, index - vl + pl, vin, vl, index - 1);
        treeNode.right = reConstructBinaryTree(pre, index - vl + pl + 1, pr, vin, index + 1, vr);
        return treeNode;

    }

}



