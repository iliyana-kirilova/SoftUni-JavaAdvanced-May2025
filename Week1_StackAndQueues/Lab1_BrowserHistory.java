package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String currentURL = "";
        ArrayDeque <String> browserHistory = new ArrayDeque<>();

        while (!command.equals("Home")){
            if (command.equals("back")){
                //ако нямаме предишно достъпени сайтове
                if (browserHistory.size()<=1){
                    System.out.println("no previous URLs");
                }else { //имаме предишно достъпени сайтове->връщаме се назад
                    browserHistory.pop(); // премахваме текущия сайт
                    currentURL = browserHistory.peek();
                    System.out.println(currentURL);
                }

            }else {
                currentURL = command;
                System.out.println(currentURL);
                browserHistory.push(currentURL);
            }

            command= scanner.nextLine();
        }
    }
}
