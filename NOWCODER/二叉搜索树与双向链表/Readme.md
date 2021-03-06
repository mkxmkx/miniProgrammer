## 剑指offer——二叉搜索树与双向链表
## 【题目描述】
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

## 【解题思路】
二叉搜索树的左孩子都比根节点小，右孩子都比根节点大。
举一个例子，按照题目要求变换二叉搜索树中节点指针，可以发现刚好是按照二叉树的中序遍历结果排序的。因此只需获得中序遍历的节点顺序，然后依次将上一个节点的右节点指向下一个节点，下一个节点的左孩子指向上一个节点。

重点：**树的中序遍历**

## 【代码实现】

```java
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/1713:15
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        midDFS(queue, pRootOfTree);
        TreeNode pre = queue.pop();
        TreeNode next, head = pre;
        while (!queue.isEmpty())
        {
            next = queue.pop();
            pre.right = next;
            next.left = pre;
            pre = next;
        }
        return head;
    }
    public void midDFS(LinkedList<TreeNode> queue, TreeNode root)
    {
        if (root!=null)
        {
            midDFS(queue, root.left);
            queue.add(root);
            midDFS(queue, root.right);
        }

    }
}

```
