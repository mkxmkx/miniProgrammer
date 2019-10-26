/**
 * @Author: makexin
 * @Date: 2019/10/2621:17
 */
public class Solution {
    public int InversePairs(int [] array)
    {
        if (array == null || array.length == 0)
            return 0;
        int result = divid(array, 0, array.length-1);
        return result%1000000007;
    }
    public int divid(int[] array, int left, int right)
    {
        if (left<right)
        {
            int mid = (left + right)/2;
            int leftResult = divid(array, left, mid);
            int rightResult = divid(array, mid+1, right);
            int mergeResult = merge(array, left, mid, right);
            return (leftResult + rightResult + mergeResult)%1000000007;
        }
        return 0;
    }
    public int merge(int[] array, int left, int mid, int right)
    {
        int i=mid, j = right;
        int mergeResult = 0;
        int[] temp = new int[right-left+1];
        int k = right-left;
        while (i>=left && j>mid)
        {
            if (array[i] > array[j])
            {
                mergeResult += (j-mid);
                temp[k] = array[i];
                k--;
                i--;
                if (mergeResult>1000000007)
                    mergeResult %= 1000000007;
            }
            else
            {
                temp[k] = array[j];
                k--;
                j--;
            }
        }
        if (j>mid)//说明后面的数组还有剩余的元素，这些元素全都是比较小的元素。
        {
            while (j>mid)
            {
                temp[k] = array[j];
                k--;
                j--;
            }
        }
        if (i>=left)//说明前面的数组还剩一些比较小的元素
        {
            while (i>=left)
            {
                temp[k] = array[i];
                k--;
                i--;
            }
        }
        k = 0;
        for (i=left; i<=right; i++, k++)
            array[i] = temp[k];
        return mergeResult%1000000007;
    }

    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,0};
        System.out.println(new Solution().InversePairs(array));
    }
}
