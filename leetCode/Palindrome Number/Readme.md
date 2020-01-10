## leetcod——Palindrome Number
### 【题目描述】
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?

### 【解题思路】
不通过将整数转换为字符串来判断。
通过生成一个反转之后的整数，生成一半的反转数即可。
当整数是偶数位时，原数的一半与生成的反转数是相等的。当整数是奇数位时，原数的一半与生成的反转数去掉末尾数是一样的，即生成的反转数多了一个最中间的数字。
通过判断反转数是否比原数小来判断循环是否停止。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2020/1/1022:28
 */
public class Solution {
    public boolean isPalindrome(int x)
    {
        if (x < 0 || x%10 == 0 && x!=0)
            return false;
        int res = 0;
        while (res<x)
        {
            res = res * 10 + x%10;
            x = x/10;
        }
        return x == res || x == res/10;
    }
}

```