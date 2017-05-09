// You are given two 32-bit numbers, N and M, and two bit positions, i and j.
// Write a method to set all bits between i and j in N equal to M   (e.g., M
// becomes a   substring of N located at i and starting at j).
// EXAMPLE:
// Input: N = 10000000000, M = 10101, i = 2, j = 6
// Output: N = 10001010100


/*  This code operates by clearing all bits in N between position i and j, and 
then ORing to put M in there.*/


class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        
        int max = ~0; /* All 1’s */
        // 1’s through position j, then 0’s
        if (j == 31)
            j = max;
        else
            j = (1 << (j + 1)) - 1;
        int left = max - j;
        // 1’s after position i
        int right = ((1 << i) - 1);
        // 1’s, with 0s between i and j
        int mask = left | right;
        // Clear i through j, then put m in there
        return ((n & mask) | (m << i));
    }
}

/*
This is mindblowing
1. remember that the postion is from the back of the number
for example: 10000000000 with i = 2 ; j = 6
                 j   i
*/ 


