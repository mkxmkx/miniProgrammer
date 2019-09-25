import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/9/2511:47
 */
public class Solution {
    public int NumberOf1(int n)
    {
        int m = n;
        if (n<0)
            m = -n;

        int[] result = new int[32];
        int j = 0;
        do{
            int x = m % 2;
            m = m / 2;
            result[j] = x;
            j++;
        }while (m!=0);

        if (n<0)
        {
            for (int i = 0; i<result.length; i++) //反码
            {
                if (result[i] == 1)
                    result[i] = 0;
                else
                    result[i] = 1;
            }

            for (int i = 0; i<result.length; i++)//反码加1
            {
                result[i] = result[i] + 1;
                if (result[i] == 1)
                    break;
                else
                    result[i] = 0;
            }
            result[31] = 1;  //符号位。符号位不变
        }

        int count = 0;
        for (Integer i: result)
        {
            if (i == 1)
                count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("result: " + s.NumberOf1(-2147483648));
    }
}
