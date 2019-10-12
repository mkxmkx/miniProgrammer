## 剑指offer——包含min函数的栈
## 【题目描述】
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

## 【解题思路】
因为题目要求时间复杂度为O（1），所以需要可以直接给出min值。
可以设置一个辅助的数，用来保存最小值。但是有一个问题就是，当那个最小值弹出的时候，需获得次小值。因此使用一个栈来保存最小值，按照进栈的顺序，先进栈的较小值在栈底，然后此栈元素非递增，仅当小于等于栈顶元素时才入栈。

因此有两个栈，数据栈data和辅助栈。

在data出栈的时候需要判断，当data出栈元素与辅助栈栈顶元素相等时，辅助栈栈顶元素也出栈。

## 【代码实现】

```java
import java.util.Stack;

/**
 * @Author: makexin
 * @Date: 2019/10/1220:56
 */
public class Solution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> minData = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (!minData.empty())
        {
            int temp = minData.peek();
            if (node <= temp)
                minData.push(node);
        }
        else
            minData.push(node);
    }

    public void pop() {
        if (data.peek() == minData.peek())
            minData.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minData.peek();
    }
}

```
