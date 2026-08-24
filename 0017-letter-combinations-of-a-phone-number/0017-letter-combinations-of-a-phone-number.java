class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // if there are no digits, there are no combinations
        if (digits.length() == 0) {
            return result;
        }

        // letters for each number on the phone
        String[] letters = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // start finding the combinations
        backtrack(digits, 0, "", result, letters);

        return result;
    }

    // this function builds the answer one character at a time
    private void backtrack(String digits, int index, String current,
                            List<String> result, String[] letters) {

        // if we used all the digits, we have one complete combination
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // get the letters for the current digit
        int digit = digits.charAt(index) - '0';
        String possibleLetters = letters[digit];

        // try each letter for this digit
        for (int i = 0; i < possibleLetters.length(); i++) {

            // add the letter and move to the next digit
            backtrack(
                digits,
                index + 1,
                current + possibleLetters.charAt(i),
                result,
                letters
            );
        }
    }
}