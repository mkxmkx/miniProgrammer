## 剑指offer——不用加减乘除做加法
### 【题目描述】
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

### 【解题思路】
复习一下： 与运算，或运算，异或运算，取反运算。（都是在二进制基础上）
与运算&：都为1是才为1。
或运算|：有一个为1，则为1.
异或运算^：不同为1
取反运算~：按位取反

本题解题思路：
根据二进制运算规律。以7+9为例
第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。 继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/1521:12
 */
public class Solution {
    public int Add(int num1,int num2)
    {
        while (num2!=0)
        {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;//进位值
            num1 = temp;
        }
        return num1;
    }
}

```