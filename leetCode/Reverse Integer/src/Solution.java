/**
 * @Author: makexin
 * @Date: 2020/1/89:57
 */
public class Solution {
    public int reverse(int x)
    {
        if (x == 0)
            return x;
        boolean flag = true;//默认为正数
        if (x < 0)
            flag = false;
        x = Math.abs(x);
        long res = 0;
        while (x>0)
        {
            int temp = x%10;
            res = res * 10 +temp;
            if (res>Integer.MAX_VALUE || res<Integer.MIN_VALUE)
                return 0;
            x = x/10;
        }
        if (!flag)
            res = -res;
        return (int)res;
    }
}
