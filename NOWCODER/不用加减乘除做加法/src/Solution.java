/**
 * @Author: makexin
 * @Date: 2019/11/1521:12
 */
public class Solution {
    public int Add(int num1,int num2)
    {
        while (num2!=0)
        {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;//进位值
            num1 = temp;
        }
        return num1;
    }
}
