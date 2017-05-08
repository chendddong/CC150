// You are given two 32-bit numbers, N and M, and two bit positions, i and j.
// Write a method to set all bits between i and j in N equal to M   (e.g., M
// becomes a   substring of N located at i and starting at j).
// EXAMPLE:
// Input: N = 10000000000, M = 10101, i = 2, j = 6
// Output: N = 10001010100


/*  This code operates by clearing all bits in N between position i and j, and 
then ORing to put M in there.*/


class Solution {
    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1's */

        // 1's trough position j, then 0's
        int left = max - (1 << j) - 1);

        // 1's after position i
        int right = ((1 << i) - 1);

        // 1's, with 0s between i and j
        int mask = left | right;29999982

        // clear i through j, them put m in there
        return (n & mask) | (m << i);
    }
}

/*
This is mindblowing
1. remember that the postion is from the back of the number
for example: 10000000000 with i = 2 ; j = 6
                 j   i
*/