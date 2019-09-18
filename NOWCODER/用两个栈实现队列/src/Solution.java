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
