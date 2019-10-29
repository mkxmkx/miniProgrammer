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
