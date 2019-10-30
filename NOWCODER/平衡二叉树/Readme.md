## 剑指offer——平衡二叉树
## 【题目描述】
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

## 【解题思路】
**平衡二叉树**：平衡二叉树具有以下性质：
它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

所以判断一个二叉树是不是一个平衡二叉树，需要先判断其左子树是否为平衡二叉树，再判断右子树是否为平衡二叉树。然后判断左右子树的高度差是否不超过1.

以上的判断思路跟二叉树的后序遍历一样，都是先判断左子树，再判断右子树，最后以根节点为中心判断。
由于判断是否为平衡二叉树需计算深度，所以递归的时候返回的是节点的深度。当已经判断出一个子树不是平衡二叉树时，返回一个可以标志非平衡二叉树的结果，然后再后序的判断中直接认定不是平衡二叉树。

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/10/3018:52
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root)
    {
        int result = depth(root);
        if (result==-1)
            return false;
        else
            return true;

    }
    public int depth(TreeNode root)
    {
        if (root == null)
            return 0;
        int depthOfRoot = 1;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right) > 1 || left==-1 || right==-1)//不符合平衡二叉树条件，-1代表子树不是平衡二叉树
            return -1;
        return depthOfRoot + Math.max(left, right);
    }
}

```
