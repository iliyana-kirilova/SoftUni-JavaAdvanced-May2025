package Week3_SetsAndMapsAdvanced;

import java.util.*;

public class Lab6_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsMap = new TreeMap<>();
        for (int i = 1; i <=countStudents ; i++) {
            String studentName = scanner.nextLine();
            double [] grades =  Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToDouble(Double::parseDouble).toArray();

            double average = getAverageGrades(grades);
            studentsMap.put(studentName, average);
        }

        for (Map.Entry<String, Double> entry : studentsMap.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static double getAverageGrades(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum+=grade;
        }
        return  sum/grades.length;
    }
}
