// 3.3
// Imagine a (literal) stack of plates. If the stack gets too high, it might
// topple.   There- fore, in real life, we would likely start a new stack when  
// the previous stack exceeds some threshold. Implement a data structure
// SetOfStacks   that mimics this. SetOf- Stacks should be composed of several
// stacks,   and should create a new stack once the previous one exceeds capacity. 
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
// stack   (that is, pop() should return the same values as it would if there were 
// just a single stack).



// In this problem, we’ve been told what our data structure should look like:

// We know that push() should behave identically to a single stack, which  
// means that we need push() to call push on the last stack. We have to be a
// bit careful here though: if the last stack is at capacity, we need to  
// create a new stack. Our code should look something like this:

// What should pop() do? It should behave similarly to push(), in that it
// should operate on the last stack. If the last stack is empty (after popping),
// then we should remove it from the list of stacks.

class Solution {
	// for example
	private int final CAPACITY = 10;
	ArrayList<Stack> stacks;
	class SetOfStacks {
		stacks = new ArrayList<Stack>();
		public void push(int v) {
			// this method means to get the last element in the arrayList
			Stack last = getLastStack();
			if (last != null && !last.isAtCapacity()) { //add that thing to the last
				// stack
				last.push(v);
			} else { // must create a new stack
				Stack stack =  new Stack(CAPACITY);
				stack.push(v);
				stacks.add(stack);
			}
		}

		public int pop() {
			Stack last = getLastStack();
			int v = last.pop();
			if (last.size() == 0) {
				stacks.remove(stacks.size() - 1);
			}
			return v;
		}

		public Stack getLastStack() {
			// to get the last element in the arrayList
			// Stack lastStack = stacks.get(stacks.size() - 1);
			// return lastStack;		

			// See the method down below	
		}
	}
}

/*
to get the last element in the arrayList:
	
      E e = list.get(list.size() - 1);

*/

// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a
// specic sub-stack.


// This is a bit trickier to implement, but essentially we should imagine a  
// “rollover” system. If we pop an element from stack 1, we need to remove
//   the bottom of stack 2 and push it onto stack 1. We then need to
// rollover from stack 3 to stack 2, stack 4 to stack 3, etc.

// NOTE: You could make an argument that, rather than “rolling over,” we should 
// be OK with some stacks not being at full capacity. This would improve  
// the time complexity (by a fair amount, with a large number of
// elements),   but it might get us into tricky situations later on if
// someone   assumes that all stacks (other than the last) operate at full
// capacity.   There’s no “right answer” here; discuss this trade-o  with
// your   interviewer!

class Solution {
	public class SetOfStacks {
		ArrayList<Stack> stacks = new ArrayList<Stack>();
		public int capacity;
		// constructor
		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}

		public Stack getLastStack() {
			if (stacks.size() == 0) {
				return null;
			}
			// last stack
			return stacks.get(stacks.size() - 1);
		}

		public void push(int v) {
			Stack lastStack = getLastStack();
			if (lastStack != null && !lastStack.isAtCapacity()) {
				lastStack.push(v);
			} else { // create a new stack
				Stack stack = new Stack(capacity);
				stack.push(v);
				stacks.add(stack);
			}
		}

		public int pop() {
			Stack lastStack = getLastStack();
			// System.out.println(stacks.size());
			int v = lastStack.pop();
			// must do this step to make it work
			if (lastStack.size() == 0) {
				stacks.remove(stacks.size() - 1);
			}
			return v;
		}

		public int popAt(int index) {
			return leftShift(index, true);
		}

		public int leftShift(int index, boolean removeTop) {
			// get the current stack
			Stack stack = stacks.get(index);
			int removed_item;
			if (removeTop) {
				removed_item = stack.pop();
			} else {
				removed_item = stack.removeBottom();
			}
			// only one stack just remove the index one
			if (stack.isEmpty()) {
				stacks.remove(index);
			} else if (stacks.size() > index + 1) {
				int v = leftShift(index + 1, false);
				stack.push(v);
			}
			return removed_item;
		}
	}
	public class Stack {
		private int capacity;
		public Node top, bottom;
		public int size = 0;

		public Stack(int capacity) {
			this.capacity = capacity;
		}

		public boolean isAtCapaity() {
			return capacity == size;
		}

		public void join(Node above, Node below) {
			if (below != null) {
				below.above = above;
				if (above != null) {
					above.below = below;
				}
			}
		}

		public boolean push(int v) {
			if (size >= capacity) {
				return false;
			}
			size++;
			Node n = new Node(v);
			if (size == 1) {
				bottom = n;
			}
			join(n, top);
			top = n;
			return true;

		}

		public int pop() {
			Node t = top;
			top = top.below;
			size--;
			return t.value;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int removeBotton() {
			Node b = bottom;
			bottom = bottom.above;
			if (bottom != null) {
				bottom.below = null;
			}

			size--;
			return b.value;
		}
	}
}

/* 
This whole thought is great , have to revisit this 
and draw something out of this.
*/
    
