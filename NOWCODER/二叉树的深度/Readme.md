## 剑指offer——二叉树的深度
## 【题目描述】
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

## 【解题思路】
深度优先遍历

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/10/299:52
 */
public class Solution {
    public int TreeDepth(TreeNode root)
    {
        int maxDepth = 0;
        if (root==null)
            return maxDepth;
        maxDepth ++;//root不为null，则深度加一
        int left = maxDepth + TreeDepth(root.left);
        int right = maxDepth + TreeDepth(root.right);
        if (left>right)
            return left;
        else
            return right;
    }
}

```
