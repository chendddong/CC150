// 3.6
// Write a program to sort a stack in ascending order. You should not make any
// assump- tions about how the stack is implemented.   The following are the
// only functions that should be used to write this program: pulicsh | pop |
// peek | isEmpty.

class Solution {
	public Stack<Integer> sortStack(Stack<Integer> stack) {
		// create a new stack to sort and return it
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		return r;	

	}
}

// before
// 1
// 2
// 3
// after
// 3
// 2
// 1
