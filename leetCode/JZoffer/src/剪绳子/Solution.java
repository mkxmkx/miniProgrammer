package 剪绳子;

/**
 * @Author: makexin
 * @Date: 2020/7/13 9:34
 */
public class Solution {
    public int cutRope(int target)
    {
        if(target == 2)
            return 1;
        if(target == 3)
            return 2;
        int[] res = new int[target+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        for(int i = 4; i<=target; i++)
        {
            int temp = 0;
            int max = 0;
            for(int j = 1; j<=i/2; j++)
            {
                temp = res[j] * res[i-j];
                if(temp>max)
                    max = temp;
            }
            res[i] = max;
        }
        return res[target];
    }
}
