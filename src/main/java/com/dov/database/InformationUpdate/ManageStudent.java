package com.dov.database.InformationUpdate;

import java.util.Scanner;

public class ManageStudent {
    private static Scanner scanner = new Scanner(System.in);

    public static void manageStudents() {
        int option;

        do {
            System.out.println("Manage Students Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Back to Information Menu");
            System.out.print("Choose what you want to do with students: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Returning to Information Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);
    }

    private static void addStudent() {
        // Logic to add a student
    }

    private static void updateStudent() {
        // Logic to update a student
    }

    private static void deleteStudent() {
        // Logic to delete a student
    }
}
