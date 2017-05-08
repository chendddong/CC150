// Given a (decimal - e.g. 3.72) number that is passed in as a string, print the
// binary representation. If the number   can not be represented accurately in
// binary, print “ERROR”

// First, let’s start o  by asking ourselves what a non-integer number in binary
// looks like.   By analogy to a decimal number, the number n = 0.101 = 1 * 
// (1/2^1) +   0 * (1/2^2) + 1 * (1/2^3).
// Printing the int part of n is straight-forward (see below). To print the
// decimal part,   we can multiply by 2 and check if the 2*n is greater than or
// equal to one.   This is essentially “shifting” the fractional sum. That is:
// r = 2*n = 2*0.101 = 1*(1 / 2^0) + 0*(1 / 2^1) + 1*(1 / 2^2) = 1.01
// If r >= 1, then we know that n had a 1 right after the decimal point. By
// doing this   continu- ously, we can check every digit.

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
        String int_string = "";
        if (intPart == 0) {
            int_string = "0";
        }
        
        while (intPart > 0) {
            int r = intPart % 2;
            intPart = intPart >> 1;
            int_string = r + int_string;
        }

        StringBuffer dec_string = new StringBuffer();
        if (decPart == 0) {
            return int_string;
        }
        while (decPart > 0) {
            if (dec_string.length() > 32) {
                return "ERROR";
            }
            if (decPart == 1) {
                dec_string.append((int) decPart);
                break;
            }
            double r = decPart * 2;
            if (r >= 1) {
                dec_string.append(1);
                decPart = r - 1;
            } else {
                dec_string.append(0);
                decPart = r;
            }
        }

        return int_string + "." + dec_string.toString();    
        
    }
}

/*
1. divide the string into two parts;
2. get the string for the integer Part  
    while (intPart > 0) {
        int r = intPart % 2;
        intPart = intPart >> 1;
        int_string = r + int_string;
    }

3. get the string for the decimal Part
   Mind those conditions:

    while (decPart > 0) {
        if (dec_string.length() > 32) {
            return "ERROR";
        }
        if (decPart == 1) {
            dec_string.append((int) decPart);
            break;
        }
        double r = decPart * 2;
        if (r >= 1) {
            dec_string.append(1);
            decPart = r - 1;
        } else {
            dec_string.append(0);
            decPart = r;
        }
    }
*/
