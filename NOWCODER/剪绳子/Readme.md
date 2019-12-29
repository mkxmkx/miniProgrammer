## 剑指offer——剪绳子
### 【题目描述】
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
输入描述:
输入一个数n，意义见题面。（2 <= n <= 60）
输出描述:
输出答案。
示例1
输入
8
输出
18

### 【解题思路】
问题是求最优解；
整体的问题的最优解是依赖各个子问题的最优解；
子问题之间还有互相重叠的更小的子问题；
为避免子问题的重复计算，我们存储子问题的最优解。从上往下分析问题，从下往上求解问题。
上面的几个条件可以看出，属于动态规划问题。

定义函数f(n)表示为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
对于第一刀，我们有n-1种可能的选择，可推导出f(n)=max{f(i)*f(n-i)};
很明显这是一个从上至下的递归，但是这个递归存在很多重复的计算，所以使用至下而上的动态规划，将子问题的最优解保存。
注意绳子剪成ix(n-i)和(n-i)xi是相同的；

### 【代码实现】

```java
import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/12/2921:48
 */
public class Solution {
    public int cutRope(int target)
    {
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        int[] mul = new int[target+1];
        mul[0] = 0;
        mul[1] = 1;
        mul[2] = 2;
        mul[3] = 3;
        int max = 0;
        for (int i = 4; i<=target; i++)
        {
            for (int j = 1; j<=i/2; j++)
            {
                int temp = mul[j] * mul[i-j];
                if (temp > max)
                    max = temp;
            }
            mul[i] = max;
        }
        return mul[target];
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.cutRope(4));
    }
}

```