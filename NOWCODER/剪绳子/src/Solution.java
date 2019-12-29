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
