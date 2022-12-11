import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "lee(t(c)o)de)";
        String res = removeParenthesis(str);
        System.out.println(res);
        System.out.println("Hello world!");
    }

    public static String removeParenthesis(String str) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i =0; i < str.length();i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexes.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder path = new StringBuilder();
        for (int i = 0;i < str.length();i++) {
            if (!indexes.contains(i)) {
                path.append(str.charAt(i));
            }
        }
        return path.toString();
    }
}