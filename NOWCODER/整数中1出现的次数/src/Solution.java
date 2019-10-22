/**
 * @Author: makexin
 * @Date: 2019/10/2221:41
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n)
    {
        int result = 0;
        int i;
        for (i=1; i<=n; i++)
        {
            int m = i;
            do {
                int x = m%10;
                if (x==1)
                    result += 1;
                m = m/10;
            }while (m!=0);
        }
        return result;
    }
    public int NumberOf1Between1AndN_Solution_v2(int n)
    {
        int count = 0;
        for (int i=1; i<=n; i *= 10)
        {
            int a = n/i, b=n%i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a+8)/10*i + ((a%10==1)?b+1:0);
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution().NumberOf1Between1AndN_Solution(10));
    }
}
