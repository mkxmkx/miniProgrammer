import java.util.LinkedList;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/11/1310:05
 */
public class Solution {
    public int LastRemaining_Solution(int n, int m)
    {
        if (n==0)
            return -1;
        boolean[] visited = new boolean[n];
        int count = -1;
        int sum = 0;
        int index = -1;
        while (true)
        {
            index = index+1 == n ? 0: index+1; //判断是继续往下走还是循环回到数组头部
            if (!visited[index])
                count++;
            if (count == m-1)
            {
                visited[index] = true;
                if (++sum == n)
                {
                    return index;
                }
                count = -1;
            }
        }
    }

    public int LastRemaining_Solution_v2(int n, int m)
    {
        if (n==0)
            return -1;
        List<Integer> students = new LinkedList<>();
        for (int i=0; i<n; i++)
        {
            students.add(i);
        }
        int index = 0;
        while (students.size()>1)
        {
            index = (index + m - 1) % students.size();
            students.remove(index);
        }
        return students.get(0);
    }


}
