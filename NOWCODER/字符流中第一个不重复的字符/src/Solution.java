import java.util.*;

/**
 * @Author: makexin
 * @Date: 2019/11/2611:12
 */
public class Solution {
    Map<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if (map.containsKey(ch))
            map.put(ch, map.get(ch)+1);
        else
            map.put(ch, 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        for (char c : map.keySet())
        {
            if (map.get(c) == 1)
            {
                result = c;
                break;
            }
        }
        return result;
    }
}
