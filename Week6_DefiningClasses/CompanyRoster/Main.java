package Week6_DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countLines = Integer.parseInt(scanner.nextLine());
        List<Department> departmentList = new ArrayList<>();

        for (int i = 1; i <=countLines ; i++) {
            String data = scanner.nextLine();
            String[] dataParts = data.split("\\s+");
            String name = dataParts[0];
            double salary = Double.parseDouble(dataParts[1]);
            String position = dataParts[2];
            String departmentName = dataParts[3];
            String email = "n/a";
            int age = -1;

            if (dataParts.length ==6){
                //dataParts = ["name", "salary", "position", "department", "email", "age"];
                email = dataParts[4];
                age = Integer.parseInt(dataParts[5]);

            } else if (dataParts.length == 5) {
                if (dataParts[4].contains("@")) {
                    //dataParts = ["name", "salary", "position", "department", "email"];
                    email = dataParts[4];
                }else {
                    // dataParts = ["name", "salary", "position", "department", "age"];
                    age = Integer.parseInt(dataParts[4]);
                }
            }

            Employee employee = new Employee(name, salary, position, email, age);

            //намирам отдела в списъка, в който трябва да добавя служителя
            Department department = getDepartmentByName(departmentList, departmentName);
            //добавяме служителя в отдела
            department.getEmployeeList().add(employee);
        }

        Collections.sort(departmentList, Comparator.comparing(Department::getAverageSalary).reversed());
        Department highestDepartment = departmentList.get(0);
        System.out.println("Highest Average Salary: "+ highestDepartment.getDepartmentName());

        Collections.sort(highestDepartment.getEmployeeList(), Comparator.comparing(Employee::getSalary).reversed());
        for (Employee employee : highestDepartment.getEmployeeList()) {
            System.out.println(employee.toString());
        }
    }

    private static Department getDepartmentByName(List<Department> departmentList, String departmentName) {
        // намира и връща отдела с даденото име
        for (Department department : departmentList) {
            if (department.getDepartmentName().equals(departmentName)){
                return  department;
            }
        }
        Department department = new Department(departmentName);
        departmentList.add(department);
        return department;
    }
}
