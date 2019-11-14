## 剑指offer——求1+2+...+n
### 【题目描述】
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

### 【解题思路】
排除题目说明不能用的关键字及运算，剩下的运算中就加减法可以求和，所以采用递归的方法。
递归需要停止条件，不能用if语句，因此采用逻辑与&&的短路特性。
逻辑与&&短路特性：当判断两个条件是否成立时，若第一个条件不成立，则就会短路不进行第二个条件判断。

### 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/11/1418:39
 */
public class Solution {
    public int Sum_Solution(int n)
    {
        int sum = n;
        boolean flag = ((sum > 0) && (sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}

```
