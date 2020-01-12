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
