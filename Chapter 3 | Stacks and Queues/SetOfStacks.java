// 3.3
// Imagine a (literal) stack of plates. If the stack gets too high, it might
// topple.   There- fore, in real life, we would likely start a new stack when  
// the previous stack exceeds some threshold. Implement a data structure
// SetOfStacks   that mimics this. SetOf- Stacks should be composed of several
// stacks,   and should create a new stack once the previous one exceeds capacity. 
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
// stack   (that is, pop() should return the same values as it would if there were 
// just a single stack).

// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a
// specic sub-stack.

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
			Stack lastStack = stacks.get(stacks.size() - 1);
			return lastStack;			
		}
	}
}

/*
to get the last element in the arrayList:
	
      E e = list.get(list.size() - 1);
      
*/