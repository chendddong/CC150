// 5.3 Given an integer, print the next smallest and next largest number that
// have the same number of 1 bits in  their binary representation.

// The Brute Force Approach:
//  An easy approach is simply brute force: count the number of 1’s in n, and
// then   increment (or decrement) until you  nd a number with the same number
// of 1’s.   Easy - but not terribly interesting. Can we do something a bit  
// more optimal? Yes!

// Observations:
// » If we“turn on”a 0, we need to“turn o ”a 1
// » If we turn on a 0 at bit i and turn o  a 1 at bit j, the number changes by 
// 2^i - 2^j.
// » If we want to get a bigger number with the same number of 1s and 0s, i must
// be bigger than j.

// Solution:
// 1. Traverse from right to left. Once we’ve passed a 1, turn on the next 0.
// We’ve   now in- creased the number by 2^i. Yikes! Example: xxxxx011100
// becomes   xxxxx111100
// 2. Turn o  the one that’s just to the right side of that. We’re now bigger by
// 2^i   - 2^(i-1) Example: xxxxx111100 becomes xxxxx101100
// 3. Make the number as small as possible by rearranging all the 1s to be as
// far   right as pos- sible: Example: xxxxx101100 becomes xxxxx100011

// To get the previous number, we do the reverse.
// 1. Traverse from right to left. Once we’ve passed a zero, turn o  the next 1.
// Example: xxxxx100011 becomes xxxxx000011.
// 2. Turn on the 0 that is directly to the right. Example: xxxxx000011 becomes 
// xxxxx010011.
// 3. Make the number as big as possible by shifting all the ones as far to the 
// left as pos- sible. Example: xxxxx010011 becomes xxxxx011100 .
// And now, for the code. Note the emphasis on pulling common code out into a  
// reusable func- tion. Your interviewer will look for “clean code” like this.

class Solution {
    public static boolean GetBit(int n, int index) {
        return ((n & (1 << index)) > 0);
    }

    public static int SetBit(int n, int index, boolean b) {
        if (b) {
            return n | (1 << index);
        } else {
            int mask = ~(1 << index);
            return n & mask; 
        }

    }

    public static int GetNext_NP(int n) {
        if (n <= 0) {
            return -1;
        }

        int index = 0;
        int countOnes = 0;
        // Find first one.
        while (!GetBit(n, index)) {
            index++;
        }

        // Turn on next zero.
        while (GetBit(n, index)) {
            index++;
            countOnes++;
        }
        n = SetBit(n, index, true);

        // Turn off previous one
        index--;
        n = SetBit(n, index, false);
        countOnes--;

        // Set zeros
        for (int i = index - 1; i >= countOnes; i--) {
            n = SetBit(n, i, false);
        }

        // Set ones
        for (int i = countOnes - 1; i >= 0; i--) {
            n = SetBit(n, i, true);
        }

        return n;
    }

    public static int GetPrevious_NP(int n) {
        if (n <= 0) return -1; // Error

        int index = 0;
        int countZeros = 0;

        //Find first zero
        while (GetBit(n, index)) index++;

        // Turn off next 1.
        while (!GetBit(n, index)) {
            index++;
            countZeros++;
        }
        n = SetBit(n, index, false);

        //Turn on previous zero
        index--;
        n = SetBit(n, index, true);
        countZeros--;

        // Set ones
        for (int i = index - 1; i >= countZeros; i--) {
            n = SetBit(n, i, true);
        }

        // Set zeros
        for (int i = countZeros - 1; i >= 0; i--) {
            n = SetBit(n, i, false);
        }

        return n;
    }
}

/*
The basic idea is very clear. But I think it's bit hard to code for this kind of
pproblem. Just get used to it.

Good problem
*/