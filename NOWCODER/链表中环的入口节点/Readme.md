## 剑指offer——链表中环的入口节点
### 【题目描述】
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

### 【解题思路】
#### 1、借助额外空间
使用一个set存放访问过的链表节点。当访问的节点已经在set中出现时，则说明是环的入口节点。

#### 2、不借助额外的空间，双指针法
第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。

第二步，找环的长度。从环中的相汇点开始, p2不动, p1前移，　当再次相遇时，p1刚好绕环一周, 其移动即为环的长度K

第三步, 求换的起点, 转换为求环的倒数第N-K个节点，则两指针left和right均指向起始, right先走K步, 然后两个指针开始同步移动, 当两个指针再次相遇时, right刚好绕环一周回到起点, left则刚好走到了起点位置

#### 3、不借助额外空间，断链法
使用两个指针，每访问一个节点，就把上一个节点的next重定向为null。当访问到最后一个节点时，就是环的入口。
这种方法会改变原链表格式。

### 【代码实现】
借助额外空间的方法

```java
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: makexin
 * @Date: 2019/11/2719:37
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
            return null;
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode p = pHead;
        ListNode result = null;
        while (p!=null)
        {
            if (nodeSet.contains(p))
            {
                result = p;
                break;
            }
            nodeSet.add(p);
            p = p.next;
        }
        return result;
    }
}

```
