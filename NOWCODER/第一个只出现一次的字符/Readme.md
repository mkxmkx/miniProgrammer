##  第一个只出现一次的字符
## 【题目描述】
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

## 【解题思路】
需要记录三个数，每个字符对应出现的次数，每个字符在原字符串中的位置。因为都具有一一对应关系，所以使用map来存储。
第一个map：因为需要是第一个出现一次的字符，因此在计算次数的同时需保持相对顺序不变。使用LinkedHashMap。key为字符，value为出现的次数。
第二个map：用来保存每个字符在原字符串中第一次出现的索引位置。这个不需要保持加进去值的顺序，HashMap即可。在最终结果中直接检索key就可以。

## 【代码实现】

```java
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

```
