## 剑指offer——从上往下打印二叉树
## 【题目描述】
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

## 【解题思路】
树的**层序遍历**。
使用一个队列，将树根入队。每次从队列pop出一个元素，打印该节点，并分别将左右孩子入队。

## 【代码实现】

```java
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/10/1413:17
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> tree = new LinkedList<>();  // 队列
        if (root == null)
            return result;
        tree.add(root);
        while (!tree.isEmpty())
        {
            TreeNode temp = tree.pop();
            result.add(temp.val);
            if (temp.left != null)
            {
                tree.add(temp.left);
            }
            if (temp.right != null)
            {
                tree.add(temp.right);
            }
        }
        return result;
    }
}

```
