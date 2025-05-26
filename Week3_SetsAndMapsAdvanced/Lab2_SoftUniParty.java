package Week3_SetsAndMapsAdvanced;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guestsList = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        while (!guestsList.equals("PARTY")){
            char firstSymbol = guestsList.charAt(0);
            if (Character.isDigit(firstSymbol)){
                vipGuests.add(guestsList);
            }else {
                regularGuests.add(guestsList);
            }

            guestsList = scanner.nextLine();
        }

        String guestsLeft = scanner.nextLine();
        while (!guestsLeft.equals("END")){
            if (vipGuests.contains(guestsLeft)){
                vipGuests.remove(guestsLeft);
            } else regularGuests.remove(guestsLeft);

            guestsLeft = scanner.nextLine();
        }

        System.out.println(vipGuests.size()+ regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}
