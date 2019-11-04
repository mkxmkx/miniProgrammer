## 剑指offer——左旋转字符串
### 【题目描述】
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

### 【解题思路】
左旋转字符串就是根据索引位置，将字符串划分为两个，然后调整两个字符串的先后顺序，拼接起来就可以了。

有一个问题就是移动的位数n可能超过字符串长度，因此n要对字符串长度取模。
### 【代码描述】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/411:14
 */
public class Solution {
    public String LeftRotateString(String str,int n)
    {
        if (str == null || str.length()==0)
            return str;
        n = n % str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, str.length());
        return s2+s1;
    }
}

```
