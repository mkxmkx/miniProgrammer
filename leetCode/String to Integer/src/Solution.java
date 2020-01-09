/**
 * @Author: makexin
 * @Date: 2020/1/915:30
 */
public class Solution {
    public int myAtoi(String str)
    {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;
        long res = 0L;
        boolean flag = true;//默认是正数
        int index = 0;
        if (str.charAt(index) == '+')
            index++;
        else if (str.charAt(index) == '-')
        {
            flag = false;
            index++;
        }
        else if (str.charAt(index) < '0' || str.charAt(index) > '9')
            return 0;
        while (index < str.length())
        {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9')
                res = res * 10 + Integer.parseInt(String.valueOf(str.charAt(index)));
            else
                break;
            if (res > Integer.MAX_VALUE && flag)
                return Integer.MAX_VALUE;
            if (!flag && -res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
        }
        if (!flag)
            return (int)-res;
        return (int)res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.myAtoi("     -12"));
    }
}
