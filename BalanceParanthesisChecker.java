import java.util.Stack;

public class BalanceParanthesisChecker {

    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); 
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; 

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false;
            }
        }

        return stack.isEmpty(); 
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String input1 = "(a + b) * (c - d)";
        String input2 = "({[)]}";

        System.out.println(input1 + " → " + (isBalanced(input1) ? "Balanced" : "Not Balanced"));
        System.out.println(input2 + " → " + (isBalanced(input2) ? "Balanced" : "Not Balanced"));
    }
}

