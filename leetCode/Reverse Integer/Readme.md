## leetcode——Reverse Integer
### 【题目描述】
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

### 【解题思路】
很简单的一道题，但是需要注意判断越界。
当一个整数反转后，可能出现越界的情况，因此在开始时结果定义为long，然后在计算过程中判断数组是否越界。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2020/1/89:57
 */
public class Solution {
    public int reverse(int x)
    {
        if (x == 0)
            return x;
        boolean flag = true;//默认为正数
        if (x < 0)
            flag = false;
        x = Math.abs(x);
        long res = 0;
        while (x>0)
        {
            int temp = x%10;
            res = res * 10 +temp;
            if (res>Integer.MAX_VALUE || res<Integer.MIN_VALUE)
                return 0;
            x = x/10;
        }
        if (!flag)
            res = -res;
        return (int)res;
    }
}

```