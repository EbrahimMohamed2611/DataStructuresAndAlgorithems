package dataStructures.linear.stack.balancedExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {
    private final String expression;
    private final List<Character> leftBrackets = Arrays.asList('(','<','{','[');
    private final List<Character> rightBrackets = Arrays.asList(')','>','}',']');

    public BalancedExpression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced(){
        Stack<Character> characterStack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char ch:chars) {
            if(isLeftBracket(ch))
                characterStack.push(ch);

            if(isRightBracket(ch)){
                if(characterStack.isEmpty()) return false;
                char topBracket = characterStack.pop();
                if(!bracketMatches(ch,topBracket)) return false;
            }
        }
        return characterStack.isEmpty();
    }

    private boolean isLeftBracket(char bracket){
        return leftBrackets.contains(bracket);
    }

    private boolean isRightBracket(char bracket){
        return rightBrackets.contains(bracket);
    }

    private boolean bracketMatches(char right, char left){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
