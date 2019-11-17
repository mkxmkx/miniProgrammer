/**
 * @Author: makexin
 * @Date: 2019/11/1721:04
 */
public class Solution {
    public int StrToInt(String str)
    {
        if (str.length()==0)
            return 0;
        int flag = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '+')
            flag = 1;
        else if (chars[0] == '-')
            flag = 2;
        int start = flag>0? 1: 0;
        long result = 0;
        while (start < chars.length)
        {
            if (chars[start] > '9' || chars[start] < '0')
            {
                return 0;
            }
            result = result * 10 + (chars[start]-'0');

            start++;
        }
        result = flag==2? -result: result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }

    public static void main(String[] args)
    {
        String s = "-123";
        Solution sol = new Solution();
        System.out.println(sol.StrToInt(s));
    }
}
