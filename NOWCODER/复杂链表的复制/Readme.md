﻿## 剑指offer——复杂链表的复制

## 【题目描述】
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

## 【解题思路】
一开始理解错提议，考虑用递归的方法，没碰到一个节点就创造一个新节点复制一下。后来发现random所指的节点与next所指的节点是同一个节点。

首先遍历一遍原链表，只根据next创建新节点，这样所有的节点就创建完了。在遍历的过程中，使用一个map保存含有random节点与所指向的节点的对应关系。map<新链表节点，对应的random节点>。
然后再次遍历的时候，就根据建立的map表，把新链表中random节点补全。

## 【代码实现】

```java
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: makexin
 * @Date: 2019/10/1613:15
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode result = null, head = new RandomListNode(0), p = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p!=null)
        {
             RandomListNode newNode = new RandomListNode(p.label);
             if (result==null)
             {
                 result = newNode;
                 head.next = result;
             }
             else
             {
                 //给上一个节点的next赋值，然后将result向后移一个，保持与p位置相同。
                 result.next = newNode;
                 result = result.next;
             }

            if (p.random!=null)
                //若p有random节点，则保存相对位置的result节点为键值，复制的新节点为value
                map.put(result, new RandomListNode(p.random.label));

            p = p.next;
        }
        result = head.next;
        while (result!=null)
        {
            if (map.containsKey(result))
            {
                result.random = map.get(result);
            }
            result = result.next;
        }
        return head.next;
    }
    public static void main(String[] args)
    {
        RandomListNode randomListNode = new RandomListNode(5);
        randomListNode.next = new RandomListNode(7);
        randomListNode.random = new RandomListNode(0);
        Solution s = new Solution();
        s.Clone(randomListNode);
    }
}

```

## 补充
我看了一下别人的代码，发现别人用map表保存的新旧链表节点的一一对应关系，然后就在random没有创建新节点。但是我使用的map其实是创建了一个新节点的。不知道为什么我的代码也可以通过，可能我题意理解错了吧，新节点也可以？或者没搞懂内部机制
