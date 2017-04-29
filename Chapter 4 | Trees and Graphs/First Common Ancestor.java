// 4.6
// Design an algorithm and write code to  nd the  rst common ancestor of two
// nodes in a binary tree. Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.

// If this were a binary search tree, we could do a modi ed  nd on the two nodes
// and see where the paths diverge. Unfortunately, this is not a binary search
// tree, so we much try other ap- proaches.

// Attempt #1:
// If each node has a link to its parent, we could trace p and q’s paths up
// until they   intersect.

// Attempt #2: 
// Alternatively, you could follow a chain in which p and q are on the same
// side. That is, if p and q are both on the left of the node,   branch left to
// look   for the common ancestor. When p and q are no longer on the same side, 
// you must have found the  rst common ancestor.

public class Solution {
	public Tree commonAncestor(Tree root, Tree p, Tree q) {
		// p and q are on the same side of the left side of the tree
		if (covers(root.left, p) && covers(root.left, q)) {
			return commonAncestor(root.left, p, q);
		}
		// p and q are on the same side of the right side of the tree

		if (covers(root.right, p) && covers(root.right, q)) {
			return commonAncestor(root.right, p, q);
		}

		return root;
	}

	private boolean covers(Tree root, Tree p) { // is p a child of root
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}

		return covers(root.left, p) || cover(root.right, p);
	}	
}

// What is the running time of this algorithm? One way of looking at this is to 
// see how many times each node is touched. Covers touches every child node, so 
// we know that every single node in the tree must be touched at least once, and
// many nodes are touched multiple times.

// Attempt #3:
// For any node r, we know the following:
// *************************************************************************
// 1. If p is on one side and q is on the other, r is the  rst common ancestor.
// 2. Else, the first common ancestor is on the left or the right side.
// *************************************************************************
// So, we can create a simple recursive algorithm called search that calls
// search  (left side) and search(right side) looking at how many nodes (p or q)
// are   placed from the left side and from the right side of the current node.
// If   there are two nodes on one of the sides, then we have to check if the
// child   node on this side is p or q (because in this case the current node is
// the common ancestor). If the child node is neither p nor q, we should
// continue   to search further (starting from the child). If one of the
// searched nodes (p or q) is located on the right side of the current node,
// then   the other node is located on the other side. Thus the current node is 
// the common ancestor.

public class Solution {
	int TWO_NODES_FOUND = 2;
	int ONE_NODE_FOUND = 1;
	int NO_NODES_FOUND = 0;

	// check how many "special nodes are loacated under this root"
	int covers(TreeNode root, TreeNode p, TreeNode q) {
		int ret = NO_NODES_FOUND;
		if (root == null) {
			return ret;
		}
		if (root == p || root == q) {
			ret += 1;
		}
	}


	public Tree commonAncestor(Tree root, Tree p, Tree q) {
		
	}	
}

