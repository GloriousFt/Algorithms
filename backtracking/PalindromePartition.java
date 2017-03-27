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