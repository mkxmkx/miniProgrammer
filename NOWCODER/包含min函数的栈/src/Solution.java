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
