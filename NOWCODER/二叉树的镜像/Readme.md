## 剑指offer——二叉树的镜像

## 【题目描述】
操作给定的二叉树，将其变换为源二叉树的镜像。


## 【解题思路】
镜像就是把每个节点的左右孩子交换。因此遍历二叉树，每遍历到一个节点，先交换其左右孩子，再遍历剩下的。

有两种方式，递归和非递归的解法。
### 递归：
首先判断root是否为null。当root == null， 返回。否则，交换其左右孩子，再分别递归左右孩子。

### 非递归：
设置一个队列，将根节点入队。
while(队列元素不为空)
将队首元素弹出，先交换其左右孩子，再分别将不为空的左右孩子入队。相当于层序遍历的方式。

## 【代码实现】
非递归方式

```java
public void Mirror(TreeNode root)
    {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode temp = queue.pop();
            //交换左右子树
            TreeNode left = temp.right;
            temp.right = temp.left;
            temp.left = left;
			
			//层序遍历
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }

    }
```

递归方式

```java
public void mirror_v2(TreeNode root)
    {
        if (root == null)
            return;
        else
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror_v2(root.left);
            mirror_v2(root.right);
        }
    }
```
