package Week3_SetsAndMapsAdvanced;

import java.util.*;

public class Lab4_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentGradeList = new TreeMap<>();
        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countStudents; i++) {
            String data = scanner.nextLine();
            String name = data.split("\\s+")[0];
            double grade = Double.parseDouble(data.split("\\s+")[1]);

            studentGradeList.putIfAbsent(name, new ArrayList<>());
            studentGradeList.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentGradeList.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = getAverageGrade(grades);
            System.out.print(studentName + " -> ");
            grades.forEach(grade-> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", average);
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum+=grade;
        }
        return sum/grades.size();
    }
}
