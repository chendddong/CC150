// Given a circular linked list, implement an algorithm which 
// returns node at the beginning of the loop.

// DEFINITION
// Circular linked list: A (corrupt) linked list in which a 
// node’s next pointer points to an earlier node, so as to make a 
// loop in the linked list.
// EXAMPLE
// input: A -> B -> C -> D -> E -> C [the same C as earlier]
// output: C


// Solution #0
// since I have done this question before, so I would like to brush up the memory 
// a little bit. Got the feel that we have to find if it is a circle, if it has 
// we gonna need a slow pointer and a fast pointer and a find pointer to find the 
// beginning of the loop
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
    	// corner case
    	if (head == null || head.next == null) {
    		return null;
    	}

    	ListNode slow = head;
    	ListNode fast = head.next;
    	ListNode find = head;

    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (fast == slow) {
    			break;
    		}
    	}
    	
    	if (fast == null || fast.next == null) {
    	    return null;
    	}

    	while (slow.next != find) {
    		find = find.next;
    		slow = slow.next;
    	}

    	return find;


    }
}

/*
Used the compiler to help me check the no cycle return;
*/

// Solution #1 
// there is a slight difference between mine answer and the answer from jiuzhang
// Actually it depends on how you see those if's
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast;
        ListNode slow;
        fast = head.next;
        slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow.next != head) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}

// Solution #2
// If we move two pointers, one with speed 1 and another with speed 2, they will end up meeting
// if the linked list has a loop. Why? Think about two cars driving on a track—the faster car
// will always pass the slower one!
// The tricky part here is finding the start of the loop. Imagine, as an analogy, two people racing
// around a track, one running twice as fast as the other. If they start off at the same place,
// when will they next meet? They will next meet at the start of the next lap.
// Now, let’s suppose Fast Runner had a head start of k meters on an n step lap. When will
// they next meet? They will meet k meters before the start of the next lap. (Why? Fast Runner
// would have made k + 2(n - k) steps, including its head start, and Slow Runner would have
// made n - k steps. Both will be k steps before the start of the loop.)
// Now, going back to the problem, when Fast Runner (n2) and Slow Runner (n1) are moving
// around our circular linked list, n2 will have a head start on the loop when n1 enters. Specifically,
// it will have a head start of k, where k is the number of nodes before the loop. Since n2
// has a head start of k nodes, n1 and n2 will meet k nodes before the start of the loop.
// So, we now know the following:
// 1. Head is k nodes from LoopStart (by definition).
// 2. MeetingPoint for n1 and n2 is k nodes from LoopStart (as shown above).
// Thus, if we move n1 back to Head and keep n2 at MeetingPoint, and move them both at the
// same pace, they will meet at LoopStart.

// public class Solution {
//     /**
//      * @param head: The first node of linked list.
//      * @return: The node where the cycle begins. 
//      *           if there is no cycle, return null
//      */
//     public ListNode detectCycle(ListNode head) {  
//     	ListNode n1 = head;
//     	ListNode n2 = head;

//     	// find the meeting point
//     	while (n2.next != null) {
//     		n1 = n1.next;
//     		n2 = n2.next.next;
//     		if (n1 == n2) {
//     			break;
//     		}
//     	}

//     	// Error check - there is no meeting point and therefore no loop
//     	if (n2.next == null) {
//     		return null;
//     	}

// 		/* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps
//  		/* from the Loop Start. If they move at the same pace, they must
//  			meet at Loop Start. 
//  		*/

//  		n1 = head;
//  		while (n1 != n2) {
//  			n1 = n1.next;
//  			n2 = n2.next;
//  		}
//  		// Now n2 points to the start of the loop
//  		return n2;
//     }
// }

// /* 
// After checking by the compiler this code is not correct...So just comment it
// */