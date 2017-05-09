// An array A[1...n] contains all the integers from 0 to n except for one number
// which is missing. In this problem, we cannot access an entire integer in A
// with a single opera- tion. The elements of A are represented in binary, and  
//the only operation we can use to access them is “fetch the jth bit of A[i]”,
// which   takes constant time. Write code to  nd the missing integer. Can you  
// do it in O(n) time?

// What is the run-time of this algorithm? On the  rst pass, we look at O(N)
// bits.  On the second pass, we’ve eliminated N/2 numbers, so we then look at  
// O(N/2) bits. On the third pass, we have eliminated another half of the
// numbers,   so we then look at O(N/4) bits. If we keep go- ing, we get an
// equation   that looks like:
// O(N) + O(N/2) + O(N/4) + O(N/8) + ... = O(2N) = O(N)
// Our run-time is O(N).


class Solution {
    public int findMissing(ArrayList<BitInteger> array) {
        return findMissing(array, BitInteger.INTEGER_SIZE - 1);
    }

    public int findMissing(ArrayList<BitInteger> input, int column) {
        if (column < 0) { // base case
            return 0;
        }
        ArrayList<BitInteger> oddIndices = new ArrayList<BitInteger>();
        ArrayList<BitInteger> evenIndices = new ArrayList<BitInteger>();

        for (BitInteger t : input) {
            if (t.fetch(cloumn) == 0) {
                evenIndices.add(t);
            } else {
                oddIndices.add(t);
            }
        }

        if (oddIndices.size() >= evenIndices.size()) {
            return (findMissing(evenIndices, column - 1)) << 1 | 0;
        } else {
            return (findMissing(oddIndices, column - 1)) << 1 | 1;
        }
    }
}

/*
comeback and go over
*/