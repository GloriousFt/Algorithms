###Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
* All numbers (including target) will be positive integers.
* The solution set must not contain duplicate combinations.

[Leetcode Combination Sum](https://leetcode.com/problems/combination-sum/)

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    backtracking(result, path, candidates, 0, target);
    return result;
}
private void backtracking(List<List<Integer>> result, List<Integer> path, int[] candidates, int index, int target) {
    if (target == 0) {
        result.add(new ArrayList<Integer>(path));
        return;
    } else if (target < 0) {
        return;
    } else {
        for (int i = index;i < candidates.length;i++) {
            path.add(candidates[i]);
            backtracking(result, path, candidates, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
```