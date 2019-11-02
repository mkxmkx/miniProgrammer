import java.util.ArrayList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/219:14
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum<3)
            return result;
        int start = 1, end = 1, mid = sum/2;
        int sumResult = 1;
        while (start<=mid || end<mid)
        {
            if (sumResult == sum)
            {
                result.add(saveList(start, end));
                end++;
                sumResult = sumResult - start + end;
                start++;
            }
            else
            {
                if (sumResult < sum)
                {
                    end++;
                    sumResult+=end;
                }
                else
                {
                    sumResult -= start;
                    start++;
                }

            }
        }
        return result;
    }
    public ArrayList<Integer> saveList(int start, int end)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i<=end; i++)
            result.add(i);
        return result;
    }
}
