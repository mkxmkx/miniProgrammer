import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/11/320:04
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2)
            return result;
        int left, right;
        left = right = array[array.length-1];//初始为最大值
        Map<Integer, Integer> arrayMap = new HashMap<>();
        for (int i=0; i<array.length; i++)
        {
            arrayMap.put(array[i], 1);
        }
        for (int i = 0; array[i] < sum/2; i++)
        {
            int another = sum - array[i];
            if (arrayMap.containsKey(another))
            {
                int last = left * right;
                int current = another * array[i];
                if (current < last)
                {
                    left = array[i];
                    right = another;
                }
            }
        }
        if (left==right)//即不存在正确解
            return result;
        result.add(left);
        result.add(right);
        return result;
    }

    //思路二，类似滑动窗口法
    public ArrayList<Integer> FindNumbersWithSum_v2(int [] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length<2)
            return result;
        int left = 0, right = array.length-1;
        int bestLeft, bestRight;
        bestLeft = bestRight = array.length-1;
        while (left<right)
        {
            if (array[left] + array[right] == sum)
            {
                int last = array[bestLeft] * array[bestRight];
                int current = array[left] * array[right];
                if (current < last)
                {
                    bestLeft = left;
                    bestRight = right;
                }
                left++;
                right--;
            }
            else
            {
                if (array[left] + array[right] < sum)
                {
                    left++;
                }
                else
                    right--;
            }
        }
        if (bestLeft == bestRight && bestLeft == array.length-1)
            return result;
        result.add(array[bestLeft]);
        result.add(array[bestRight]);
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {1,2,4,7,11,15};
        Solution s = new Solution();
        System.out.println(s.FindNumbersWithSum_v2(array, 15));
    }
}
