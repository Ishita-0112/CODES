// ----------------------------------QUESTION------------------

// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

// For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral.

// Example 1:

// Input: num = 3
// Output: "III"
// Example 2:

// Input: num = 4
// Output: "IV"

// ---------------------------------SOLUTION---------------------

// map the values of the roman numerals to their number correspondents and
// perform simple brute

// ------------------------------CODE-------------------------

string intToRoman(int num) {
        string ans="";

        map<int,string> mp;
        mp[1000]="M";
        mp[900]="CM";
        mp[500]="D";
        mp[400]="CD";
        mp[100]="C";
        mp[90]="XC";
        mp[50]="L";
        mp[40]="XL";
        mp[10]="X";
        mp[9]="IX";
        mp[5]="V";
        mp[4]="IV";
        mp[1]="I";

        vector<int> v(13);
        v[0]=1000;
        v[1]=900;
        v[2]=500;
        v[3]=400;
        v[4]=100;
        v[5]=90;
        v[6]=50;
        v[7]=40;
        v[8]=10;
        v[9]=9;
        v[10]=5;
        v[11]=4;
        v[12]=1;
        
        for(int i=0; i<13; i++){
            while(num>=v[i]){
                ans+=mp[v[i]];
                num-=v[i];
            }
        }
        return ans;
    }