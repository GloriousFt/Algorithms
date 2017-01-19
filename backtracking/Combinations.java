public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    backtracking(result, new ArrayList<Integer>(), 1, n, k);
    return result;
}
public void backtracking(List<List<Integer>> result, List<Integer> list, int left, int right, int k) {
    if (list.size() == k) {
        result.add(new ArrayList<Integer>(list));
        return;
    }
    for (int i = left;i <= right;i++) {
        list.add(i);
        backtracking(result, list, i + 1, right, k);
        list.remove(list.size() - 1);
    }
}