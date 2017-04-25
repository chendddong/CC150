// 1.8 Assume you have a method isSubstring which checks if one word is a substring of
// another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
// only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).


// when I was breaking down this quesiton, I tend to think that I need to use more than once of the
// method isSubstring and cut the original string into 2 parts and if they are both substrings then
// I am done like 'waterbottle' can be disseminated into wat and erbottle and they are both substrings   
// of the 'erbottlewat'. However I used it twice



// Solution #0 my version after the hint


class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

// stringstring -> ing
// this can also be modified as blooean which is trivial to do
    public int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}

		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			int j = 0;
			for (j = 0; j < target.length(); j++) {
				// the index is very tricky
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}

			if (j == target.length()) {
				return i;
			}
		}
		return -1;
	}  
}

// Just do the following checks
// 1. Check if length(s1) == length(s2). If not, return false.
// 2. Else, concatenate s1 with itself and see whether s2 is substring of the result.
// input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap
// input: s1 = apple, s2 = ppale ==> apple is not a substring of ppaleppale

	public boolean isRoation(String s1, String s2) {
		if ((s1.length() != s2.length) || s1.length() <= 0 || s2.length() <= 0) {
			return false;
		}
		String newS1 = s1 + s1;
		if (isSubString(s2, newS1)) {
			return true;
		}
		return false;

	}
}

// Solution #1 the author's


class Solution {
	// private boolean isSubString(String s1, String s2) {
	// 	/* ...
	// 	*/
	// }

	public boolean isRoation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;

	}
}