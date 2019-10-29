package binaryTree;

import java.util.Stack;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:24
 */
public class middleOrder {
    public void middleOrderTraversal(TreeNode root)
    {
        if (root!=null)
        {
            middleOrderTraversal(root.left);
            System.out.println(root.val);
            middleOrderTraversal(root.right);
        }
    }
    // 非递归中序遍历
    //当考查节点为空时，从栈中弹出的时候再进行输出(永远先考虑左子树，直到左子树为空才访问根节点)。
    public void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {//当从栈中弹出元素时，再打印该结点。然后遍历右子树
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }
}
