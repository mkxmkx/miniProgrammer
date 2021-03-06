#﻿﻿﻿﻿﻿﻿# 剑指offer——序列化二叉树
### 【题目描述】
请实现两个函数，分别用来序列化和反序列化二叉树
﻿
二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。﻿﻿﻿﻿﻿

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

### 【解题思路】﻿﻿
**序列化：**
采用先序、中序、后序、层序的方式都可以，遍历一遍二叉树，保存成String。每个节点值后面用‘！’分隔，空节点用‘#’表示。我是用的先序遍历方式。注意一点：对于底层的节点，后面会跟着两个‘#’符号，因为底层节点的左右孩子都是空节点。
**反序列化：**
按照序列化的顺序重新构造二叉树。先构造当前节点，然后构造左节点，构造右节点。遇到空节点就返回null。
采用递归的方式反序列化二叉树。由于需要定位当前遍历到字符串中的哪个索引位置，所以采用类的静态变量的方式构造了一个全局变量，用于索引str中字符。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/12/514:46
 */
public class Solution {
    public static int deSerIndex = 0;
    String Serialize(TreeNode root)
    {
        String res = new String();
        if (root == null)
            return res;
        res = preOreder(root, res);
        return res;
    }
    String preOreder(TreeNode root, String s)
    {
        String temp = s;
        if (root!=null)
        {
            temp = temp + String.valueOf(root.val) + "!";
            temp = preOreder(root.left, temp);
            temp = preOreder(root.right, temp);
        }
        else
            temp += "#";
        return temp;
    }
    TreeNode Deserialize(String str)
    {
        if (str.length() == 0 || str == "")
            return null;
        deSerIndex = 0;
        TreeNode tree = DeSer(str);
        return tree;
    }
    TreeNode DeSer(String str)
    {
        TreeNode tree = null;
        if (deSerIndex<=str.length() && str.charAt(deSerIndex)!='#')
        {
            int val = 0;
            while (str.charAt(deSerIndex)!='!')
            {
                val = val*10 + str.charAt(deSerIndex) - 48;
                deSerIndex++;
            }
            deSerIndex++;
            tree = new TreeNode(val);
            tree.left = DeSer(str);
            tree.right = DeSer(str);
        }
        else
            deSerIndex++;
        return tree;
    }

    public static void main(String[] args)
    {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(5);
        Solution s = new Solution();
        String ser = s.Serialize(tree);
        System.out.println(ser);
        TreeNode temp = s.Deserialize(ser);
        System.out.println(s.Serialize(temp));
    }
}

```
﻿﻿