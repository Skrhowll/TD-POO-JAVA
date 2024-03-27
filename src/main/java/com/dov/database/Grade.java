package com.dov.database;

public class Grade {
    private String studentId;
    private String subjectId;
    private int grade;

    // Constructor
    public Grade(String studentId, String subjectId, int grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.grade = grade;
    }

    public Grade(String subjectId, int grade) {
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public class StudentSubjectAverageGrade {
        private String firstName;
        private String subjectId;
        private double averageGrade;

        // Constructeur, getters et setters
        // ...

        @Override
        public String toString() {
            return "Student Name: " + firstName + ", Subject ID: " + subjectId + ", Average Grade: " + averageGrade;
        }
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentId='" + studentId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", grade=" + grade +
                '}';
    }
}

