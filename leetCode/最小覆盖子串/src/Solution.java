import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: makexin
 * @Date: 2020/5/2322:05
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> core = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        int i;
        for(i = 0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            core.put(c, core.getOrDefault(c, 0) + 1);
        }

        int l, r;
        int maxLen = s.length();
        l = 0;
        r = -1;
        int resLen = Integer.MAX_VALUE;
        int resL, resR;
        resL = resR = 0;
        while (r<maxLen)
        {
            r++;
            if(r<maxLen && core.containsKey(s.charAt(r)))
                cur.put(s.charAt(r), cur.getOrDefault(s.charAt(r), 0) + 1);
            while(check(core, cur) && l<=r)
            {
                if(r-l+1<resLen)
                {
                    resLen = r-l+1;
                    resL = l;
                    resR = r;
                }
                if(cur.containsKey(s.charAt(l)))
                    cur.put(s.charAt(l), cur.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        if (resLen == Integer.MAX_VALUE)
            return "";
        else
            return s.substring(resL,resR+1);
    }
    public boolean check(Map<Character, Integer> core, Map<Character, Integer> cur)
    {
        for(char c: core.keySet())
        {
            if(cur.containsKey(c))
            {
                if(cur.get(c)>=core.get(c))
                    continue;
                else
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}
