package binaryTree;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:07
 */
public class TreeNode {
    public int val;//都定义为public是为了在main函数中可以直接赋值
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val)
    {
        this.val = val;
    }
}
