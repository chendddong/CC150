// 1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
// five characters, including the null character.)

// since this one is a C-String, we'd better use C

void reverse(char *str) {
	char * end = str;
	char tmp;
	if (str) {
		while (*end) {
			++end;
		}
		--end;
		while (str < end) {
			tem = *str;
			*str++ = *end;
			*end-- = tmp;
		}
	}
}

/* 
This is a classic interview question. The only “gotcha” is to try to do it in place, and to be careful
for the null character.
*/


// 1. Two pointers point to the beginning and the end, then exchange values and move forward/backward until p1 >= p2.
// 2. In Java, there is no null character at the end of a string, thus all the code written in Java may not meet the requirement. 
// But it does not affect the algorithm, we just need to ignore the null character if it exists.

public static String reverseAString(String str) {
	if (str == null || str.length() == 0) {
		return str;
	}

	int startIn = 0, endIn = str.length() - 1;
	// we have to convert the str into chars and store them in an array;
	char[] characters = str.toCharArray(str);
	while (startIn <= endIn) {
		char temp = characters[endIn];
		characters[endIn] = characters[startIn];
		characters[startIn] = temp;
		startIn++;
		endIn--;
	}
	// the direct conversion
	return new String(characters);
}


// Another way is to solve the problem recursively. I think it is the solution expected by the interviewer.
// this is my initial code apparently it has bugs and there would be null pointer somepoint in the future.
public static String reverseAString(String str) {

    if (str == null || str.length() == 1) {
        return str;
    }

    char first = str.charAt(0);
    char last = str.charAt(str.length() - 1);
    String substring = str.substring(1, str.length() - 1);

    return last + reverseAString(substring) + first;
}

// but the code should be like just swap the last char and keep going
public static String reverseAString(String str) {

    if (str == null || str.length() == 1) {
        return str;
    }
    return str.charAt(str.length() - 1) + reverseAString(str.substring(0, str.length() - 1));
}