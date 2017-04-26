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
