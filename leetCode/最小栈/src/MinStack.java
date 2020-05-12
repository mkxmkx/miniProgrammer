import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: makexin
 * @Date: 2020/5/1221:31
 */
public class MinStack {
    Stack<Integer> list;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        this.list = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        list.push(x);
        if(min.isEmpty())
            min.push(x);
        else if (x <= min.peek())
            min.push(x);
    }

    public void pop() {
        int x = list.pop();
        if(x == min.peek());
            min.pop();
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
