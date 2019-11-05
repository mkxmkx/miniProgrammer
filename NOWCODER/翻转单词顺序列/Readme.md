## 剑指offer——翻转单词顺序列
### 【题目描述】
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

### 【解题思路】
根据空格将原字符串分开，然后逆序拼接起来就可以。

### 【代码实现】

```java
public String ReverseSentence(String str)
    {
        if (str.trim().length()==0)
            return str;
        String[] words = str.split(" ");
        String result = "";
        for (int i = words.length-1; i>=0; i--)
        {
            result += words[i];
            if (i != 0)
                result += " ";
        }
        return result;
    }
```
