package Week6_DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> employeeList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employeeList = new ArrayList<>();
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public double getAverageSalary(){
        double sum = 0;
        for (Employee employee : this.employeeList) {
            sum += employee.getSalary();
        }
        return sum/ this.employeeList.size();
    }

}
