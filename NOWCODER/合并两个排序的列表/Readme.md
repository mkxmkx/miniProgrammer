## 剑指offer——合并两个排序的列表

## 【题目描述】
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。


## 【解题思路】
设置一个新的head节点，最后返回的时候返回head.next，即为处理后的新链表。
循环比较两个链表的元素值，可以新申请空间在新链表上插入元素，也可以不申请空间，在原链表上拼凑。本代码是在原链表上拼凑的，没有新申请空间。
至少1个链表循环结束之后，退出循环。然后将另一个链表剩余元素全部拼的新链表后面。

## 【代码实现】

```java
public ListNode Merge(ListNode list1, ListNode list2)
    {
        ListNode newList = new ListNode(0);
        ListNode p = list1, q = list2, head = newList;
        while (p!=null && q!=null)//循环停止条件，至少有1个链表已经循环完了
        {
            if (p.val == q.val)
            {
                newList.next = p;
                p = p.next;
                newList.next.next = q;
                q = q.next;
                newList = newList.next.next;
            }
            else {
                if (p.val > q.val)//q的值较小，将q付给newList
                {
                    newList.next = q;
                    newList = newList.next;
                    q = q.next;
                }
                else //p的值较小，将p付给newList
                {
                    newList.next = p;
                    newList = newList.next;
                    p = p.next;
                }
            }
        }

        //剩余部分统一拼到最后
        if (p!=null)
            newList.next = p;
        if (q!=null)
            newList.next = q;
        return head.next;
    }
```


## 递归版本的实现
看了别人的思路以后，发现也可以使用递归的思路实现。

```java
public ListNode merge_digui(ListNode list1, ListNode list2)
    {
        //首先判断是否为null
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode newList = null;
        if(list1.val <= list2.val)
        {
            newList = list1;
            newList.next = merge_digui(list1.next, list2);
        }
        else
        {
            newList = list2;
            newList.next = merge_digui(list1, list2.next);
        }
        return newList;
    }
```
