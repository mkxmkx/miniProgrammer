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
