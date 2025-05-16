package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket =='(' || currentBracket =='['|| currentBracket == '{'){
                stackOpenBrackets.push(currentBracket);
            } else {
                if (stackOpenBrackets.isEmpty() || !machBrackets(stackOpenBrackets.pop(), currentBracket)){
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }


    private static boolean machBrackets(Character openBracket, char closedBracket) {
        if (openBracket == '('){
            return closedBracket == ')';
        } else if (openBracket == '[') {
            return closedBracket == ']';
        } else {
            return closedBracket == '}';
        }

    }
}
