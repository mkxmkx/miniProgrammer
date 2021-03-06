## 剑指offer——二叉搜索树的后序遍历序列
## 【题目描述】
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

## 【解题思路】
**二叉搜索树** 是以二叉树的形式组织。其具有以下性质。
1、左子树的节点值都小于根节点值
2、右子树的节点值都大于根节点值

**后序遍历**：左孩子、右孩子、根节点

根据后序遍历顺序可知，根节点位于序列的最后一个值。而根据二叉搜索树的性质，后序遍历序列可分为两部分，前半部分值都比根节点值小，后半部分值都比根节点值大。

根据以上性质可得出解题思路：
采用分治法，每次使用根节点作为衡量基准，从当前序列第一个值（leftIndex）开始比较，找到比根节点值大的节点位置作为分界线（midIndex）。因为是从前到后找比根节点大的值，所以midIndex初始化为rightIndex。
找到分界点之后，分治判断左孩子是否为一个二叉搜索树。然后首先需判断右孩子值是否都在合理范围内，即值都比根节点值大。当符合值范围，进而判断右孩子是否为一个二叉搜索树。否则说明右孩子不可能是一个二叉搜索树，返回false。

## 【代码实现】

```java
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

```
