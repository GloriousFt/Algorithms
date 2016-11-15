###Permutations II

Given a collection of numbers that might **contain** duplicates, return all possible **unique** permutations.

[LeetCode Permutations II](https://leetcode.com/problems/permutations-ii/)

```java
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    Arrays.sort(nums);
    backtracking(result, path, nums, new boolean[nums.length]);
    return result;
}

private void backtracking(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] isUsed) {
    if ( path.size() == nums.length ) {
        result.add(new ArrayList<Integer>(path));
    } else {
        for (int i = 0;i < nums.length;i++) {
            if (isUsed[i] || (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            isUsed[i] = true;
            backtracking(result, path, nums, isUsed);
            path.remove(path.size() - 1);
            isUsed[i] = false;
        }
    }
}
```

Very similiar with Combination II.