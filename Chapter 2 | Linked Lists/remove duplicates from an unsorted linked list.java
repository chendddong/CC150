/*
Creating a LinkedList
*/

class Node {
	Node next = null;
	int val;
	public Node(int d) {
		val = d;
	}
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	/* 
Deleting a Node from a Singly Linked List
*/

	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.val == d) {
			return head.next; // moved head
		}
		while (n.next != null) {
			if (n.next.val == d) {
				n.next = n.next.next;
				return head; // head didn't change
			}
			n = n.next;
		}
	}

}





// 2.1 Write code to remove duplicates from an unsorted linked list.
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?


// Solution #0 

// I would like to consider to use hashSet, since it's unsorted and 
// remove duplicates

class Solution {
	public void removeDuplicates(Node head) {

		if (head == null || head.next == null) {
			return;
		}

		ArrayList<Node> list = new ArrayList<Node>();

		while (head != null) {
			if (list.contains(head)) {
				continue;
			}
			list.add(head);
			head = head.next;
		}
		// reasign the head 

		for (int i = 1; i < set.size(); i++) {
			list.get(i - 1).next = list.get(i);
		}
	}
}

/* 
At first glace I would like to use hashSet and it turns out HashSet cannot get item by index,
So I would then alternate to ArrayList where you can order item by index.

Since there is no return value, there is no point using a dummy node and reasign the head would 
be fine
*/


// Solution #1 by the author 
// If we can use a buffer, we can keep track of elements in a hashtable and remove any dups:
class Solution {
	// there must be some alternation of the LinkedListNode
	public void deleteDups(LinkedListNode n) {
		// since there is a key value pair in this case the val and the existance of the node.val
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
}

/*
Use hashtable to store the value of a node and the exsitance of the node
Hashtable table = new Hashtable();
How to handle the ListNode with a prev;
*/

// Solution #2 by the author  ---- two pointers
// Without a buffer, we can iterate with two pointers: “current” does a normal iteration, while
// “runner” iterates through all prior nodes to check for dups. Runner will only see one dup
// per node, because if there were multiple duplicates they would have been removed already.

class Solution {
	public void deleteDups(LinkedListNode head) {
		if (head == null) {
			return;
		}

		LinkedListNode previous = head;
		LinkedListNode current = previous.next;

		while (current != null) {
			LinkedListNode runner = head;
			while (runner != current) { // check for earlier dups
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all ohter dups have already been moved
				}
				runner = runner.next;
			}

			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}
	
}



// the practice version

class Solution {
	public void deleteDups(LinkedListNode head) {
		if (head == null) {
			return;
		}

		// initialize 


		LinkedListNode pre = head;
		LinkedListNode current = pre.next;

		while (current != null) {
			LinkedListNode runner = head;
			while (runner != current) {
				if (runner.val == current.val) {
					LinkedListNode tmp = current.next;
					pre.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}

			if (runner == current) {
				current = current.next;
				pre = pre.next;
			}
		}
	}
	
}

/* 
Just always draw something for the LinkedList questions before to write the actual code.
It would be much clearer
*/
