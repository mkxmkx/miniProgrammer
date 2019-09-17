/**
 * @Author: makexin
 * @Date: 2019/9/1720:49
 */
public class main {
    public static void main(String[] args)
    {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        Solution s = new Solution();
        TreeNode result = s.reConstructBinaryTree(pre, in);
    }
}
