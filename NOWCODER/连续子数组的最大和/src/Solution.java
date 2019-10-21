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
