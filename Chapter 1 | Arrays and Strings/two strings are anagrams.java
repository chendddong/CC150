// Write a method to decide if two strings are anagrams or not.

// Sulution #0 what I can think of this problem is to
// time complexity is nlogn because of the sort method.
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
       	if ((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
			return true;
		}

		if (s.length() != t.length()) {
			return false;
		}
		// sort the two strings to two arrays
		char[] ch_a = s.toCharArray();
		char[] ch_b = t.toCharArray();
		Arrays.sort(ch_a);
		Arrays.sort(ch_b);

		int indexA = 0, indexB = 0;
		
		while (indexA < s.length() - 1) {
			if (ch_a[indexA++] != ch_b[indexB++]) {
				return false;
			}

		}

		if ((indexA == indexB) && (indexA == s.length() - 1) && (indexB == t.length() - 1)) {
			return true;
		}

		return false;
    }
}


// Solution #1: Sort the strings O(nlogn)
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
    	return sort(s).equals(sort(t));
    }

    private static String sort(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

/*
Always remember to use String.equals() to compare two strings.
*/

// Solution #2: Check if the two strings have identical counts for each unique char. O(max(n, m))
// but this one has used some extra space AKA int[] count = new int[256];

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
    	if (s.length() != t.length()) {
    		return false;
    	}

    	// for all the ASCII in the string 
    	int[] count = new int[256];
    	
    	for (int i = 0; i < s.length(); i++) {
    		// if they are more than lowercase, it should be
    		// char to int convertion
    		int index = (int) s.charAt(i);
    		count[index]++;
    	}

    	for (int j = 0; j < t.length(); j++) {
    		int index = (int) t.charAt(j);
    		count[index]--;
    		if (count[index] < 0) {
    			return false;
    		}
    	}

    	return true;

    }
}

/* 
remember to use this to create arrays full of 0 int[] count = new int[256];
This is way better and identical for the two for loops than the answer that the author offered
*/

// Solution #3: Check if the two strings have identical counts for each unique char.
// this is what the author did O(max(m, n))
class Solution {
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			if (letters[c] == 0) {
				++num_unique_chars;
				++letters[c];
			}
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) {
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it's a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}
}

/*
Basically, this has the same flow of the second solution 
*/