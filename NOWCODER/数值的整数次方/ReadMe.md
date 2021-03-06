剑指offer——数值的整数次方
##  【题目描述】
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0

## 【解题思路】
求整数次方，第一种方法就是循环，base不断乘。计算exponent次。

第二种方法：要求base的2n次方，可以两个base的n次方相乘。计算exponent/2次。
exp == 0时，返回1。exp == 1时，返回base。

注意：当次方为负数时，是该数正次方的倒数。

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/9/2521:17
 */
public class Solution {
    public double Power(double base, int exponent)
    {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        if (exponent > 0)
        {
            double result = Power(base, exponent/2);
//            double result = Power(base, exponent>>1);   //也可使用位运算，位运算右移1位，相当于除以2
            result *= result;
            if (exponent%2 != 0)
                return result * base;
            else
                return result;
        }
        else
        {
            exponent = -exponent;
            double result = Power(base, exponent/2);
            result *= result;
            if (exponent%2 != 0)
                return 1/(result * base);
            else
                return 1/result;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("result: " + s.Power(3,3));
    }
}
```

