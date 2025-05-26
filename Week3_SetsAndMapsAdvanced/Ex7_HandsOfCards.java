package Week3_SetsAndMapsAdvanced;

import java.util.*;

public class Ex7_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        while (!data.equals("JOKER")){
            String name = data.split(": ")[0];
            String [] cards = data.split(": ")[1].split(", ");

            if (!playerCards.containsKey(name)){
                playerCards.put(name, new LinkedHashSet<>());
                for (String card : cards) {
                    playerCards.get(name).add(card);
                }
            } else {
                for (String card : cards) {
                    playerCards.get(name).add(card);
                }
            }
            data = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playerCards.entrySet()) {
            String currentName = entry.getKey();
            Set<String> currentSet = entry.getValue();
            int totalPoints = calculatePoints(currentSet);
            System.out.printf("%s: %d%n", currentName, totalPoints);

        }

        /*int totalPoints = 0;
        for (String cardText : cards) {
            Card currentCard = new Card(cardText);
            totalPoints += card.getValue();
        }*/
    }

    /*public  class Card{
        private static String power;
        private static String type;
        public Card(String cardText) {
            if (cardText.length() == 3) {
                this.power = cardText.substring(0, 2);
                this.type = cardText.substring(2);
            } else {
                this.power = cardText.substring(0, 1);
                this.type = cardText.substring(1);
            }
        }
    }*/

    /*public int getValue() {
        return getPowerValue() * getTypeMultiplier();
    }*/

    private static int calculatePoints(Set<String> currentSet) {
        int sum = 0;
        for (String card : currentSet) {
            int cardValue = getCardValue(card);
            sum+=cardValue;
        }
        return sum;
    }

    private static int getCardValue(String card) {
        String power;
        String type;

        if (card.length() == 3) {
            power = card.substring(0, 2); // "10"
            type = card.substring(2);     // "H"
        } else {
            power = card.substring(0, 1); // "J", "Q", "A", "2", и т.н.
            type = card.substring(1);     // "S", "H", "D", "C"
        }

        int number = getCardNumber(power);
        int multiplier = getCardMultiplier(type);

        return number * multiplier;
    }

    private static int getCardMultiplier(String type) {
        switch (type){
            case "C": return 1;
            case "D": return 2;
            case "H": return 3;
            case "S": return 4;
        }
        return Integer.parseInt(type);
    }

    private static int getCardNumber(String cardNumber) {
        switch (cardNumber){
            case "1": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
        }
        return Integer.parseInt(cardNumber);
    }
}
