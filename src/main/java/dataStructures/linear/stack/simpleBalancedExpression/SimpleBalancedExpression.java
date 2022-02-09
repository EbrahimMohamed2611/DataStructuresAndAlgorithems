package dataStructures.linear.stack.simpleBalancedExpression;

import java.util.Stack;

public class SimpleBalancedExpression {
    private final String expression;

    public SimpleBalancedExpression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char ch : chars) {
            if (ch == '(')
                stack.push(ch);

            if (ch == ')') {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
