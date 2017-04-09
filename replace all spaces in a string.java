// 1.5 Write a method to replace all spaces in a string with '%20'.


// LintCode Write a method to replace all spaces in a string with '%20'. The string is given in a characters array, 
// you can assume it has enough space for replacement and you are given the true length of the string.
// You code should also return the new length of the string after replacement.

// Solution #0 for loop the array O(length),

// and this is a wrong answer

// public class Solution {
//     /**
//      * @param string: An array of Char
//      * @param length: The true length of the string
//      * @return: The true length of new string
//      */
//     private int num_space = 0;
//     public int replaceBlank(char[] string, int length) {
//     	// 1. find how many spaces are there
//     	// 2. calculate the actual length of the String
//     	if (string.length == 0) {
//     		return 0;
//     	}

//     	String result = "";
    	
//     	for (int i = 0; i < length; i++) {
//     		if (string[i] == ' ') {
//     			result = result + "%20";
//     			num_space++;
//     			continue;
//     		}

//     		result = result + Character.toString(string[i]);
//     	}

//     	string = result.toCharArray();
//     	return num_space + length * 2;

//     }
// }

// Solution #1 by the author
// 1. Count the number of paces during the first scan of the string 
// 2. pares the string again from the end and for each character:
// 		if a space is encounterd, store "%20"
// 		else, store the character as it is in the newly shifted location
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if(length == 0) {
            return 0;
        }
        
    	int spaceCount = 0, newLength, i = 0;
    	for (i = 0; i < length; i++) {
    		if (string[i] == ' ') {
    			spaceCount++;
    		}
    	}
    	newLength = length + spaceCount * 2;
    	int result = newLength;
    	// we cannot new a string, so we must use this to pretend to new a char array
    	// here we can use int 0 if we want to
    	string[newLength] = '\0' ;
    	for (i = length - 1; i >= 0; i--) {
    		if (string[i] == ' ') {
    			string[newLength - 1] = '0';
    			string[newLength - 2] = '2';
    			string[newLength - 3] = '%';
    			newLength = newLength - 3;
    		} else {
    			string[newLength - 1] = string[i];
    			newLength = newLength - 1;
    		}
    	}
    	
    	return result;
    }
}


/*
And this is how to manipulate a char array in place!!! 

The standard library of the C programming language commonly uses NUL-terminated strings. 
A NUL-terminated string is stored in an array, and the string itself consists of all the 
characters in an array prior to the first '\0' character (called a NUL in ASCII). For example, 
if the elements of a character array are {'H','e','l','l','o','\0','i','d','1','0','t'}, the string is "Hello", 
with everything after the NUL ignored. If you write '\0' to position n of a NUL-terminated string, 
you will cut off everything after the first n characters, which reduces the string's length to no more than n. 
The writes to str[newLength - 1] and the like write characters just before the NUL.
*/