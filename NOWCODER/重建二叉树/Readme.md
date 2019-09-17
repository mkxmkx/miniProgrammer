剑指offer——重建二叉树

## 【题目描述】
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

## 【解题思路】
首先复习一下二叉树的前序遍历、中序遍历、后序遍历。
前序遍历：根节点，左子树，右子树
中序遍历：左子树，根节点，右子树
后序遍历：左子树，右子树，根节点

由于前序遍历第一个节点是根节点，因此可以根据前序遍历结果确定根节点的值。在中序遍历序列中，根节点索引位置左侧所有值都是在左子树上，同理，右侧所有值都是在右子树上。人工去重建二叉树的话就是按照先找根节点，然后再根据中序遍历结果确定左右子树的值。然后再分别在左右子树中再找根节点。

程序实现的思路就是使用**递归**的方法。
每次递归方法内确定根节点的值，以及左子树、右子树的前序、中序遍历序列的值范围。
因此，输入包含：前序遍历序列，此次前序序列的start索引，end索引；中序遍历序列，此次中序序列的start索引，end索引。

## 【重点】
学会**递归**的思想呀
## 【代码实现】
### 二叉树定义

```
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
    }
}
```
## 递归重建二叉树

```
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in)
    {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public TreeNode construct(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end)
    {
        if (p_start > p_end)
            return null;
        if (i_start > i_end)
            return null;

        int val = pre[p_start];   //根节点值
        int index = 0;
        boolean index_flag = false;
        TreeNode node = new TreeNode(val);
        for (int i = i_start; i<=i_end; i++)
        {
            if(in[i] == val)
            {
                index = i;   //确定根节点在中序遍历比列中的位置
                index_flag = true;
                break;
            }
        }
        if (index_flag == true)
        {
            node.left = construct(pre, p_start+1, p_start+index-i_start, in, i_start, index-1);   //左子树递归
            node.right = construct(pre, p_start+index-i_start+1, p_end, in, index+1, i_end);   //右子树递归
        }

        return node;
    }
}
```
