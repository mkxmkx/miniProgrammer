import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/1821:23
 */
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication)
    {
        if (numbers == null || numbers.length == 0 )
            return false;
        List<Integer> numSet = new ArrayList<>();
        boolean result = false;
        for (int i = 0; i<length; i++)
        {
            if (numSet.contains(numbers[i]))
            {
                duplication[0] = numbers[i];
                result = true;
                break;
            }
            else
            {
                numSet.add(numbers[i]);
            }
        }
        return result;
    }
}
