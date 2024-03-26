import java.util.*;

class Student {
    private int identifier;
    private String name;
    private int[] grades;
    private int numOfGrades;

    public Student(int identifier, String name) {
        this.identifier = identifier;
        this.name = name;
        this.grades = new int[5];
        this.numOfGrades = 0;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        if (numOfGrades < grades.length) {
            grades[numOfGrades++] = grade;
        } else {
            System.out.println("Cannot add more grades for " + name + " . Limit Reached");
        }
    }

    public double getAverageGrade() {
        if (numOfGrades == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < numOfGrades; i++) {
            sum = sum + grades[i];
        }
        return (double) sum / numOfGrades;
    }

    public int[] getGrades() {
        return grades;
    }

    public int getNumOfGrades() {
        return numOfGrades;
    }
}

public class Grade_Book_Manager {
    private static int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Grade Book Manager : ");
        while (!exit) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a new student ");
            System.out.println("2. Enter grades for a student");
            System.out.println("3. Calculate average grade for each student");
            System.out.println("4. Calculate average grade for each subject");
            System.out.println("5. Search for a student");
            System.out.println("6. Sort students by average grade");
            System.out.println("7. Display class summary");
            System.out.println("8. Exit");

            System.out.println("\nEnter your choice (1-8): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    enterGrades(scanner);
                    break;
                case 3:
                    // calculateAverageGradesForEachStudent(scanner);
                    break;
                case 4:
                    // calculateAverageGradesForEachSubject(scanner);
                    break;
                case 5:
                    // searchForStudent(scanner);
                    break;
                case 6:
                    // sortStudentsByAverageGrade(scanner);
                    break;
                case 7:
                    // displayClassSummary(scanner);
                    break;

                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice , Please select valid option .");
            }

            if (!exit) {
                System.out.println("\nDo you want to perform another action? (yes/no):");
                String continueAction = scanner.next();
                exit = !continueAction.equalsIgnoreCase("yes");
            }

        }
        System.out.println("Thank you for using the Gradebook Manager!");
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student identifier (e.g., roll number):");
        int identifier = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        students[numStudents] = new Student(identifier, name);
        numStudents++;
        System.out.println("Student with identifier" + identifier + " added successfully!");
    }

    private static void enterGrades(Scanner scanner) {
        System.out.print("Enter student identifier (e.g., roll number):");
        int identifier = scanner.nextInt();
        int studentIndex = findStudentIndexByIdentifier(identifier);
        if (studentIndex == -1) {
            System.out.println("Student with identifier" + identifier + " not found");
            return;
        }
        Student student = students[studentIndex];
        System.out.print("Enter subject (e.g., Math, Science, History, etc.):");
        String subject = scanner.next();

        System.out.print("Enter grade for " + subject + "(0-100):");

        int grade = scanner.nextInt();
        student.addGrade(grade);
        System.out.println("Grades for student " + identifier + " in " + subject + "added successfully!");

    }

    private static int findStudentIndexByIdentifier(int identifier) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getIdentifier() == identifier) {
                return i;
            }
        }
        return -1;
    }

    private static void calculateAverageGradesForEachStudent() {
        for (int i = 0; i < numStudents; i++) {
            Student student = students[i];
            double averageGrade = student.getAverageGrade();
            System.out.println("Average grade for student" + student.getIdentifier() + " : " + averageGrade);
        }
    }

    private static void calculateAverageGradesForEachSubject() {
        System.out.print("Enter subject to calculate average grade : ");
        String subject = new Scanner(System.in).next();
        int totalGrades = 0;
        int totalStudentWithGrades = 0;
        for (int i = 0; i < numStudents; i++) {
            Student student = students[i];
            for (int j = 0; j < student.getNumOfGrades(); j++) {
                if (subject.equalsIgnoreCase("all") || subject.equalsIgnoreCase("total")) {
                    totalGrades = totalGrades + student.getGrades()[j];
                    totalStudentWithGrades++;

                } else if (subject.equalsIgnoreCase("none")) {
                    totalStudentWithGrades++;
                }
            }
        }

        if (totalStudentWithGrades == 0) {
            System.out.println("No students found with grades in " + subject + " : ");

        } else {
            double averageGrade = (double) totalGrades / totalStudentWithGrades;
            System.out.println("Average grade for " + subject + "across all students " + averageGrade);
        }

    }
}