## 剑指offer——二叉搜索树的第k个结点
### 【题目描述】

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

### 【解题思路】
因为二叉搜索树其实结点的顺序已经排好了。左边的结点都比根节点小，右边的节点都比根节点大。现在需要寻找第k小的节点，即按照中序遍历方式遍历到的第k个结点。

使用非递归的方式中序遍历二叉树，因为遍历到第k个结点就需要停止遍历了。

### 【代码实现】

```java
import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/720:56
 */
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        LinkedList<TreeNode> orderList = new LinkedList<>();
        int p = 0;
        TreeNode node = pRoot;
        while (node!=null || !orderList.isEmpty())
        {
            while (node!=null)//左节点入栈
            {
                orderList.push(node);
                node = node.left;
            }
            if (!orderList.isEmpty())
            {
                node = orderList.pop();
                p++;
                if (p == k)
                    break;
                node = node.right;
            }
        }
        if (p == k)
            return node;
        else
            return null;
    }

    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        Solution s = new Solution();
        s.KthNode(tree, 3);
    }

}

```
