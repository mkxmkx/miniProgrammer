/**
 * @Author: makexin
 * @Date: 2019/10/1316:22
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        boolean flag[] = new boolean[pushA.length];
        int i,j;
        for (i=0; i<pushA.length; i++)
            flag[i] = false;


        for (i=0; i<popA.length; i++)
        {
            int pop = popA[i];
            for (j=0; j<pushA.length; j++)
            {
                if (pushA[j] == pop)//寻找到出栈元素在入栈序列的索引位置
                {

                    boolean checkResult = check(flag, j);//判断该元素是否不可出栈
                    if (checkResult)//该元素不可出栈
                        return false;
                    else//该元素可出栈
                    {
                        flag[j] = true;//标志数组设为true
                        break;
                    }
                }
            }
        }
        if (flagCheck(flag))
            return true;
        else
            return false;

    }

    public boolean check(boolean[] flag, int index)
    {
        //检测index之后的标志位，true之前是否有false。若有，则返回true。否则返回false
        int i = index+1;
        boolean falseFlag = false;
        for (; i<flag.length; i++)
        {
            if (flag[i] == false)
            {
                falseFlag = true;
            }
            else
            {
                if (falseFlag)//如果在true之前存在false，则说明该出栈序列不正确
                {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean flagCheck(boolean[] flag)//判断是否所有入栈元素都出栈了
    {
        for (boolean temp: flag) {
            if (temp == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(new Solution().IsPopOrder(push, pop));
    }
}
