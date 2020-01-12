## leetcode——Container With Most Water
### 【题目描述】
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

### 【解题思路】
贪心法
因为面积是长乘宽，所以先保证一个是最优的，然后贪心另外一个。即可以先使得长最长，然后贪心高度。
先使得长最长，即整个数组的面积。然后提高高度，即逐渐缩减范围，寻找高度最大，面积更大的范围。直到两端相遇。

假设先选取的是两端之间的两条线段，这样这两条线段之间的距离是最大的，长度是给定数组的长度减1。那么在这种情况下要容纳更多的水，由于宽度已经是最大的了，只能想法提高线段的高度，这种情况下如果两端是左边比右边高，那么将右边的指针左移，然后这右回到了初始的问题，这样不断移动下去到左右指针相等为止。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2020/1/1210:52
 */
public class Solution {
    public int maxArea(int[] height)
    {
        int res, i, j;
        i = 0;
        j = height.length-1;
        res = 0;
        while (i<j)
        {
            int temp = Math.min(height[i], height[j]) * (j-i);
            if (temp > res)
                res = temp;
            if (height[i] > height[j])
                j--;
            else
                i++;
        }
        return res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] array = {1, 2, 4, 3};
        System.out.println(s.maxArea(array));
    }
}

```
