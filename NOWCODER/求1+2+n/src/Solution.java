/**
 * @Author: makexin
 * @Date: 2019/11/1418:39
 */
public class Solution {
    public int Sum_Solution(int n)
    {
        int sum = n;
        boolean flag = ((sum > 0) && (sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}
