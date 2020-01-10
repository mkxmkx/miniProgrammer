/**
 * @Author: makexin
 * @Date: 2020/1/1022:28
 */
public class Solution {
    public boolean isPalindrome(int x)
    {
        if (x < 0 || x%10 == 0 && x!=0)
            return false;
        int res = 0;
        while (res<x)
        {
            res = res * 10 + x%10;
            x = x/10;
        }
        return x == res || x == res/10;
    }
}
