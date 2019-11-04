/**
 * @Author: makexin
 * @Date: 2019/11/411:14
 */
public class Solution {
    public String LeftRotateString(String str,int n)
    {
        if (str == null || str.length()==0)
            return str;
        n = n % str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n, str.length());
        return s2+s1;
    }
}
