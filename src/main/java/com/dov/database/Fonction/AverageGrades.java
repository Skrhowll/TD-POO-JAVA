package com.dov.database.Fonction;

import com.dov.database.Fonction.SubjectAverageGrade;
import com.dov.database.Grade;
import com.dov.database.GradeDAO;
import com.dov.database.GradeDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageGrades {

    private GradeDAO gradeDao;

    public AverageGrades() {
        this.gradeDao = new GradeDAOImpl(); // Initialisation du DAO
    }

    public List<SubjectAverageGrade> getAverageGradesBySubject() throws SQLException {
        List<Grade> grades = gradeDao.getAllGrades();

        Map<String, Integer> sumGradesBySubject = new HashMap<>();
        Map<String, Integer> countGradesBySubject = new HashMap<>();

        for (Grade grade : grades) {
            String subjectId = grade.getSubjectId();
            int gradeValue = grade.getGrade();
            sumGradesBySubject.put(subjectId, sumGradesBySubject.getOrDefault(subjectId, 0) + gradeValue);
            countGradesBySubject.put(subjectId, countGradesBySubject.getOrDefault(subjectId, 0) + 1);
        }

        List<SubjectAverageGrade> averageGradesBySubject = new ArrayList<>();

        for (String subjectId : sumGradesBySubject.keySet()) {
            int sum = sumGradesBySubject.get(subjectId);
            int count = countGradesBySubject.get(subjectId);
            double average = (double) sum / count;
            averageGradesBySubject.add(new SubjectAverageGrade(subjectId, average));
        }

        return averageGradesBySubject;
    }
}
