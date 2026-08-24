class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, 0, new StringBuilder(), ans, map);

        return ans;
    }

    private void solve(String digits, int index, StringBuilder str,
                       List<String> ans, String[] map) {

        // reached the end, so we found one answer
        if (index == digits.length()) {
            ans.add(str.toString());
            return;
        }

        // convert the character digit into an integer
        int num = digits.charAt(index) - '0';

        // try all the letters for this number
        for (char c : map[num].toCharArray()) {
            str.append(c);

            solve(digits, index + 1, str, ans, map);

            // remove the last character before trying the next one
            str.deleteCharAt(str.length() - 1);
        }
    }
}