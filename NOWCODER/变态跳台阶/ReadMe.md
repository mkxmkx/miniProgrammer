剑指offer——变态跳台阶
【题目描述】

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法

## 【解题思路】
青蛙要跳上一个n级的台阶，总共有F（n）种跳法，F(n) = F(n-1) + F(n-2)+ ...... + F(n-n)。即跳上一个n级的台阶，第一步跳一个台阶剩余n-1个台阶的跳法   加上   第一步跳两个台阶剩余n-2个台阶的跳法 直到一步跳n个台阶F(n-n) = F(0) = 1，因为一步跳n个台阶只有1中跳法。
F(n) = F(n-1) + F(n-2)+ ...... + F(n-n)
F(n-1) = F(n-2) + F(n-3)+ ...... + F(n-n)
将两个式子相减，可得式子**F(n) = 2 * F(n-1)**
因此可使用**递归**的方法求解该题。
其中 F(0) = 1， F(1) = 1

## 【代码实现】

```
/**
 * @Author: makexin
 * @Date: 2019/9/249:43
 */
public class Solution {
    public int JumpFloorII(int target)
    {
        if (target == 0 || target == 1)
            return 1;
        return 2*JumpFloorII(target - 1);
    }
}

```
