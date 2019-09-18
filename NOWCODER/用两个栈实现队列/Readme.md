剑指offer——用两个栈实现队列

# 剑指offer——用两个栈实现队列
## 【题目描述】
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

## 【解题思路】
### 栈：后进先出
### 队列：先进先出
知道了栈和队列的特点以后就可以利用栈实现队列入队和出队操作了。

入队：利用stack1作为存储，直接将node放进stack1中。先进的元素在栈底，后进的元素在栈顶。
出队：利用stack2作为缓冲区，将stack1中元素挨个弹出并push进stack2中，此时原本在stack1栈底的元素在stack2中成为栈顶元素。此时pop出stack2栈顶元素即为最早进入队列的元素。在取出元素之后，将stack2中元素再依次放进stack1中，保持入队次序。

## 【代码】

```
import java.util.Stack;

/**
 * @Author: makexin
 * @Date: 2019/9/1821:10
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty())
        {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while(!stack2.empty())
            stack1.push(stack2.pop());

        return result;
    }
}
```

## 变种方法
在网上看了一下别人的思路，发现有两种变种的方法：
### 方法1
出队：将元素从stack1中移到stack2之后，pop出栈顶元素。不直接将元素恢复到stack1中。
入队：首先判断stack1中元素是否为空。若不为空，则说明元素都在stack1中，直接入栈。若为空，则将元素从stack2中移到stack1中，再执行入栈。

这种方法在连续出队的情况下，可以减少几次移动栈元素的操作，直接出队就可以。出入队交叉的情况下并没有什么提升。
### 方法2
入队：使用stack1作为存储，直接入栈到stack1中。
出队：首先判断stack2元素是否为空。若为空，则将stack1中元素移动到stack2中，然后出队。若不为空，则直接出队（此时stack2中元素为上一次从stack1中移动过来的数据，为最开始的数据，直接出队）。

这种方法相当于stack1和stack2各维护一部分数据。stack2用于存放较早时刻的数据，并按照出队的顺序存放，出栈操作即为队列的出队操作。stack1维护之后入队的操作，栈底元素为最新元素。 当stack2中为空，即stack2中元素全部出队，则将stack1中数据移动过来，按照出队的顺序存放，相当于新一波的出队数据。