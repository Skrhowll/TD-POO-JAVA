package com.dov.database;
import com.dov.database.Fonction.AverageGrades;
import com.dov.database.Fonction.BestStudentBySubject;
import com.dov.database.Fonction.BestStudentBySubjectFinder;
import com.dov.database.Fonction.SubjectAverageGrade;
import com.dov.database.InformationUpdate.InformationUpdate;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class StudentDBMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Manage Information");
            System.out.println("2. Average Grades");
            System.out.println("3. The Best of the Best per Subject");
            System.out.println("4. Needs to Improve to be a Goat");
            System.out.println("5. Modify an Already Entered Grade and don't cheat");
            System.out.println("6. Bye Bye");
            System.out.print("Choose what you want: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    InformationUpdate.manageInformation();
                    break;
                case 2:
                    try {
                        AverageGrades averageGrades = new AverageGrades();
                        List<SubjectAverageGrade> averageGradesList = averageGrades.getAverageGradesBySubject();
                        for (SubjectAverageGrade subjectAverageGrade : averageGradesList) {
                            System.out.println("Subject ID: " + subjectAverageGrade.getSubjectId() +
                                    ", Average Grade: " + subjectAverageGrade.getAverageGrade());
                        }
                    } catch (SQLException e) {
                        System.out.println("Stop trolling pls no grades: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<BestStudentBySubject> bestStudentsBySubject = BestStudentBySubjectFinder.findBestStudentsBySubject();
                        if (bestStudentsBySubject.isEmpty()) {
                            System.out.println("No data available for the best students by subject.");
                        } else {
                            System.out.println("Best Students by Subject:");
                            for (BestStudentBySubject bestStudent : bestStudentsBySubject) {
                                System.out.println(bestStudent);
                            }
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println("An error occurred while retrieving the best students by subject: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Handle option 4
                    break;
                case 5:
                    // Handle option 5
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 6);

        scanner.close();
    }
}


//package com.dov.database;
//
//import java.sql.SQLException;
//import java.util.*;
//
//public class StudentDBMain {
//    private static Scanner scanner = new Scanner(System.in);
//    private static StudentDAO studentDao = new StudentDAOImpl();
//    // Assuming GradeDAO and its implementation exist
//    private static GradeDAO gradeDao = new GradeDAOImpl(); // Make sure this is implemented
//
//    public static void main(String[] args) {
//        int option;
//
//        do {
//            System.out.println("1. Manage informations");
//            System.out.println("2. Average Grades");
//            System.out.println("3. The Best of the Best per Subject");
//            System.out.println("4. Needs to Improve to be a Goat");
//            System.out.println("5. Modify an Already Entered Grade and don't cheat");
//            System.out.println("6. Bye Bye");
//            System.out.print("Choose what you want: ");
//            option = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline
//
//            switch (option) {
//                case 1:
//                    addNewStudent();
//                    break;
//                case 2:
//                    AverageGrades();
//                    break;
//                case 3:
//
//                    break;
//                case 4:
//
//                    break;
//                case 5:
//                    break;
//                case 6:
//                    System.out.println("get out of here...");
//                    break;
//                default:
//                    System.out.println("You lost...I win");
//            }
//        } while (option != 6);
//
//        scanner.close();
//    }
//
//    private static void addNewStudent() {
//        System.out.println("Enter student ID:");
//        String id = scanner.nextLine();
//
//        System.out.println("Enter student first name:");
//        String firstName = scanner.nextLine();
//
//        System.out.println("Enter student last name:");
//        String lastName = scanner.nextLine();
//
//        Student newStudent = new Student(id, firstName, lastName);
//        try {
//            if (studentDao.addStudent(newStudent)) {
//                System.out.println("Slave Student added successfully.");
//            } else {
//                System.out.println("Failed to add strange things.");
//            }
//        } catch (Exception e) {
//            System.err.println("Error over 90000 " + e.getMessage());
//        }
//    }
//    private static void AverageGrades() {
//        try {
//            List<Grade> grades = gradeDao.getAllGradesBySubject();
//            Map<String, List<Integer>> gradesBySubject = new HashMap<>();
//
//            // Group grades by subject
//            for (Grade grade : grades) {
//                gradesBySubject.computeIfAbsent(grade.getSubjectId(), k -> new ArrayList<>()).add(grade.getGrade());
//            }
//            System.out.println("Average :");
//            gradesBySubject.forEach((subjectId, gradesList) -> {
//                double average = gradesList.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
//                System.out.printf("Subject ID: %s, Average Grade: %.2f%n", subjectId, average);
//            });
//        } catch (Exception e) {
//            System.err.println("Error calculating the average grades by subject: " + e.getMessage());
//        }
//    }
//    private static void AverageGradesBySubject() {
//        try {
//            // Example of adding subjects with incrementing factors
//            for (int i = 1; i <= 2; i++) {
//                SubjectDAO subjectDao = null;
//                subjectDao.addSubject("S" + i, i); // subjectDao is an instance of SubjectDAOImpl
//            }
//
//            // Example of adding a grade for a student to the first subject
//            int studentId = 1; // Assuming you have a student with ID 1
//            int subjectId = 1; // Assuming the first subject has ID 1
//            int grade = 85; // Example grade value
//            gradeDao.addGrade(studentId, subjectId, grade); // gradeDao is an instance of GradeDAOImpl
//
//            // Now calculate and display average grades by subject
//            List<Grade> grades = gradeDao.getAllGrades();
//            Map<String, Double> sumGradesBySubject = new HashMap<>();
//            Map<String, Integer> countGradesBySubject = new HashMap<>();
//
//            // Summing and counting grades for each subject
//            for (Grade gradeObj : grades) {
//                String subjId = gradeObj.getSubjectId();
//                sumGradesBySubject.merge(subjId, (double) gradeObj.getGrade(), Double::sum);
//                countGradesBySubject.merge(subjId, 1, Integer::sum);
//            }
//
//            // Calculating and displaying the average for each subject
//            System.out.println("Average grades by subject:");
//            sumGradesBySubject.forEach((subjId, sum) -> {
//                double average = sum / countGradesBySubject.get(subjId);
//                System.out.printf("Subject: %s, Average Grade: %.2f%n", subjId, average);
//            });
//
//        } catch (SQLException e) {
//            System.err.println("Error occurred: " + e.getMessage());
//        }
//    }

