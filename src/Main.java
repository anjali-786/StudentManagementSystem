import exception.StudentNotFoundException;
import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService service = new StudentService();

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (true) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            try {

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        service.displayStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        service.sortByMarks();
                        break;

                    case 7:
                        System.out.println(
                                "\nTotal Students: "
                                        + service.getStudentCount()
                        );
                        break;

                    case 8:
                        System.out.println(
                                "\nThank you for using Student Management System!"
                        );

                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println(
                                "Invalid choice. Please enter 1-8."
                        );
                }

            } catch (StudentNotFoundException e) {

                System.out.println(
                        "\nError: " + e.getMessage()
                );

            } catch (Exception e) {

                System.out.println(
                        "\nUnexpected error: " + e.getMessage()
                );
            }
        }
    }

    private static void displayMenu() {

        System.out.println("\n--------------- MENU ----------------");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Sort Students by Marks");
        System.out.println("7. Count Students");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------");
    }

    private static void addStudent() {

        System.out.println("\n---------- ADD STUDENT ----------");

        int id = readInt("Enter Student ID: ");

        String name = readString("Enter Name: ");

        int age = readInt("Enter Age: ");

        String course = readString("Enter Course: ");

        double marks = readDouble("Enter Marks: ");

        if (age <= 0) {
            System.out.println("Age must be greater than 0.");
            return;
        }

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        Student student = new Student(
                id,
                name,
                age,
                course,
                marks
        );

        service.addStudent(student);
    }

    private static void searchStudent()
            throws StudentNotFoundException {

        System.out.println("\n---------- SEARCH STUDENT ----------");

        int id = readInt("Enter Student ID: ");

        service.searchStudent(id);
    }

    private static void updateStudent()
            throws StudentNotFoundException {

        System.out.println("\n---------- UPDATE STUDENT ----------");

        int id = readInt("Enter Student ID: ");

        String name = readString("Enter New Name: ");

        int age = readInt("Enter New Age: ");

        String course = readString("Enter New Course: ");

        double marks = readDouble("Enter New Marks: ");

        if (age <= 0) {
            System.out.println("Age must be greater than 0.");
            return;
        }

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }

        service.updateStudent(
                id,
                name,
                age,
                course,
                marks
        );
    }

    private static void deleteStudent()
            throws StudentNotFoundException {

        System.out.println("\n---------- DELETE STUDENT ----------");

        int id = readInt("Enter Student ID: ");

        service.deleteStudent(id);
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}