// 4.1
// Implement a function to check if a tree is balanced. For the purposes of
// this question, a balanced tree is defined to be a tree such that no two leaf 
// nodes differ in distance from the root by more than one.

class Solution {
	public boolean isBalanced(TreeNode root) {
		int maxDepth = findMaxDepth(root);
		int minDepth = findMinDepth(root);
		return maxDepth - minDepth <= 1;
	}

	private int findMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMaxDepth = findMaxDepth(root.left);
		int rightMaxDepth = findMaxDepth(root.right);

		return Math.max(leftMaxDepth, rightMaxDepth) + 1;
	}

	private int findMinDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMinDepth = findMinDepth(root.left);
		int rightMinDepth = findMinDepth(root.right);

		return Math.min(leftMinDepth, rightMinDepth) + 1;

	}
}

/* 
This is just buggy and no idea why is this the case.
*/

// answer by jiuzhang AC
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     * without result type
     */
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
}
