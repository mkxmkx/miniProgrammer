import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2020/1/79:57
 */
public class Solution {
    public String convert(String s, int numRows)
    {
        if (s == null ||s.length() == 0)
            return s;
        if (numRows == 1)
            return s;
        Map<Integer, String> numS = new HashMap<>();
        for (int i=0; i<numRows; i++)
        {
            numS.put(i, "");
        }
        int index = 0;
        boolean flag = true;//序号是否增加
        int i = 0;
        while (index<s.length())
        {
            numS.put(i,numS.get(i)+s.charAt(index));
            if (flag && i==numRows-1)
                flag = false;
            if (!flag && i==0)
                flag = true;
            if (flag)
                i++;
            else
                i--;
            index++;
        }
        String res = "";
        for (i = 0; i<numRows; i++)
            res += numS.get(i);
        return res;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    }
}
