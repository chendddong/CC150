// 1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4
// bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

// // I have no clue of what's going to happen with this problem and I was trying to 
// draw something in order to figure out how to manipulate the index of the array. There
// must be a way and I just can't and dont have the time to figure that out 


// solution #1
// The rotation can be performed in layers, where you perform a cyclic swap on the edges on
// each layer. In the first for loop, we rotate the first layer (outermost edges). We rotate the
// edges by doing a four-way swap first on the corners, then on the element clockwise from the
// edges, then on the element three steps away.
// Once the exterior elements are rotated, we then rotate the interior region’s edges.

// from the exterior the the interior

class Solution {
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
}


// solution #2 actully, this solution is almost identical to the previous one but much easier to remember!
public class Solution {
	public void roate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int length = matrix.length;

		// save top
		// left -> top
		// bottom -> left
		// right -> bottom
		// top -> right
		// right <- saved top


		// remeber the limitations for i just length / 2 for j is length + 1 / 2
		for (int i = 0; i < length / 2; i++) {
			for (int j = 0; j < (length + 1) / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[length - j - 1][i];
				matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
				matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
				matrix[j][length - i - 1] = tmp;
			}
		}
	}
}
/* yes, this is the core!
		// save top
		// left -> top
		// bottom -> left
		// right -> bottom
		// top -> right
		// right <- saved top


Let's visualize that whole process a little bit

[

[1,  2,  3,  4]
[5,  6,  7,  8]
[9, 10, 11, 12]
[13,14, 15, 16]

]

i < 2 j < 2

i = 0, j = 0;
1 -> 1, 13, 16, 4 

i = 0, j = 1;
2 -> 2, 9, 15, 8 

i = 1, j = 0;
3 -> 5, 14, 12, 3  

i = 1, j = 1;
4 -> 6, 10, 11, 7 

*/