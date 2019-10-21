## 剑指offer——连续子数组的最大和
## 【题目描述】
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

## 【解题思路】
求连续子数组的最大和，因此从前到后遍历一遍，在遍历数组的时候就比较记录当前的最大和。maxSum的值是比较f(i)+array[i] 和array[i] 和maxSum三者的最大值。f(i)是f(i)+array[i] 和array[i]的最大值。

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/10/2122:28
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array)
    {
        if (array == null || array.length == 0)
            return 0;
        int i, maxSum = array[0];
        int currentSum = 0;
        for (i=0; i<array.length; i++)
        {
            currentSum += array[i];
            if (currentSum>maxSum)
                maxSum = currentSum;
            if (currentSum < array[i])
            {
                currentSum = array[i];
                if (currentSum>maxSum)//再次判断一下重新赋值之后的是否符合最大值要求
                    maxSum = currentSum;
            }

        }
        return maxSum;
    }
    public static void main(String[] args)
    {
        int[] array = {-2, -8, -1, -5, -9};
        System.out.println(new Solution().FindGreatestSumOfSubArray(array));
    }
}

```
