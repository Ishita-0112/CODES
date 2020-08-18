/* Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.

Note:
    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
*/

/* CODE */

public class Solution {
    public int myAtoi(String str) {
        // remove whitespaces
        str = str.trim();
        
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        double result = 0;
        
        // handle positive and negative sign
        boolean isNegative = false;
        int startIndex = 0; // index of first numerical character
        
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            startIndex++;
        }
        if (str.charAt(0) == '-') {
            isNegative = true;
        }
        
        // handle normal case "123"
        for (int i = startIndex; i < str.length(); i++) {
            // handle non-numerical character
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            int digitValue = (int)(str.charAt(i) - '0'); // '9' - '0' 
            result = result * 10 + digitValue;
        }
        
        if (isNegative) {
            result = -result;
        }
        
        // handle out of Integer range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }
}
