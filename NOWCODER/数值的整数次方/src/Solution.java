/**
 * @Author: makexin
 * @Date: 2019/9/2521:17
 */
public class Solution {
    public double Power(double base, int exponent)
    {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        if (exponent > 0)
        {
            double result = Power(base, exponent/2);
//            double result = Power(base, exponent>>1);   //也可使用位运算，位运算右移1位，相当于除以2
            result *= result;
            if (exponent%2 != 0)
                return result * base;
            else
                return result;
        }
        else
        {
            exponent = -exponent;
            double result = Power(base, exponent/2);
            result *= result;
            if (exponent%2 != 0)
                return 1/(result * base);
            else
                return 1/result;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("result: " + s.Power(3,3));
    }
}
