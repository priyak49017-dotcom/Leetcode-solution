import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left + right);
                }
                case "-" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left - right);
                }
                case "*" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left * right);
                }
                case "/" -> {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left / right);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}