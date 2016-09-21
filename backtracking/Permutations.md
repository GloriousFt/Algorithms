###Permutations

Given a collection of **distinct** numbers, return all possible permutations.

[LeetCode Permutations](https://leetcode.com/problems/permutations/)

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    backtracking(result, path, nums);
    return result;
}

private void backtracking(List<List<Integer>> result, List<Integer> path, int[] nums) {
    if (path.size() == nums.length) {
        result.add(new ArrayList<Integer>(path));
    } else {
        for (int i = 0;i < nums.length;i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtracking(result, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
```