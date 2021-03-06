## LeetCode——ZigZag Conversion
### 【题目描述】
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

### 【解题思路】
按之字形打印。其实就是按之字形把字符串中每一个字符分别赋予到不同的数组中。
如何让按照之字形，即到达边界范围之后自动反转方向加或减。
使用一个标志位来判断数组索引应该加还是减即可达到之字形的效果。

### 【代码实现】

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2020/1/79:57
 */
public class Solution {
    public String convert(String s, int numRows)
    {
        if (s == null ||s.length() == 0)
            return s;
        if (numRows == 1)
            return s;
        Map<Integer, String> numS = new HashMap<>();
        for (int i=0; i<numRows; i++)
        {
            numS.put(i, "");
        }
        int index = 0;
        boolean flag = true;//序号是否增加
        int i = 0;
        while (index<s.length())
        {
            numS.put(i,numS.get(i)+s.charAt(index));
            if (flag && i==numRows-1)
                flag = false;
            if (!flag && i==0)
                flag = true;
            if (flag)
                i++;
            else
                i--;
            index++;
        }
        String res = "";
        for (i = 0; i<numRows; i++)
            res += numS.get(i);
        return res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}

```