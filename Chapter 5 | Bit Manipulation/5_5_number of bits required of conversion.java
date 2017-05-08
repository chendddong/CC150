// Write a function to determine the number of bits required to convert  
// integer A to integer B.
// Input: 31, 14 Output: 2

// This seemingly complex problem is actually rather straightforward. To
// approach this,   ask yourself how you would  gure out which bits in two
// numbers are di   erent. Simple: with an xor.
// Each 1 in the xor will represent one di erent bit between A and B. We then
// simply  need to count the number of bits that are 1.

class Solution {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        // use >>> when dealing with signed numbers
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }
}

/*
The application of Xor
*/