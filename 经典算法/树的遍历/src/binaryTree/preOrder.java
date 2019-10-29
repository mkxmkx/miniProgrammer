package binaryTree;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:08
 * 二叉树先序遍历:根节点、左孩子、右孩子
 */
public class preOrder {
    public void preOrderTraversal(TreeNode root)
    {
        if (root!=null)
        {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}
