//Time Complexity: O(n) where n is the number of nodes in the binary tree
//Space Complexity: O(n) for the result list, as we are storing each level of the tree in a list of lists

//LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal/

/**
 * Performs a level order traversal of a binary tree, returning the values at each level.
 * Uses a queue to process nodes level by level, adding children to the queue as they are encountered.
 * Returns a list of lists where each sublist represents a level in the binary tree.
 */

import java.util.*;
import java.util.LinkedList;

public class LevelOrderTraversal {
// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       

        while(!q.isEmpty()) {
            int size = q.size(); 
            List<Integer> currentLevel = new ArrayList<>(); 
            while(currentLevel.size() < size) {
                TreeNode curNode = q.poll();
                if(curNode.left != null) {
                    q.add(curNode.left);
                }
                if(curNode.right != null) {
                    q.add(curNode.right);
                }
                currentLevel.add(curNode.val);
            }
            result.add(currentLevel);
        }
        return result;
    }
    
}
