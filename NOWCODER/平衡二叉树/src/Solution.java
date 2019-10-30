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
