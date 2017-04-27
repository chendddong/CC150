// 4.4
// Given a binary search tree, design an algorithm which creates a linked list
// of all the nodes at each depth (i.e., if you have a tree with depth D, you’ll
// have D linked lists).

 //    9	
 //  6	  8
 // 3 5 1  10 

// [
// [9],
// [6, 8]
// [3,5,1,10]
// ]

// inputs : TreeNode head
// outputs : double ArrayList

// test case: null case

// We can do a simple level by level traversal of the tree, with a slight
// modi
// cation of the breath-  rst traversal of the tree.
// In a usual breath  rst search traversal, we simply traverse the nodes
// without caring which level we are on. In this case, it is critical to  know
// the level. We thus use a dummy node to indicate when we have  nished one
// level   and are starting on the next.

public class Solution {
	public ArrayList<LinkedList<TreeNode>> traversalBSTByLevel(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>
		();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		int level = 0;
		list.add(root);
		result.add(level, list);

		while (true) {
			list = new LinkedList<TreeNode>();
			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode node = (TreeNode) result.get(level).get(i);
				if (node != null) {
					if (node.left != null) {
						list.add(node.left);
					}

					if (node.right != null) {
						q.add(node.right);
					}
				}


			}
			if (list.size() > 0) {
				result.add(level + 1, list);
			} else {
				break;
			}
			level++;
		}

		return result;
	}
}



