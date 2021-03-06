## LeetCode——Longest Palindromic Substring
## 【题目描述】
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

## 【解题思路】
寻找字符串的最长回文子串。
一开始我的思路是从字符串的第一个字符开始，检查之后的字符中是否存在相同字符。若后面存在相同字符，说明有存在回文的可能，然后进一步判断这两个字符之间是否真的是回文。对于存在多个相同字符的情况，循环判断每一对字符之间是否是回文。但是这个方法不能完全通过测试用例。因为套了两层循环，第一次是对字符串从头到尾每个判断，第二个循环是当有相同字符存在，即存在回文可能时，进一步判断每两对字符之间是否回文。当字符串所有字符都相同时，第一层循环就是多余的，做了很多无用功。
虽然没有通过所有测试用例，但还是把我的思路和代码记录下来。

代码实现：

```java
public String longestPalindrome(String s)
    {
        if(s == null || s.length()==0)
            return s;
        int maxLen;
        String res = s.substring(0,1);
        maxLen = 1;
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            int index = i+1;
            int end = s.indexOf(c, index);
            while (end!=-1 && index<=s.length())
            {
                boolean flag = checkPalindrome(s.substring(i, end+1));
                if (flag && (end-i+1) > maxLen)
                {
                    maxLen = end-i+1;
                    res = s.substring(i, end+1);
                }
                index = end+1;
                end = s.indexOf(c, index);
            }
        }
        return res;
    }

    boolean checkPalindrome(String s)
    {
        int start, end;
        start = 0;
        end = s.length()-1;
        while (start<end)
        {
            if (s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
                break;
        }
        if (start<end)
            return false;
        else
            return true;
    }
```


#### 【解题思路1——动态规划】
由于思路1中做了很多无用功，因此使用动态规划的方法，将判断过的回文记录下来，就不用重复判断了。

flag[i][j]表明字符串中从i开始到j的子字符串是否是回文。因此判断一个子字符串是否是回文时，首先判断两端字符是否相同，当相同时，再进一步判断其内部是否是回文，即flag[i+1][j-1]是否是回文。其次，还要考虑长度，当子字符串长度小于2时，就没有内部字符串回文判断必要了。

代码实现：

```java
public String longestPalindrome_v2(String s)
    {
       if (s == null || s.length()== 0)
           return s;
       boolean[][] flag = new boolean[s.length()][s.length()];
       int maxlen = 0;
       String res = s.substring(0,1);
       for (int j = 0; j<s.length(); j++)//i代表字符串的开始索引，j代表字符串的结束索引
       {
           int i = 0;
           flag[j][j] = true;//单个元素是回文
           for (;i<j; i++)
           {
               flag[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i<2||j>0&&flag[i+1][j-1]);
               //串的长度小于等于2时，肯定是回文子串，如 1，1，就是回文串。
               //如果长度大于2时，则需要判断f[i+1][j-1]是不是回文。
               if (flag[i][j] && (j-i+1)>maxlen)
               {
                   maxlen = j-i+1;
                   res = s.substring(i,j+1);
               }

           }
       }
       return res;
    }
```