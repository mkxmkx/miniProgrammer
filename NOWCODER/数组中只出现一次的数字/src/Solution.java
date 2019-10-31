import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/3114:38
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[])
    {
        Map<Integer, Integer> numOfArray = new HashMap<>();
        if (array==null || array.length == 0)
            return;

        for (int i = 0; i<array.length; i++)
        {
            if (numOfArray.containsKey(array[i]))
            {
                int num = numOfArray.get(array[i]);
                numOfArray.put(array[i], num+1);
            }
            else
                numOfArray.put(array[i], 1);
        }
        boolean flag = false;//num1是否填数字
        for (int x: numOfArray.keySet())
        {
            if (numOfArray.get(x)==1)
            {
                if (!flag)
                {
                    num1[0] = x;
                    flag = true;
                }
                else
                {
                    num2[0] = x;
                    break;
                }
            }

        }
    }
    public static void main(String[] args)
    {
        int[] array = {2,4,3,6,3,2,5,5};
        Solution s = new Solution();
        int[] num1 = {0}, num2 = {0};
        s.FindNumsAppearOnce(array, num1, num2);
    }
}
