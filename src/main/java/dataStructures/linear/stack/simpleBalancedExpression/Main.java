package dataStructures.linear.stack.simpleBalancedExpression;

public class Main {
    public static void main(String[] args) {
        SimpleBalancedExpression simpleBalancedExpression = new SimpleBalancedExpression(")5+2*6(");
        SimpleBalancedExpression simpleBalancedExpression2 = new SimpleBalancedExpression("(5+2*6(");
        SimpleBalancedExpression simpleBalancedExpression3 = new SimpleBalancedExpression("(5+2*6)");
        System.out.println(simpleBalancedExpression.isBalanced());
        System.out.println(simpleBalancedExpression2.isBalanced());
        System.out.println(simpleBalancedExpression3.isBalanced());
    }
}
