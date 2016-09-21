###Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
* All numbers (including target) will be positive integers.
* The solution set must not contain duplicate combinations.

[Leetcode Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    Arrays.sort(candidates);
    backtracking(result, path, 0, candidates, target, new boolean[candidates.length]);
    return result;
}
private void backtracking(List<List<Integer>> result, List<Integer> path, int index, int[] candidates, int target, boolean[] isUsed) {
    if (0 == target) {
        result.add(new ArrayList<Integer>(path));
        return;
    } else if (target < 0) {
        return;
    } else {
        for (int i = index;i < candidates.length && target >= candidates[i];i++) {
            if (isUsed[i] || (i > 0 && candidates[i] == candidates[i - 1] && !isUsed[i - 1])) {
                index++;
                continue;
            }
            isUsed[i] = true;
            path.add(candidates[i]);
            backtracking(result, path, i + 1, candidates, target - candidates[i], isUsed);
            isUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
```

因为每个集合中的元素只能用一次,所以可以用一个isUsed{boolean}来存储使用情况,入栈的就把对应元素的isUsed改为true。

这样在每次遍历时,如果是使用过的就直接略过。

```java
(i > 0 && candidates[i] == candidates[i - 1] && !isUsed[i - 1])
```

这个条件是为了解决一种情况,如:[2,2,2],target = 4。

1. 从第一个元素"2"开始计算,前两个"2"正常入栈,在判断第三个的时候,因为target == 0,所以result保存结果"[2,2]"(第一个"2"是原集合中第一个"2",第二个"2"是原集合中第二个"2")。
2. 第二个"2"出栈,第三个"2"入栈,此时如果不做这个条件判断则会再次把"[2,2]"(第一个"2"是原集合中第一个"2",第二个"2"是原集合中第三个"2")保存到result中。

所以为了避免重复,把相同的元素只做第一次计算处理,后面的相同元素都略过直到遇到新的元素。