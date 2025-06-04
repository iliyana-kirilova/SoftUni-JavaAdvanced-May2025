package Week6_DefiningClasses.OpinionPoll;

public class Person {
    //полета -> характеристики на класа
    private String name;
    private int age;


    // констуктор -> специален метод, с който създаваме обекти от класа
    //1. вграден констуктор(констуктор по подразбиране) - празен обект от класа

    public Person() {//създава нов празен обект от класа
        //name = null;
        //age = 0;

    }
    //2. констуктор, който сме създали ние
    public Person(String name, int age) { //създава нов празен обект от класа
        this.name = name;
        this.age = age;
    }

    //методи - описваме действията, който може да прави обекта
    // getters -> методи, които ни дават стойността, която се съхванява в полетата

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    // setters-> методи, с които задаваме стойности на поле
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
