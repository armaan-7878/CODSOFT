import java.util.Scanner;

public class StudentGradeEvaluator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== Student Grade Evaluation System ==========");
        System.out.print("Enter total number of subjects: ");

        int subjectCount = input.nextInt();
        int sumMarks = 0;

        System.out.println("Enter marks for each subject:");

        for (int i = 1; i <= subjectCount; i++) {
            System.out.print("Subject " + i + ": ");
            int mark = input.nextInt();
            sumMarks += mark;
        }

        double average = (double) sumMarks / subjectCount;

        String resultGrade = calculateGrade(average);

        System.out.println("\n----------- Result Summary -----------");
        System.out.println("Total Marks Obtained : " + sumMarks);
        System.out.printf("Average Percentage   : %.2f %%\n", average);
        System.out.println("Final Grade          : " + resultGrade);
        System.out.println("--------------------------------------");

        input.close();
    }

    public static String calculateGrade(double avg) {

        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else if (avg >= 40) {
            return "E";
        } else {
            return "Fail (F)";
        }
    }
}
