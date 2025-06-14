package Week7_IteratorsAndComparators.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int resultName = this.name.compareTo(otherPerson.getName());
        int resultAge = this.age.compareTo(otherPerson.getAge());
        int resultTown = this.town.compareTo(otherPerson.town);

        if (resultName !=0){
            return resultName;
        } else if (resultAge!=0) {
            return resultAge;
        } else {
            return resultTown;
        }

    }
}
