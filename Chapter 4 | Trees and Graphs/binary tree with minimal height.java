// 4.3
// Given a sorted (increasing order) array, write an algorithm to create a
// binary tree with minimal height.

// We will try to create a binary tree such that for each node, the number of
// nodes in the left subtree and the right subtree are equal, if possible.
// Algorithm:
//  1. 2. 3. 4.
// Insert into the tree the middle element of the array. 
// Insert (into the left subtree) the left subarray elements 
// Insert (into the right subtree) the right subarray elements 
// Recurse

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        if (A == null) {
            return null;
        }
        
        return getBST(A, 0, A.length - 1);
    }  
    
    private TreeNode getBST(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        // create a head for the tree;
        // just new it
        TreeNode root = new TreeNode(A[mid]);
        // connect them all together
        root.left = getBST(A, start, mid - 1);
        root.right = getBST(A, mid + 1, end);
        return root;
        
    }
}

