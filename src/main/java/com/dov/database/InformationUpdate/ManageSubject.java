package com.dov.database.InformationUpdate;

import com.dov.database.*;

import java.util.Scanner;

public class ManageSubject {
    private static Scanner scanner = new Scanner(System.in);
    private static SubjectDAO subjectDao = new SubjectDAOImpl();

    public static void manageSubjects() {
        int option;

        do {
            System.out.println("Manage Subjects Menu:");
            System.out.println("1. Add Subject");
            System.out.println("2. Update Subject");
            System.out.println("3. Delete Subject");
            System.out.println("4. Back to Information Menu");
            System.out.print("Choose what you want to do with subjects: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    updateSubject();
                    break;
                case 3:
                    deleteSubject();
                    break;
                case 4:
                    System.out.println("Returning to Information Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);
    }

    private static void addSubject() {
        // Logic to add a subject
    }

    private static void updateSubject() {
        // Logic to update a subject
    }

    private static void deleteSubject() {
        // Logic to delete a subject
    }
}