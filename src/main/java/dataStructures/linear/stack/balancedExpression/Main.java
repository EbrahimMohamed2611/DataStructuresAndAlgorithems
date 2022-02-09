package dataStructures.linear.stack.balancedExpression;

public class Main {
    public static void main(String[] args) {
        BalancedExpression balancedExpression = new BalancedExpression("[{<{}5+2*6/3>}]");
        BalancedExpression balancedExpression2 = new BalancedExpression("[{<{}5+2*6/3}{>}]");
        System.out.println(balancedExpression.isBalanced());
        System.out.println(balancedExpression2.isBalanced());
    }
}
