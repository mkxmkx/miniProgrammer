## 剑指offer——按之字形顺序打印二叉树
### 【题目描述】
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
### 【解题思路】
使用两个栈，一个栈p存放奇数层从左到右顺序的，一个栈q存放偶数层从右到左顺序的。
遍历奇数层时，按照从左到右的顺序，按照左右孩子的顺序将下一层的节点放到p中。由于是栈，所以到遍历栈p的时候，从栈顶开始就是从右到左的顺序了。
遍历偶数层时，按照右左孩子的顺序将下一层的节点放到p中。

### 【代码实现】

```java
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: makexin
 * @Date: 2019/12/216:02
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot==null)
            return result;
        LinkedList<TreeNode> p = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        p.push(pRoot);
        int flag = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!p.isEmpty() || !q.isEmpty())
        {
            if (flag%2 != 0)//从左到右，访问p，然后按从右到左
            {
                while (!p.isEmpty())
                {
                    TreeNode node = p.pop();//弹出栈顶元素
                    temp.add(node.val);
                    //栈，后进先出，所以按照反的顺序存到栈里
                    if (node.left!=null)
                        q.push(node.left);
                    if (node.right!=null)
                        q.push(node.right);
                }
            }
            if (flag%2 == 0)
            {
                while (!q.isEmpty())
                {
                    TreeNode node = q.pop();
                    temp.add(node.val);
                    if (node.right!=null)
                        p.push(node.right);
                    if (node.left!=null)
                        p.push(node.left);
                }
            }
            result.add(new ArrayList<Integer>(temp));﻿
            temp.clear();
            flag++;
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);
        Solution s = new Sol﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿ution();
        s.Print(t);

    }
}

```