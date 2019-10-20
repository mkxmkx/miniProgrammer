import java.util.ArrayList;

/**
 * @Author: makexin
 * @Date: 2019/10/2016:44
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length<k)
            return result;

        int i, j;
        for (i=0; i<k; i++)
        {
            for (j=input.length-1; j-i>0; j--)
            {
                if (input[j] < input[j-1])
                {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }

        for (i=0; i<k; i++)
        {
            result.add(input[i]);
        }
        return result;
    }
}
