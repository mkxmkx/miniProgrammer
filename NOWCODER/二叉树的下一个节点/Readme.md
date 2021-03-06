## 剑指offer——二叉树的下一个节点
### 【题目描述】
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
### 【解题思路】
中序遍历顺序：左——中——右
对于一个当前节点来说：
1、当该节点有右孩子节点，则下一个节点是右孩子中的最底层左孩子节点。
2、当该节点没有右孩子节点时，则只能向父节点追溯。
	（1）当该节点是父节点的左孩子时，则下一个节点是父节点
	（2）当该节点不是父节点的左孩子时，则需要继续向上追溯，直到找到一个节点是其左孩子。或者追溯到根节点，则没有下一个节点。

主要就是判断以上三种情况

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/3016:20
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        TreeLinkNode result = null;
        if (pNode.right != null)//存在右孩子
        {
            TreeLinkNode rightNode = pNode.right;
            while (rightNode.left!=null)
            {
                rightNode = rightNode.left;
            }
            result = rightNode;
        }
        else //不存在右孩子，则向上找
        {
            TreeLinkNode parentNode = pNode.next;
            TreeLinkNode current = pNode;
            while (parentNode != null)
            {
                if (parentNode.left == current)//当前节点是父节点的左孩子，则下一个节点是父节点
                {
                    result = parentNode;
                    break;
                }
                else
                {
                    current = parentNode;
                    parentNode = current.next;
                }
            }
            if (parentNode == null)
                result = null;
        }
        return result;
    }
}

```