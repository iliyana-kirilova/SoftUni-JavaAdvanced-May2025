package Week6_DefiningClasses.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> personMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] inputParts = input.split("\\s+");
            String personName = inputParts[0];
            String data = inputParts[1];

            personMap.putIfAbsent(personName, new Person(personName));
            Person currentPerson = personMap.get(personName);

            switch (data){
                case "company":{
                    String companyName = inputParts[2];
                    String companyDepartment = inputParts[3];
                    double salary = Double.parseDouble(inputParts[4]);

                    Company company = new Company(companyName, companyDepartment, salary);
                    currentPerson.setCompany(company);
                    break;
                }
                case "pokemon":{
                    String pokemonName = inputParts[2];
                    String pokemonType = inputParts[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    currentPerson.addPokemon(pokemon);
                    break;
                }
                case "parents":{
                    String parentName = inputParts[2];
                    String parentBirthday= inputParts[3];

                    Parents parent = new Parents(parentName, parentBirthday);
                    currentPerson.addParent(parent);
                    break;
                }
                case "children":{
                    String childName = inputParts[2];
                    String childBirthday= inputParts[3];

                    Children child = new Children(childName, childBirthday);
                    currentPerson.addChild(child);
                    break;
                }
                case "car":{
                    String carModel = inputParts[2];
                    int carSpeed = Integer.parseInt(inputParts[3]);

                    Car car = new Car(carModel, carSpeed);
                    currentPerson.setCar(car);
                    break;
                }
            }

            input = scanner.nextLine();
        }

        String nameToPrintInfo = scanner.nextLine();
        System.out.println(personMap.get(nameToPrintInfo));


    }
}
