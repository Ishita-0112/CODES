/*  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows); */

class Solution {
  public String convert(String s, int numRows) {
    int length = s.length();

    if (numRows > length || numRows <= 1) {
      return s;
    }

    char[] zigZagChars = new char[length];
    int count = 0;

    int interval = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      int step = interval - 2 * i;
      for (int j = i; j < length; j += interval) {
        zigZagChars[count] = s.charAt(j);
        count++;
        if (step > 0 && step < interval && j + step < length) {
          zigZagChars[count] = s.charAt(j + step);
          count++;
        }
      }
    }

    return new String(zigZagChars);
  }
}
