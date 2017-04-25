// 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
// column is set to 0.

// LintCode Set Matrix Zeroes Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// Given a matrix
// [
//   [1,2],
//   [0,3]
// ],

// return
// [
// [0,2],
// [0,0]
// ]

// how do I take this quesiton?
// Solution #0
// first I am gonna just split the tasks
// first we need to find the 0s, then just set those rows and columns with 0 in it to all the 0s
// the time complexity for finding the 0s can be O(n * m) if we use double loop to find the 0s
// and can be reduced to (logn * m) or O(logm * n) by using the binary search
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
    	// use ArrayList to store rows 0 and columns 0
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}

    	int row = matrix.length;
    	int col = matrix[0].length;
    	HashSet<Integer> row0s = new HashSet<Integer>();
    	HashSet<Integer> col0s = new HashSet<Integer>();

    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			if (matrix[i][j] == 0) {
    				row0s.add(i);
    				col0s.add(j);
    			}
    		}
    	}

    	// set those cols and rows to 0

    	// for every index in row0s; for loop the cols
    	for (Integer row0 : row0s) {
    		for (int i = 0; i < col; i++) {
    			matrix[row0][i] = 0;
    		}
    	}

    	for (Integer col0 : col0s) {
    		for (int i = 0; i < row; i++) {
    			matrix[i][col0] = 0;
    		}
    	}
    }
}

/* 
Actually, I got this right in 20 mins without any help, and I think elaborating what you think of the problem
is gonna help myself during the process of solving the problem
*/

// Solution #1
// At first glance, this problem seems easy: just iterate through the matrix and every time we
// see a 0, set that row and column to 0. There’s one problem with that solution though: we
// will “recognize” those 0s later on in our iteration and then set their row and column to zero.
// Pretty soon, our entire matrix is 0s!
// One way around this is to keep a second matrix which flags the 0 locations. We would then
// do a second pass through the matrix to set the zeros. This would take O(MN) space.
// Do we really need O(MN) space? No. Since we’re going to set the entire row and column to
// zero, do we really need to track which cell in a row is zero? No. We only need to know that
// row 2, for example, has a zero.
// The code below implement this algorithm. We keep track in two arrays all the rows with
// zeros and all the columns with zeros. We then make a second pass of the matrix and set a cell
// to zero if its row or column is zero.

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    	    return;
    	}
    	// we are gonna need two seperate arrays to store the value of 0 in a column or row
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[] row0s = new int[m];
    	int[] col0s = new int[n];

    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (matrix[i][j] == 0) {
    				row0s[i] = 1;
    				col0s[j] = 1;
    			}
    		}
    	}

    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (row0s[i] == 1 || col0s[j] == 1) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    }
}

/* 
It seems that the second solution has a better running time
*/