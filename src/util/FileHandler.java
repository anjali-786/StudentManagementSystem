package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_PATH = "data/students.txt";

    public static void saveStudents(List<Student> students) {

        File file = new File(FILE_PATH);

        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while saving students: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length != 5) {
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                students.add(
                        new Student(id, name, age, course, marks)
                );
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error while loading student data: " + e.getMessage()
            );
        }

        return students;
    }
}