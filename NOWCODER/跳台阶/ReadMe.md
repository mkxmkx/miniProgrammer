剑指offer——跳台阶
【题目描述】

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

## 【解题思路】
当剩余台阶数量大于等于1时，青蛙可选择跳上1级台阶。当剩余台阶数量大于等于2时，青蛙可选择跳上2级台阶。
因此，每次青蛙跳台阶时，当前所有可能的跳法为  跳1级台阶剩余跳法之和   加上   跳2级台阶剩余跳法之和。
与**斐波那契数列**的求解方法一样，使用**递归**的方法。

F(n) = F(n+1) + F(n+2)。其中F（n）代表当前已经跳了n个台阶的所有跳法。

结束条件：当已经跳上目标台阶，即 target - n == 0时，返回1。即当前跳法合理。
其中，是否可跳1个台阶或2个台阶在跳之前就判断。

## 【代码实现】

```
/**
 * @Author: makexin
 * @Date: 2019/9/2322:08
 */
public class Solution {
    public int JumpFloor(int target)
    {
        int result = step(0, target);
        return result;
    }

    public int step(int jump, int target)
    {
        if ((target - jump) == 0)
            return 1;
        int jump_1 = 0;
        int jump_2 = 0;
        if ((target - jump) >= 1)
            jump_1 = step(jump + 1, target);
        if ((target - jump) >= 2)
            jump_2 = step(jump + 2, target);
        return jump_1+jump_2;

    }
}

```
