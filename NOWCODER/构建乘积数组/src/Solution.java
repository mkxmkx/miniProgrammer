/**
 * @Author: makexin
 * @Date: 2019/11/1920:21
 */
public class Solution {
    public int[] multiply(int[] A)
    {
        if (A == null || A.length < 2)//不合法输入
            return null;
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i=1; i<A.length; i++)
        {
            B[i] = B[i-1] * A[i-1]; //左半部分规律
        }
        int temp = 1;
        for (int i = A.length-2; i>=0; i--)
        {
            temp = temp * A[i+1];//右半部分规律
            B[i] = B[i] * temp;
        }
        return B;
    }
}
