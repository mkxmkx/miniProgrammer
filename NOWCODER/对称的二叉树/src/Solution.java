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
