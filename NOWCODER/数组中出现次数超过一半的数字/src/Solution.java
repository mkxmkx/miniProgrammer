import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/1921:21
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array)
    {
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        for (i=0; i<len; i++)
        {
            if (map.containsKey(array[i]))
            {
                int value = map.get(array[i]);
                map.put(array[i], value+1);
            }
            else
                map.put(array[i], 1);
        }

        int result = 0;
        for (Integer key : map.keySet())
        {
            if (map.get(key) > (len/2))
                result = key;
        }
        return result;
    }

}
