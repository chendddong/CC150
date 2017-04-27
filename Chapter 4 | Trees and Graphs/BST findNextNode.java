// 4.5
// Write an algorithm to  find the ‘next’ node (i.e., in-order successor) of a
// given node in a binary search tree where each node has a link to its parent.

 //    9	
 //  6	  8
 // 3 5 1  10 

// Inputs TreeNode head, TreeNode target
// outputs return TreeNode next

// binary search kind thing to find the target and to see if it has children 

// We approach this problem by thinking very, very carefully about what happens
// on  an in- order traversal. On an in-order traversal, we visit X.left, then
// X, then X.right.
// So, if we want to  nd X.successor(), we do the following:

// 1. If X has a right child, then the successor must be on the right side of X 
// (because of the order in which we visit nodes). Specically, the left-most
// child   must be the first node visited in that subtree.

// 2. Else, we go to X’s parent (call it P).
// 2.a. If X was a left child (P.left = X), then P is the successor of X
// 2.b. If X was a right child (P.right = X), then we have fully visited P, so  
// we call successor(P).

// the logic is very important

public class Solution {
	public TreeNode inorderSucc(TreeNode e) {
		if (e != null) {
			TreeNode p;
			// Found right children -> return 1st inorder node on right
			if (e.parent == null || e.right != null) {
				p = leftMostChild(e.right);
			} else {
				// go up until we're on left instead of right (case 2b)
				while ((p = e.parent) != null) {
					if (p.left == e) {
						break;
					}
					e = p;
				}
			}
			return p;
		}
		return null;
	}

	public TreeNode leftMostChild(TreeNode e) {
		if (e == null) {
			return null;
		}

		while (e.left != null) {
			e = e.left;
		}

		return e;
	}
}

/*
requires a lot of thinking.
Great !
Think about the conditions and the basics of the Inorder 
traversal

*/

