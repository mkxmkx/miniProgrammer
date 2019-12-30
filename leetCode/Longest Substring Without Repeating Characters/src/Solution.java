/**
 * @Author: makexin
 * @Date: 2019/12/3022:13
 */
public class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length()<2)
            return s.length();
        int maxlen = 1, start = 0, end = 1;
        String curStr;
        while (end < s.length())
        {
            curStr = s.substring(start, end);
            if (curStr.contains(String.valueOf(s.charAt(end))))
            {
                start = start + curStr.indexOf(s.charAt(end)) + 1;
            }
            int len = end - start + 1;
            if (len > maxlen)
                maxlen = len;
            end++;
        }
        return maxlen;
    }
}
