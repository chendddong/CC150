// 1.1 Implement an algorithm to determine if a string has all unique characters. 
// What if you can not use additional data structures?
// For simplicity, assume char set is ASCII (if not, we need to increase the storage size. The rest
// of the logic would be the same). NOTE: This is a great thing to point out to your interviewer!

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
    	// this is the max length that a str can get
    	boolean[] char_set = new boolean[256];
    	for (int i = 0; i < str.length(); i++) {
    		int val = str.charAt(i);
    		if (char_set[val]) {
    			return fasle;
    		}
    		char_set[val] = true;
    	}
    	return true;
    }
}

/* we use the boolean array to record if a certain char appears in the String 
   in this case the time complexity is O(n), where n is the length of the string,
   and spacecomplexity is O(n) since we only use n positions in the array
*/

// We can reduce our space usage a little bit by using a bit vector. We will assume, in the below
// code, that the string is only lower case 'a' through 'z'. This will alow us to use just a single
// int 
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
    	int checker = 0;
    	for (int i = 0; i < str.length(); ++i) {
    		int val = str.charAt(i) - 'a';
    		if ((checker & (1 << val)) > 0) {
    			return false;
    		}
    		checker += (1 << val);
    	}
    	return true;
    }
}

// Alternatively, we could do the following:
// 1. Check every char of the string with every other char of the string 
// for duplicate occurrences.
// This will take O(n^2) time and no space.
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
    	int len = str.length();

    	for (int i = 0; i < len; i++) {
    		for (int j = i + 1; j < len; j++) {
    			if (str.charAt(i) == str.charAt(j)){
    				return false;
    			}
    		}
    	}

    	return true;
    }
}


// 2. If we are allowed to destroy the input string, we could sort the string in O(nlogn) time
// and then linearly check the string for neighboring characters that are identical. 
// Careful,though - many sorting algorithms take up extra space.

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
    	char[] charArray = new char[str.length()];
    	for (int i = 0; i < str.length(); i++) {
    		charArray[i] = str.charAt(i);
    	} 
    	// Arrays.sort() can only be used to sort array;
    	Arrays.sort(charArray);

    	for (int i = 1; i < str.length(); i++) {
    		if (charArray[i - 1] == charArray[i]) {
    			return false;
    		}
    	}

    	return true;
    }
}
