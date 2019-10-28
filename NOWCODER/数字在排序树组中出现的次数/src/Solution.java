/**
 * @Author: makexin
 * @Date: 2019/10/2819:51
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k)
    {
        int result = 0;
        if (array == null || array.length ==0)
            return result;
        boolean ascend = true;//数组是升序还是降序
        if (array[0] > array[array.length-1])
            ascend = false;
        int i=0, j=array.length-1;
        int mid = 0;
        while (i<=j)
        {
            mid = (i+j)/2;
            if (array[mid] == k)
                break;
            if (ascend)
            {
                if (array[mid] > k)
                    j=mid-1;
                else
                    i = mid+1;
            }
            else
            {
                if (array[mid] > k)
                    i = mid+1;
                else
                    j = mid-1;
            }
        }
        if (array[mid]!=k)
            return result;
        else {
            result++;
            i = mid-1;
            while (i>=0)//要先判断是否越界
            {
                if (array[i] == k)
                {
                    result++;
                    i--;
                }
                else
                    break;
            }
            j=mid+1;
            while (j<array.length)//要先判断是否越界
            {
                if (array[j] == k) {
                    result++;
                    j++;
                }
                else
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {3,3,3,3,4,5};
        System.out.println(new Solution().GetNumberOfK(array, 3));
    }
}
