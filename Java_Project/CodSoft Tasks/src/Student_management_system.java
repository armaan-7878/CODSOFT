import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Learner {

    private String studentName;
    private int studentId;
    private String studentGrade;

    public Learner(String name, int id, String grade) {
        this.studentName = name;
        this.studentId = id;
        this.studentGrade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getDetails() {
        return "Name: " + studentName +
               " | ID: " + studentId +
               " | Grade: " + studentGrade;
    }
}

class LearnerRecordSystem {

    private List<Learner> learnerList;

    public LearnerRecordSystem() {
        learnerList = new ArrayList<>();
    }

    public void insertLearner(Learner learner) {
        learnerList.add(learner);
    }

    public boolean deleteLearner(int id) {
        for (int i = 0; i < learnerList.size(); i++) {
            if (learnerList.get(i).getStudentId() == id) {
                learnerList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Learner findLearner(int id) {
        for (Learner learner : learnerList) {
            if (learner.getStudentId() == id) {
                return learner;
            }
        }
        return null;
    }

    public void showAllLearners() {
        if (learnerList.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("\n------ Student Records ------");
        for (Learner learner : learnerList) {
            System.out.println(learner.getDetails());
        }
    }
}

public class Student_management_system{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LearnerRecordSystem system = new LearnerRecordSystem();

        int selection;

        do {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add New Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your option: ");

            selection = input.nextInt();

            switch (selection) {

                case 1:
                    input.nextLine();
                    System.out.print("Enter student name: ");
                    String name = input.nextLine();

                    System.out.print("Enter student ID: ");
                    int id = input.nextInt();

                    input.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = input.nextLine();

                    system.insertLearner(new Learner(name, id, grade));
                    System.out.println("Student record added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = input.nextInt();

                    if (system.deleteLearner(removeId)) {
                        System.out.println("Student record removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = input.nextInt();

                    Learner found = system.findLearner(searchId);

                    if (found != null) {
                        System.out.println("Record Found:");
                        System.out.println(found.getDetails());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    system.showAllLearners();
                    break;

                case 5:
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (selection != 5);

        input.close();
    }
}
