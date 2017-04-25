// 3.2 How would you design a stack which, in addition to push and pop, also has
// a function min which returns the minimum element? Push, pop and min should all
// operate in O(1) time.

// Using two stacks


// You can implement this by having each node in the stack keep track of the  
// minimum be- neath itself. Then, to  nd the min, you just look at what the
// top element thinks is the min. When you push an element onto the stack, the
// element is given the current minimum. It sets its “local min” to be the min.

class NodeWithMin {
	public int value;
	public int min;
	public NodeWithMin(int v, int min) {
		value = v;
		this.min = min;
	}
}

class Solution {
	// inheritance

	public class StackWithMin extends Stack<NodeWithMin> {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	
	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
	
}

/* 
Weird but works.
Keep track of the min by using another atrributes of the Node,
every time push something in we are gonna up date the min on the top of the
node, So we can easily call peek().min to see the min value.
*/


// There’s just one issue with this: if we have a large stack, we waste a lot of
// space by keeping track of the min for every single element. Can we do better?
// We can (maybe) do a bit better than this by using an additional stack which  
// keeps track of the mins.

class Solution {
	public class StackWithMin2 extends Stack<Integer> {
		Stack<Integer> s2;
		// this is the minStack
		public StackWithMin2() {
			s2 = new Stack<Integer>();
		}

		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			} else {
				super.push(value);
			}
		}

		public Integer pop() {
			int value = supper.pop();
			// this is tricky, if the poped value is the min,
			// there is no min in the MinStack too
			if (value == min()) {
				s2.pop();
			}
			return value;
		}

		public int min() {
			if (s2.isEmpty) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}
}

/*
Inheritance: StackWithMin2 extends Stack<Integer>

Constructor:
		public StackWithMin2() {
			s2 = new Stack<Integer>();
		}

push() -- if <= min s2.push -- else super.push
pop() -- this is tricky, if the poped value is the min, there is no min in the
MinStack too  

min()
		if (s2.isEmpty) {
			return Integer.MAX_VALUE;

 
Why might this be more space e cient? If many elements have the same local min, 
then we’re keeping a lot of duplicate data. By having the mins kept in a
separate   stack, we don’t have this duplicate data (although we do use up a lot
of extra space because we have a stack node instead of a single int).

*/

