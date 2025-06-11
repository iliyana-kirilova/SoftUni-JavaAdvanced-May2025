package Week7_Generics.Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> integerScale = new Scale<>(1, 2);
        System.out.println(integerScale.getHeavier());


        Scale<String> stringScale = new Scale<>("abd", "fhix");
        System.out.println(stringScale.getHeavier());
    }
}
