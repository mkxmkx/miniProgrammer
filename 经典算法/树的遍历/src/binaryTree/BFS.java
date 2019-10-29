package binaryTree;

import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/2910:58
 * 广度优先遍历，沿着树的宽度依次遍历树的每个节点。借助于队列
 */
public class BFS {
    public void bfs(TreeNode root)
    {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null)
            return;
        queue.addLast(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.removeFirst();
            System.out.println(node.val);
            if (node.left!=null)
                queue.addLast(node.left);
            if (node.right!=null)
                queue.addLast(node.right);
        }
    }
}
