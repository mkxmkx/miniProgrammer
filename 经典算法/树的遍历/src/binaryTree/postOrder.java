package binaryTree;

import java.util.Stack;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:33
 */
public class postOrder {
    public void postOrderTraversal(TreeNode root)
    {
        if (root!=null)
        {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }
    // 非递归后序遍历
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;//记录上次访问的右孩子节点，用来判断一个节点的右子树是否都访问完。
        //若右子树访问完，则可以打印该节点了
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {//左子树一直访问到叶节点
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) { //仅在右子树中判断标志位
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;//
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }
}
