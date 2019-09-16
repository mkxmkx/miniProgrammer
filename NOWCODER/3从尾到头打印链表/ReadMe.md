牛客网——剑指offer：从尾到头打印列表

# 剑指offer—— 从尾到头打印链表
## 【题目描述】
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

## 【题目分析】
## 链表结构：

```
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}
```
链表是按照从头到尾的顺序依次连起来的，由于是单向链表，所以只能按照从头到尾的顺序把元素依次取出来。
可以将链表元素按从头到尾的元素取出并依次放到一个arraylist中，然后再从arraylist中反向循环取出每一个元素放进另一个arraylist中。即为最终结果。

特别简单的一道题。

## 【代码实现】
### ListNode.java

```
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}
```
### Solution.java

```
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (listNode == null)
            return result;
        while (true)
        {
            temp.add(listNode.val);
            if (listNode.next == null)
                break;
            listNode = listNode.next;
        }
        Integer length = temp.size();
        for(int i = length-1; i >= 0; i--)
        {
            result.add(temp.get(i));
        }
        return result;
    }
}

```
