## 剑指offer——对称的二叉树
### 【题目描述】
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3

### 【解题思路】
判断二叉树是否对称，分别定义两个指针指向根节点的左右孩子节点。
然后递归的判断左右孩子节点是否对称。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/12/120:21
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        boolean result = symmetric(left, right);
        return result;
    }

    boolean symmetric(TreeNode left, TreeNode right)
    {
        if (left==null && right==null)
            return true;
        if (left!=null && right==null)
            return false;
        if (left==null && right!=null)
            return false;
        boolean mid = left.val==right.val? true: false;
        boolean l = symmetric(left.left, right.right);
        boolean r = symmetric(left.right, right.left);
        return mid && l && r;
    }
}

```
﻿﻿