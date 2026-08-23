package service;

import exception.StudentNotFoundException;
import model.Student;
import util.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentService {

    private ArrayList<Student> students;

    public StudentService() {
        students = FileHandler.loadStudents();
    }

    // CREATE
    public void addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);

        FileHandler.saveStudents(students);

        System.out.println("Student added successfully.");
    }

    // READ
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n---------------- STUDENT RECORDS ----------------");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("--------------------------------------------------");
    }

    // SEARCH
    public Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void searchStudent(int id) throws StudentNotFoundException {

        Student student = findStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(
                    "Student with ID " + id + " not found."
            );
        }

        System.out.println("\nStudent Found:");
        System.out.println(student);
    }

    // UPDATE
    public void updateStudent(
            int id,
            String name,
            int age,
            String course,
            double marks
    ) throws StudentNotFoundException {

        Student student = findStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(
                    "Student with ID " + id + " not found."
            );
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setMarks(marks);

        FileHandler.saveStudents(students);

        System.out.println("Student updated successfully.");
    }

    // DELETE
    public void deleteStudent(int id) throws StudentNotFoundException {

        Student student = findStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(
                    "Student with ID " + id + " not found."
            );
        }

        students.remove(student);

        FileHandler.saveStudents(students);

        System.out.println("Student deleted successfully.");
    }

    // SORT BY MARKS
    public void sortByMarks() {

        students.sort(
                Comparator.comparingDouble(Student::getMarks).reversed()
        );

        System.out.println("\nStudents sorted by marks:");
        displayStudents();
    }

    // TOTAL STUDENTS
    public int getStudentCount() {
        return students.size();
    }
}