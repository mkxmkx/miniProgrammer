/**
 * @Author: makexin
 * @Date: 2019/9/2714:52
 */
public class Solution {
    public void reOrderArray(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++)
            {
                if (array[j]%2==0 && array[j+1]%2!=0)
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7};
        Solution solution = new Solution();
        solution.reOrderArray(array);
    }
}
