/**
 * @Author: makexin
 * @Date: 2020/1/610:49
 */
public class Solution {
    public String longestPalindrome(String s)
    {
        if(s == null || s.length()==0)
            return s;
        int maxLen;
        String res = s.substring(0,1);
        maxLen = 1;
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            int index = i+1;
            int end = s.indexOf(c, index);
            while (end!=-1 && index<=s.length())
            {
                boolean flag = checkPalindrome(s.substring(i, end+1));
                if (flag && (end-i+1) > maxLen)
                {
                    maxLen = end-i+1;
                    res = s.substring(i, end+1);
                }
                index = end+1;
                end = s.indexOf(c, index);
            }
        }
        return res;
    }

    boolean checkPalindrome(String s)
    {
        int start, end;
        start = 0;
        end = s.length()-1;
        while (start<end)
        {
            if (s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
                break;
        }
        if (start<end)
            return false;
        else
            return true;
    }

    public String longestPalindrome_v2(String s)
    {
       if (s == null || s.length()== 0)
           return s;
       boolean[][] flag = new boolean[s.length()][s.length()];
       int maxlen = 0;
       String res = s.substring(0,1);
       for (int j = 0; j<s.length(); j++)//i代表字符串的开始索引，j代表字符串的结束索引
       {
           int i = 0;
           flag[j][j] = true;//单个元素是回文
           for (;i<j; i++)
           {
               flag[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i<2||j>0&&flag[i+1][j-1]);
               //串的长度小于等于2时，肯定是回文子串，如 1，1，就是回文串。
               //如果长度大于2时，则需要判断f[i+1][j-1]是不是回文。
               if (flag[i][j] && (j-i+1)>maxlen)
               {
                   maxlen = j-i+1;
                   res = s.substring(i,j+1);
               }

           }
       }
       return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome_v2("a"));
    }
}
