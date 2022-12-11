import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static String removeParenthesis(String str) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> removeList = new ArrayList<>();
        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) == '[') {
                stack.push(i);
            } else if (str.charAt(i) == ']') {
                if(stack.isEmpty()) {
                    removeList.add(i);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            removeList.add(stack.pop());
        }
        StringBuilder path = new StringBuilder();
        for (int i = 0;i < str.length();i++) {
            if (!removeList.contains(i)) {
                path.append(str.charAt(i));
            }

        }
        return path.toString();


    }
}