## leetcode ——Regular Expression Matching
### 【题目描述】
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
正则表达式匹配
### 【解题思路】
分治法。按照正常思路去匹配字符串，从前到后，依次判断模式是否与当前字符串匹配。
首先判断第二个字符串是否为‘*’，当是‘*’时，判断s的第一个字符与模式的第一个字符是否匹配（字符相同或者是匹配‘.’），则可以三种情况匹配，s索引加一且模式不变；s索引加一且模式索引加2，即当前匹配完；s不变，模式索引加2，即什么都不匹配。
当第一个字符不匹配时，则直接模式索引加2，即什么都不匹配。
当第二个字符不是‘*’时，则匹配第一个字符，相同或匹配‘.’，然后s和模式索引都加一。

结束判断条件是判断s和模式都到达结尾时，说明完全匹配；当s未到达结尾，而模式到达结尾，则说明不匹配。
不需要以s是否到达结尾作为结束条件，只需要以模式是否到达结尾作为结束条件，而s是否到达结尾在匹配时作为一个限制条件即可。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2020/1/1117:03
 */
public class Solution {
    public boolean isMatch(String s, String p)
    {
        if (s.length() == 0 && p.length() == 0)
            return true;
        int strIndex = 0, patIndex = 0;
        return check(s, strIndex, p, patIndex);
    }
    boolean check(String s, int strIndex, String p, int patIndex)
    {
        //不用以s是否到结尾判断结束，只需一直判断pattern是否匹配结束，当pattern到结尾，但是s还没结束，则为false
        //在匹配的时候，以s未到结尾作为一个限制条件
        if (s.length() == strIndex && p.length() == patIndex)
            return true;
        if (s.length() != strIndex && p.length() == patIndex)//pattern先匹配完，失败
            return false;
        if (patIndex+1 < p.length() && p.charAt(patIndex+1) == '*')
        {
            if (strIndex != s.length() && (s.charAt(strIndex) == p.charAt(patIndex) || p.charAt(patIndex) == '.'))
                return check(s, strIndex+1, p, patIndex)
                        || check(s, strIndex+1, p, patIndex+2)
                        || check(s, strIndex, p, patIndex+2);//第三种情况，也可以什么都不匹配
            else
                return check(s, strIndex, p, patIndex+2);
        }
        if (strIndex != s.length() && (p.charAt(patIndex) == s.charAt(strIndex) || p.charAt(patIndex) == '.'))
            return check(s, strIndex+1, p, patIndex+1);
        return false;﻿
    }
    public static void main(String[] args)
    {﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿
        Solution s = new Solution();
        System.out.println(s.isMatch("",".*"));
    }
}

```