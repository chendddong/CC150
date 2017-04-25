// 2.3 Implement an algorithm to delete a node in the middle of a single linked list, given
// only access to that node.

// EXAMPLE
// Input: the node ‘c’ from the linked list a->b->c->d->e
// Result: nothing is returned, but the new linked list looks like a->b->d->e

// Solution #0
// when I got this problem, I was trying to think about the general process which is to find the
// node before the will-be deleted node; then we are gonna link the node before the will-be deleted node
// and the node after the will-be deleted node. And after a while I found that there is no way that I can get
// a preNode of the will-be deleted node;

public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     * we cannot know the previous node of the node so we just swap the value and keep on
     */
    public void deleteNode(ListNode node) {
  		if (node == null || node.next == null) {
  			return;
  		}
  		ListNode temp = node.next;
  		node.val = temp.val;
  		node.next = temp.next;
    }

}

/* 
Since there is no way that we can find the node before the given node.
So think out side of the box which is to swap the value of the node and the next node
and point the next to the right position.
*/

// Solution #1 by the author The solution to this is to simply copy the data from the next node into this node and then
// delete the next node.


/*
NOTE: This problem can not be solved if the node to be deleted is the last node
in the linked list. That’s ok—your interviewer wants to see you point that out. You
could consider marking it as dummy in that case. This is an issue you should discuss
with your interviewer.
*/

public class Solution {
	public static boolean deleteNode(ListNode n) {
		// the last node excluded
		if (n == null || n.next == null) {
			return false; // Failure
		}

		ListNode next = n.next;
		n.val = next.val;
		n.next = next.next;
		return true;
	}
}
