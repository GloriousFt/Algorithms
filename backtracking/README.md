## Backtracking(回溯算法)
回溯算法其实就是利用深度优先遍历算法的一种"暴力破解"的算法。说它暴力,是因为它找出了每一个可能解,然后根据要求来进行筛选,适当的剪枝能对其性能提升很多。

最坏的情况下,它的时间复杂度是指数计算的。

它的思想就是:对每一步进行试验,check当前是否不存在解,如果存在就继续向下找,如果不存在则退出当前状态,回到之前的状态进行跳过当前状态的下一步搜索。一直找出所有解(可能没有解)。

> 根据这个思想,**递归**是其最好的实现方法。

常见的问题:

* 全排列问题 (Permutations)
* 集合中查找和为目标值的组合 (Combination Sum)
* N皇后问题 (N-Queens)
* 矩阵word搜索 (Word Search)
* 集合值组合问题 (Combinations)
* 字符串查找回文子字符串 (Palindrome Partitioning)

### Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

```java
[
  ["aa","b"],
  ["a","a","b"]
]
```

思路:也是组合问题,多了一个回文判断

```java
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        backtracking(result, new ArrayList<String>(), 0, s);
        return result;
    }

    private void backtracking(List<List<String>> result, List<String> curList, int index, String s) {
        if (index >= s.length()) {
            result.add(new ArrayList<String>(curList));
            return;
        }
        for (int i = index;i < s.length();i++) {
            String curString = s.substring(index, i + 1);
            if (isPalindrome(curString)) {
                curList.add(curString);
                backtracking(result, curList, i + 1, s);
                curList.remove(curList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0;i < length / 2;i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
```