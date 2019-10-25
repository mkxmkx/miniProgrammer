import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/2510:44
 */
public class Solution {
    public int FirstNotRepeatingChar(String str)
    {
        Map<Character, Long> strMap = new LinkedHashMap<Character, Long>();
        Map<Character, Integer> indexMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length; i++)
        {
            if (strMap.containsKey(chars[i]))
            {
                Long num = strMap.get(chars[i]);
                num ++;
                strMap.put(chars[i], num);
            }
            else
            {
                strMap.put(chars[i], 1L);
                indexMap.put(chars[i], i);
            }

        }
        int result = -1;
        for (char c: strMap.keySet())
        {
            if (strMap.get(c).equals(1L))
            {
                result = indexMap.get(c);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String s = "google";
        System.out.println(new Solution().FirstNotRepeatingChar(s));
    }
}
