// 2.4 You have two numbers represented by a linked list, where each node contains a single digit. 
// The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
// Write a function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
// Output: 8 -> 0 -> 8

//Given 7->1->6 + 5->9->2. That is, 617 + 295.

// Return 2->1->9. That is 912.

// Given 3->1->5 and 5->9->2, return 8->0->8.


// Solution #0 when I first got this kind of question, I would like to go for a drawing and see
// how that would go
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	}
    	if (l2 == null) {
    		return l1;
    	}

    	ArrayList<ListNode> list = new ArrayList<ListNode>();

    	int len1 = getSize(l1);
    	int len2 = getSize(l2);
    	int increment = 0;
    	int n = Math.min(len1, len2);
    	for (int i = 0; i < n; i++) {
    		int sum = 0;
    		if (l1.val + l2.val + increment >= 10) {
    			sum = (l1.val + l2.val + increment) % 10;
    			increment = 1;
    		} else {
    			sum = (l1.val + l2.val + increment);
    			increment = 0;
    		}


    		ListNode newHead = new ListNode(sum);
    		list.add(newHead);


    		l1 = l1.next;
    		l2 = l2.next;
    	}

    	if (l1 == null && l2 == null && increment == 0) {
    		return showNewList(list);
    	}

    	if (l1 == null && l2 == null && increment == 1) {
    		list.add(new ListNode(1));
    		return showNewList(list);
    	}

    	if (l1 == null && l2 != null && increment == 0) {
    		addRest(l2, list, increment);
    		return showNewList(list);

    	}

    	if (l1 == null && l2 != null && increment == 1) {
    		addRest(l2, list, increment);
    		return showNewList(list);

    	}


    	if (l2 == null && l1 != null) {
    		addRest(l2, list, increment);
    		return showNewList(list);
    	}

    	if (l2 == null && l1 != null) {
    		addRest(l2, list, increment);
    		return showNewList(list);
    	}

    	return showNewList(list);


    }
    private void addRest(ListNode head, ArrayList<ListNode> list, int increment) {
    	if (increment == 0) {
    		head = head;
    	} else {
    		head = new ListNode(head.val + 1);
    	}
    	while (head != null) {
    		list.add(head);
    		head = head.next;
    	}
    }

    private ListNode showNewList(ArrayList<ListNode> list) {
    	
    	ListNode head = list.get(0);
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	for (ListNode node : list) {
    		head.next = node;
    		head = node;
    	}
    	return dummy.next;

    }

    private int getSize(ListNode head) {
    	int size = 0;
    	while (head != null) {
    		size++;
    		head = head.next;
    	}
    	return size;
    }
}


/* 
Guess I was just follow the flow of the thought but the lintCode give me Memory Limit Exceeded
Your code cost too much memory than we expected. Check your space complexity. 
Memory limit exceeded usually caused by you create a 2D-array which is unnecessary.
*/


// Solution #1 by jiuzhang


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode hed = new ListNode(0);
        ListNode point = head;
        int carry = 0;


        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            point = point.next;
        }

         while (l2 != null) {
            int sum = carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            point = point.next;
        }

        if (carry != 0) {
            point.next = new ListNode(carry);
        }

        return head.next;

    }
}

/* 
WOW, just completely crushed by the simple node.
This manipulation is in-place and the O(n)
And the code is almost identical 
A must repeat!
*/


// Solution #1

