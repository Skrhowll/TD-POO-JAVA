package com.dov.database.InformationUpdate;

import com.dov.database.*;

import java.util.Scanner;

public class InformationUpdate {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDao = new StudentDAOImpl();
    private static GradeDAO gradeDao = new GradeDAOImpl();
    private static SubjectDAO subjectDao =  new SubjectDAOImpl();

    public static void manageInformation() {
        int option;

        do {
            System.out.println("Manage Information Menu:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Grades");
            System.out.println("3. Manage Subjects");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose what you want to manage: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    ManageStudent.manageStudents(); // Appel au sous-menu ManageStudent
                    break;
                case 2:
                    ManageGrade.manageGrades();
                    break;
                case 3:
                    ManageSubject.manageSubjects();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);
    }
}
