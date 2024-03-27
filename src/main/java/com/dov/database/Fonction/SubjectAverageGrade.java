package com.dov.database.Fonction;

public class SubjectAverageGrade {
    private String subjectId;
    private double averageGrade;

    public SubjectAverageGrade(String subjectId, double averageGrade) {
        this.subjectId = subjectId;
        this.averageGrade = averageGrade;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}
