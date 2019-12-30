### 【题目描述】
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

### 【解题思路】
start和end两个索引，指向当前子字符串。判断下一个字符是否与当前字符串中字符重复。若重复，则定位重复的那个字符位置，赋予start。判断当前子字符串长度，并与最长长度比较。 end++。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/12/3022:13
 */
public class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length()<2)
            return s.length();
        int maxlen = 1, start = 0, end = 1;
        String curStr;
        while (end < s.length())
        {
            curStr = s.substring(start, end);
            if (curStr.contains(String.valueOf(s.charAt(end))))
            {
                start = start + curStr.indexOf(s.charAt(end)) + 1;
            }
            int len = end - start + 1;
            if (len > maxlen)
                maxlen = len;
            end++;
        }
        return maxlen;
    }
}

```