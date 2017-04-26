## How to Approach
***
Trees and graphs questions typically come in one of two forms:

1. Implement a tree /  nd a node / delete a node / other well known algorithm.
2. Implement a modi cation of a known algorithm.

Either way, it is strongly recommended to understand the important tree algorithms prior to your interview. If you’re  uent in these, it’ll make the tougher questions that much easier! We’ll list some of the most important.

## Warning: Not all binary trees are binary search trees
***
When given a binary tree question, many candidates assume that the interviewer means “binary search tree”, when the interviewer might only mean “binary tree.” So, listen carefully for that word “search.” If you don’t hear it, the interviewer may just mean a binary tree with no particular ordering on the nodes. If you aren’t sure, ask.

## Binary Tree -- "Must Know" Algorithms
***
You should be able to easily implement the following algorithms prior to your interview:
» InOrder: Traverse left node, current node, then right [usually used for binary
search trees] 
» PreOrder: Traverse current node, then left node, then right node.
» PostOrder: Traverse left node, then right node, then current node.
» InsertNode: On a binary search tree, we insert a value v, by comparing it to
the root. If v > root, we go right, and else we go left. We do this until we hit an empty spot in the tree.

      balancing and deletion of binary search trees are rarely asked, but you might want to have some idea how they work. It can set you apart from other candidates.

## Graph Traversal "Must Know" Algorithms
***
* DFS : involves searching a node and all its children before proceed- ing to its siblings.

* BFS : involves searching a node and its siblings before going on to any children.