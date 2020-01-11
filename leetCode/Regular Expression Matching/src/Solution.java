/**
 * @Author: makexin
 * @Date: 2020/1/1117:03
 */
public class Solution {
    public boolean isMatch(String s, String p)
    {
        if (s.length() == 0 && p.length() == 0)
            return true;
        int strIndex = 0, patIndex = 0;
        return check(s, strIndex, p, patIndex);
    }
    boolean check(String s, int strIndex, String p, int patIndex)
    {
        //不用以s是否到结尾判断结束，只需一直判断pattern是否匹配结束，当pattern到结尾，但是s还没结束，则为false
        //在匹配的时候，以s未到结尾作为一个限制条件
        if (s.length() == strIndex && p.length() == patIndex)
            return true;
        if (s.length() != strIndex && p.length() == patIndex)//pattern先匹配完，失败
            return false;
        if (patIndex+1 < p.length() && p.charAt(patIndex+1) == '*')
        {
            if (strIndex != s.length() && (s.charAt(strIndex) == p.charAt(patIndex) || p.charAt(patIndex) == '.'))
                return check(s, strIndex+1, p, patIndex)
                        || check(s, strIndex+1, p, patIndex+2)
                        || check(s, strIndex, p, patIndex+2);//第三种情况，也可以什么都不匹配
            else
                return check(s, strIndex, p, patIndex+2);
        }
        if (strIndex != s.length() && (p.charAt(patIndex) == s.charAt(strIndex) || p.charAt(patIndex) == '.'))
            return check(s, strIndex+1, p, patIndex+1);
        return false;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.isMatch("",".*"));
    }
}
