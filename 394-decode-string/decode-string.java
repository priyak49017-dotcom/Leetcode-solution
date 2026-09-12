class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();

        int currentNumber = 0;
        StringBuilder currentString = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');

            } else if (ch == '[') {
                num.push(currentNumber);
                str.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder();

            } else if (ch == ']') {
                int repeatCount = num.pop();
                StringBuilder previousString = str.pop();
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }
                currentString = previousString;

            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
