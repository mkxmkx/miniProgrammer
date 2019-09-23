/**
 * @Author: makexin
 * @Date: 2019/9/239:42
 */
public class Solution {
    public int Fibonacci(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
