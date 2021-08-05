package problems;

import myUtils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 问题链接：https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * <p>
 * <p>
 * 问题描述：
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * 1
 * /    \
 * 2     3
 * /   \
 * 4   5
 * <p>
 * We should return its max depth, which is 3.
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */


public class P559_MaximumDepthofNaryTree {


    //深度优先
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }

        int maxNum = 0;
        for (Node child : root.children) {
            int temp = maxDepth1(child);
            if (temp > maxNum) {
                maxNum = temp;
            }
        }
        return maxNum += 1;


    }

    //宽度优先
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> myQueue = new LinkedList<Node>();
        myQueue.add(root);

        int depth = 0;

        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            for (int i = 0; i < size; i++) {
                Node node = myQueue.remove();
                myQueue.addAll(node.children);
            }
            depth++;
        }
        return depth;

    }


}
