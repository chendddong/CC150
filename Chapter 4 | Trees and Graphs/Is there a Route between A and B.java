// 4.2 
// Given a directed graph, design an algorithm to find out whether there is a
// route between two nodes.

// Example
// A -> B -> C -> D
//           |
//           v
//      A <- E    F
// Wants to find out if A and F have a route?

// Inputs graph
// Outputs boolean

// Use DFS?

// This problem can be solved by just simple graph traversal, such as depth  rst
// search or breadth    rst search. We start with one of the two nodes and,
// during traversal,   check if the other node is found. We should mark any node
// found in the   course of the algorithm as ‘al- ready visited’ to avoid cycles
// and repetition of the nodes.

class Solution {
	public enum State {
		Unvisited, Visited, Visiting;
	}

	public boolean search(Graph g, Node start, Node end) {
		Queue<Node> q = new Queue<Node>(); // opertates as stack
		// mark as unvisited
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}

		start.state = State.Visiting;
		q.push(start);
		Node u;

		while (!q.isEmpty()) {
			u = q.poll();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.push(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}

		return false;
	}
}