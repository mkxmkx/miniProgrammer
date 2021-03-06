## 剑指offer——把数组排成最小的数

## 【题目描述】
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

## 【解题思路】
需要把整数转换成字符串，进而比较。在比较的时候，不能分开比较两个数的大小，而应该比较两个数拼接以后，怎样拼接小。比如3、32。应该比较332和323两个字符串哪个小，323比较小则说明32比3小，应该排在3的前面。

大小比较方式明确之后，通过排序将所有 整数从小到大排序，然后按照顺序拼接成字符串就可以了。

排序算法很重要。

## 【代码实现】

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: makexin
 * @Date: 2019/10/2313:24
 */
public class Solution {
    public String PrintMinNumber(int [] numbers)
    {
        String[] strNumber = new String[numbers.length];
        int i;
        for (i=0; i<numbers.length; i++)
            strNumber[i] = String.valueOf(numbers[i]);
        int j;
        for (i=0; i<numbers.length-1; i++)
        {
            for(j=numbers.length-1; j>i; j--)
            {
                String str1 = strNumber[j-1] + strNumber[j];
                String str2 = strNumber[j] + strNumber[j-1];
                if (str1.compareTo(str2) > 0)
                {
                    String temp = strNumber[j-1];
                    strNumber[j-1] = strNumber[j];
                    strNumber[j] = temp;
                }
            }
        }
        String result = "";
        for (String tempStr: strNumber)
            result += tempStr;
        return result;
    }

    public static void main(String[] args)
    {
        int[] number = {3, 32, 321};
        System.out.println(new Solution().PrintMinNumber(number));
    }
}

```
这里用的是冒泡排序，从后往前，将最小的冒泡到前面。