import java.util.HashSet;
import java.util.Set;

/**
 * @Author: makexin
 * @Date: 2019/11/1219:00
 */
public class Solution {
    public boolean isContinuous(int [] numbers)
    {
        boolean result = false;
        if (numbers==null || numbers.length ==0)
            return result;
        Set set = new HashSet();
        int maxNum=0, minNum = 13;//因为扑克牌的取值范围为1--13.所以初始最大值设为0，所有扑克牌数值都比该值大
        //最小值设为最大，所有扑克牌数值都比该值小。
        boolean flag = true;
        for (int i = 0; i<numbers.length; i++)
        {
            if (numbers[i]!=0)
            {
                if (set.contains(numbers[i]))
                {
                    flag = false;
                    break;
                }
                set.add(numbers[i]);
                if (numbers[i] > maxNum)
                    maxNum = numbers[i];
                if (numbers[i] < minNum)
                    minNum = numbers[i];
            }
        }
        if (!flag)
            result = false;
        else
        {
            int diff = maxNum - minNum;
            if (diff>4)
                result = false;
            else
                result = true;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] num = {0, 2, 3, 4, 6};
        Solution s = new Solution();
        System.out.println(s.isContinuous(num));
    }
}
