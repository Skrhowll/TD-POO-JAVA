package com.dov.database.Fonction;

import com.dov.database.Student;

public class BestStudentBySubject {
    private String subjectId;
    private String studentId;
    private double highestGrade;

    public BestStudentBySubject(String subjectId, Student studentId, double highestGrade) {
        this.subjectId = subjectId;
        this.studentId = String.valueOf(studentId);
        this.highestGrade = highestGrade;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getHighestGrade() {
        return highestGrade;
    }

    public void setHighestGrade(double highestGrade) {
        this.highestGrade = highestGrade;
    }

    @Override
    public String toString() {
        return "N°1 student with id{" +
                "subjectId='" + subjectId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", highestGrade=" + highestGrade +
                '}';
    }

}
