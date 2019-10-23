import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/10/2313:24
 */
public class Solution {
    public String PrintMinNumber(int [] numbers)
    {
        String[] strNumber = new String[numbers.length];
        int i;
        for (i=0; i<numbers.length; i++)
            strNumber[i] = String.valueOf(numbers[i]);
        int j;
        for (i=0; i<numbers.length-1; i++)
        {
            for(j=numbers.length-1; j>i; j--)
            {
                String str1 = strNumber[j-1] + strNumber[j];
                String str2 = strNumber[j] + strNumber[j-1];
                if (str1.compareTo(str2) > 0)
                {
                    String temp = strNumber[j-1];
                    strNumber[j-1] = strNumber[j];
                    strNumber[j] = temp;
                }
            }
        }
        String result = "";
        for (String tempStr: strNumber)
            result += tempStr;
        return result;
    }

    public static void main(String[] args)
    {
        int[] number = {3, 32, 321};
        System.out.println(new Solution().PrintMinNumber(number));
    }
}
