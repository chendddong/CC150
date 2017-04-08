// Design an algorithm and write code to remove the duplicate characters in a string
// without using any additional buffer. NOTE: One or two additional variables are fine.
// An extra copy of the array is not.

// FOLLOW UP
// Write the test cases for this method.


// [316] LeetCode
// Given a string which contains only lowercase letters, remove duplicate letters so 
// that every letter appear once and only once. 
// You must make sure your result is the smallest in lexicographical order among all possible results.

// Example:
// Given "bcabc"
// Return "abc"

// Given "cbacdcbc"
// Return "acdb"

// the brute force version the time complexity is O(n^2) my tought at first is to double loop the whole 
// thing and when find a duplicate char just rotate that to the last position but it turns out not working

// version 1

// Design an algorithm and write code to remove the duplicate characters in a string
// without using any additional buffer. NOTE: One or two additional variables are fine.
// An extra copy of the array is not.

// first, ask yourself what does the interviewer mean by an additional buffer? Can we use an additional array of contstant size?
// 1. for each character check if it is a duplicate of already found characters
// 2. Skip duplicate characters adn update the non duplicate characters.
public class Solution {

    public static void removeDuplicates(char[] str) {
        if (str == null) {
        	return;
        }
        int len = str.length;
        if (len < 2) {
        	return;
        }

        int tail = 1;
// They both increment the number. ++i is equivalent to i = i + 1.

// i++ and ++i are very similar but not exactly the same. Both increment the number, but ++i increments the number 
// before the current expression is evaluted, whereas i++ increments the number after the expression is evaluated.

// int i = 3;
// int a = i++; // a = 3, i = 4
// int b = ++a; // b = 4, a = 4
        for (int i = 1; i < len; ++i) {
        	int j;
        	for (j = 0; j < tail; ++j) {
        		if (str[i] == str[j]) {
        			break;
        		}
        	}

        	if (j == tail) {
        		str[tail] = str[i];
        		++tail;
        	}
        }

        str[tail] = 0;
    }
}



/*
Test Cases:
1. String does not contain any duplicates, e.g.: abcd
2. String contains all duplicates, e.g.: aaaa
3. Null string
4. String with all continuous duplicates, e.g.: aaabbb
5. String with non-contiguous duplicate, e.g.: abababa
*/

//  Algorithm—With Additional Memory of Constant Size
public class Solution {
	public static void removeDuplicatesEff(char[] str) {
		if (str == null) {
			return;
		}

		int len = str.length;
		if (len < 2) {
			return;
		}

		// use boolean array to record
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit [i] = false;
		}

		hit[str[0]] = true;
		// Java doesn't "mark" the end-of-string as C does. It tracks length & values, 
		// so it's possible to have zero-chars (\0) in the string. If you create a String 
		// from a char array containing \0 chars, the resultant String will contain those characters.
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}

		str[tail] = 0;
	}

}

/* 
Test cases for this method
1. String does not contain any duplicates, e.g.: abcd
2. String contains all duplicates, e.g.: aaaa
3. Null string
4. Empty string
5. String with all continuous duplicates, e.g.: aaabbb
6. String with non-contiguous duplicates, e.g.: abababa
*/