package com.dov.database.InformationUpdate;

import com.dov.database.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ManageGrade {
    private static Scanner scanner = new Scanner(System.in);
    private static GradeDAO gradeDao = new GradeDAOImpl();

    public static void manageGrades() {
        int option;

        do {
            System.out.println("Manage Grades Menu:");
            System.out.println("1. Add Grade");
            System.out.println("2. Update Grade");
            System.out.println("3. Delete Grade");
            System.out.println("4. Back to Information Menu");
            System.out.print("Choose what you want to do with grades: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    updateGrade();
                    break;
                case 3:
                    deleteGrade();
                    break;
                case 4:
                    System.out.println("Returning to Information Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);
    }

    private static void addGrade() {
        try {
            System.out.println("Enter student ID:");
            int studentId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter subject ID:");
            int subjectId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter grade:");
            int grade = Integer.parseInt(scanner.nextLine());

            if (gradeDao.addGrade(studentId, subjectId, grade)) {
                System.out.println("Grade added successfully.");
            } else {
                System.out.println("Failed to add grade.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void updateGrade() {
        try {
            System.out.println("Enter student ID:");
            String studentId = scanner.nextLine();

            System.out.println("Enter subject ID:");
            String subjectId = scanner.nextLine();

            System.out.println("Enter new grade:");
            int newGrade = Integer.parseInt(scanner.nextLine());

            if (gradeDao.updateGrade(studentId, subjectId, newGrade)) {
                System.out.println("Grade updated successfully.");
            } else {
                System.out.println("Failed to update grade.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteGrade() {
        try {
            System.out.println("Enter student ID:");
            String studentId = (scanner.nextLine());

            System.out.println("Enter subject ID:");
            String subjectId = scanner.nextLine();

            if (gradeDao.deleteGrade(studentId, subjectId)) {
                System.out.println("Grade deleted successfully.");
            } else {
                System.out.println("Failed to delete grade.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
