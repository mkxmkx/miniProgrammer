## 剑指offer——把字符串转换成整数

### 【题目描述】
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
+2147483647
    1a33
输出
2147483647
    0
### 【解题思路】
首先判断符号正负。
然后遍历每个字符，判断是否是数字符号。若不是，则返回0。
有一个特殊情况需要判断，就是是否溢出整数范围。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/1721:04
 */
public class Solution {
    public int StrToInt(String str)
    {
        if (str.length()==0)
            return 0;
        int flag = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '+')
            flag = 1;
        else if (chars[0] == '-')
            flag = 2;
        int start = flag>0? 1: 0;
        long result = 0;
        while (start < chars.length)
        {
            if (chars[start] > '9' || chars[start] < '0')
            {
                return 0;
            }
            result = result * 10 + (chars[start]-'0');

            start++;
        }
        result = flag==2? -result: result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }

    public static void main(String[] args)
    {
        String s = "-123";
        Solution sol = new Solution();
        System.out.println(sol.StrToInt(s));
    }
}

```
﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿