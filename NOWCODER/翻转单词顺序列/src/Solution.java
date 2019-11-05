import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/511:07
 */
public class Solution {
    public String ReverseSentence(String str)
    {
        if (str.trim().length()==0)
            return str;
        String[] words = str.split(" ");
        String result = "";
        for (int i = words.length-1; i>=0; i--)
        {
            result += words[i];
            if (i != 0)
                result += " ";
        }
        return result;
    }
    public static void main(String[] args)
    {
        String string = " ";
        Solution s = new Solution();
        System.out.println(s.ReverseSentence(string));
    }
}
