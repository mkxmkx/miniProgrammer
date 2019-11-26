## 剑指offer——字符流中第一个不重复的字符
### 【题目描述】
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
### 【解题思路】
使用一个可以保证输入字符顺序不变的结构，遍历一遍字符流之后，即可得到按照原顺序不变，又知道每个字符出现了几次。然后再遍历得到的结构，从前往后，第一个只出现一次的字符即结果。
1、使用LinkedHashMap
char作为键，出现次数Integer作为值。
第二次遍历该map的键即可。
2、使用LinkedList
也可保证顺序不变。就是需要另外一个额外的结构记录已经出现过的重复字符。LinkedList中只保存按原顺序出现的只出现一次的字符。在第一次遍历字符流的时候，当字符已经在LinkedList中出现时，则移除该字符，同时保存到用于记录重复字符的结构中。对于之后的字符，先判断是否在重复字符结构中出现，若出现，则该字符仍为重复的。若没有出现，判断有没有在LinkedList中重复出现，若重复，则从LinkedList中移除该字符，并添加到重复字符的结构中。当都没有重复，则为只出现一次。
最后遍历完字符流之后，LinkedList中的元素全部都是只出现了一次。获得第一个元素即为结果。

### 【代码实现】

```java
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

```
