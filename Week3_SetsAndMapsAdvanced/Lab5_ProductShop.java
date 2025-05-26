package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab5_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();

        Map<String, Map<String, Double>> shopsMap = new TreeMap<>();
        while (!data.equals("Revision")){
            String[] input = data.split(", ");
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            if (!shopsMap.containsKey(shop)){
                shopsMap.put(shop, new LinkedHashMap<>());
                shopsMap.get(shop).put(product, price);
            }else {
                shopsMap.get(shop).put(product, price);
            }

            data = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : shopsMap.entrySet()) {
            String shop = entry.getKey();
            Map<String, Double> productList = entry.getValue();
            System.out.println(shop + "->");
            productList.forEach((key, value)-> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        }
    }
}
