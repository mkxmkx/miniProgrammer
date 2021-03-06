## 剑指offer——栈的压入、弹出序列
## 【题目描述】
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

## 【解题思路】
就是每个元素弹出的时候，判断该元素是否可弹出。
判断方法：设置一个标志数组，记录每个元素是否出栈。当一个元素出栈时，首先判断在入栈序列中，该元素之后的元素是否存在，有元素还未出栈，但之后已有元素出栈。此时说明该元素不可出栈。因此结果为false。每出栈一个元素，标志位记为true。
除此之外需判断出栈元素在入栈序列中找不到的情况，当出栈元素在入栈序列中找不到时，返回false。也可通过标志数组是否全为true判断。

## 【代码实现】

```java
/**
 * @Author: makexin
 * @Date: 2019/10/1316:22
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        boolean flag[] = new boolean[pushA.length];
        int i,j;
        for (i=0; i<pushA.length; i++)
            flag[i] = false;


        for (i=0; i<popA.length; i++)
        {
            int pop = popA[i];
            for (j=0; j<pushA.length; j++)
            {
                if (pushA[j] == pop)//寻找到出栈元素在入栈序列的索引位置
                {

                    boolean checkResult = check(flag, j);//判断该元素是否不可出栈
                    if (checkResult)//该元素不可出栈
                        return false;
                    else//该元素可出栈
                    {
                        flag[j] = true;//标志数组设为true
                        break;
                    }
                }
            }
        }
        if (flagCheck(flag))
            return true;
        else
            return false;

    }

    public boolean check(boolean[] flag, int index)
    {
        //检测index之后的标志位，true之前是否有false。若有，则返回true。否则返回false
        int i = index+1;
        boolean falseFlag = false;
        for (; i<flag.length; i++)
        {
            if (flag[i] == false)
            {
                falseFlag = true;
            }
            else
            {
                if (falseFlag)//如果在true之前存在false，则说明该出栈序列不正确
                {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean flagCheck(boolean[] flag)//判断是否所有入栈元素都出栈了
    {
        for (boolean temp: flag) {
            if (temp == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(new Solution().IsPopOrder(push, pop));
    }
}

```


## 其他做法
在网上看了一下其他人的做法。可以通过一个栈来辅助判断。首先根据入栈序列依次入栈，每入栈一个元素判断该元素是否与出栈栈顶元素相等，若相等，则出栈。

最终根据辅助栈是否为空来判断压入、弹出序列是否合理。

```java
public boolean isPopOrder(int pPush[], int pPop[]){
	boolean bPossible = false;
	if(pPush.length == 0 || pPop.length == 0){
		bPossible = false;
	}
	Stack<Integer> stack = new Stack<Integer>();
	//用于标识弹出序列的位置
	int popIndex = 0;
	for (int i = 0; i < pPush.length; ++i) {
		stack.push(pPush[i]);
		while(!stack.isEmpty() && stack.peek() == pPop[popIndex]){
			stack.pop(); //出栈
			++popIndex;
		}
	}
	if(stack.isEmpty() && pPop.length-1 == popIndex){
		bPossible = true;
	}else{
		bPossible = false;
	}
	return bPossible;
}
```
