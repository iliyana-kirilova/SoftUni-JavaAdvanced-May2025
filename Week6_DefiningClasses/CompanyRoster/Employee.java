package Week6_DefiningClasses.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;

    private String email;
    private int age;

    public Employee(String name, double salary, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

   @Override
    public String toString(){
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
   }
}
