## leetcode——String to Integer (atoi)
### 【题目描述】
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.

### 【解题思路】
先对输入进行处理，去掉首尾多余的空格。然后判断第一个字符是否符合条件，即是否是正负符号或者是非数字符号等特殊情况。
然后对字符串数字开始判断，每次需要判断一下结果是否整数溢出。只要出现非数字字符，则停止循环判断。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2020/1/915:30
 */
public class Solution {
    public int myAtoi(String str)
    {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;
        long res = 0L;
        boolean flag = true;//默认是正数
        int index = 0;
        if (str.charAt(index) == '+')
            index++;
        else if (str.charAt(index) == '-')
        {
            flag = false;
            index++;
        }
        else if (str.charAt(index) < '0' || str.charAt(index) > '9')
            return 0;
        while (index < str.length())
        {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9')
                res = res * 10 + Integer.parseInt(String.valueOf(str.charAt(index)));
            else
                break;
            if (res > Integer.MAX_VALUE && flag)
                return Integer.MAX_VALUE;
            if (!flag && -res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
        }
        if (!flag)
            return (int)-res;
        return (int)res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.myAtoi("     -12"));
    }
}

```