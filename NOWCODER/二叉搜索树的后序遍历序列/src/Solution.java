/**
 * @Author: makexin
 * @Date: 2019/10/1413:39
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence)
    {
        if (sequence.length == 0)
            return false;
        boolean result = VerifySquenceOfBST(sequence, 0, sequence.length-1);
        return result;
    }
    public boolean VerifySquenceOfBST(int[] sequence, int leftIndex, int rightIndex)
    {
        if (leftIndex >= rightIndex)
            return true;
        int root = sequence[rightIndex];
        int i, midIndex = rightIndex;//从midIndex开始右边元素都大于root
        for (i = leftIndex; i<=rightIndex; i++)
        {
            if (sequence[i] > root)
            {
                midIndex = i;
                break;
            }
        }
        boolean leftResult = VerifySquenceOfBST(sequence, leftIndex, midIndex-1);
        boolean rightResult = false;
        boolean rightFlag = false;//记录右侧序列是否有比root大的元素
        for (i=midIndex; i<=rightIndex; i++)
        {
            if (sequence[i] < root)
            {
                rightFlag = true;
                break;
            }
        }
        if (rightFlag)
            return false; //右侧序列中存在比root小的元素，该序列不合理
        else
            rightResult = VerifySquenceOfBST(sequence, midIndex, rightIndex-1);

        if (leftResult && rightResult)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] array = {4,6,7,5};
        System.out.println(s.VerifySquenceOfBST(array));
    }
}
