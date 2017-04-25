// 2.2 Implement an algorithm to find the nth to last element of a singly linked list

// When I first got the problem , I tend to construct the problem with two parameters say
// the head of the singly linked list and the int n, and we are gonna return the dummy node if
// it is not a void method. However, it will reassign the head if it is a void method


// a wrong solution
// public class Solution {

// 	class ListNode {
// 		int val;
// 		Node next;
// 		public ListNode(int d) {
// 			val = d;
// 		}
// 	}

// 	public ListNode fromNToEnd(ListNode head, int n) {
// 		if (n <= 1 || head == null) {
// 			return head;
// 		}

// 		ListNode dummy = new ListNode(0);
// 		dummy = head;
// 		// we need a index to store the total number of the nodes
// 		int index = 1;

// 		while (head != null) {
// 			index++;
// 			if (index == n) {
// 				break;
// 			}
// 			head = head.next;
// 		}

// 		if (index == n) {
// 			return head.next;
// 		}

// 		return dummy;

// 	}

// }



/* 
The key here is to find the nth node and return the previous node of the nth node  .next
*/


// Solution #1 by the author

// Note: This problem screams recursion, but we’ll do it a different way because it’s
// trickier. In a question like this, expect follow up questions about the advantages
// of recursion vs iteration.
// Assumption: The minimum number of nodes in list is n.

// Algorithm:
// 1. Create two pointers, p1 and p2, that point to the beginning of the node.
// 2. Increment p2 by n-1 positions, to make it point to the nth node from the beginning (to
// make the distance of n between p1 and p2).
// 3. Check for p2->next == null if yes return value of p1, otherwise increment p1 and p2.
// If next of p2 is null it means p1 points to the nth node from the last as the distance
// between the two is n.
// 4. Repeat Step 3.

public class Solution {

	class ListNode {
		int val;
		Node next;
		public ListNode(int d) {
			val = d;
		}
	}

	public ListNode fromNToEnd(ListNode head, int n) {

		if (head == null || n < 1) {
			return null;
		}
		// this means pointer, not the assignment
		ListNode p1 = head;
		ListNode p2 = head;

		for (int j = 0; j < n - 1; ++j) { //skip n - 1 steps and ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

}

/* 
this method is much more clear and cost-efficient, should be careful and 
mind the approach

ListNode p1 = head;
this means pointer, not the assignment
		
*/

// the practice version

public class Solution {

	class ListNode {
		int val;
		Node next;
		public ListNode(int d) {
			val = d;
		}
	}

	public ListNode fromNToEnd(ListNode head, int n) {

		if (head == null || n < 1) {
			return null;
		}		

		ListNode p1 = head;
		ListNode p2 = head;

		for (int i = 0; i < n - 1; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

}

/* 
Think about where to put those two pointers in order to return a node that nth to the last;
*/