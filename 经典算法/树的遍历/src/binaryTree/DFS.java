package binaryTree;

import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:52
 * 深度优先遍历：沿着树的深度遍历树的节点。二叉树的先序、中序、后序遍历都属于深度优先遍历DFS
 */
public class DFS {
    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(TreeNode root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.val+"    ");
            if(node.right!=null){
                stack.push(node.right);//先入右子树
            }
            if(node.left!=null){
                stack.push(node.left);//后入左子树
            }
        }
        System.out.print("\n");
    }
}
