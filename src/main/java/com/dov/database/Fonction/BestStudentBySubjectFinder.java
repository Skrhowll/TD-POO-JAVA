package com.dov.database.Fonction;

import com.dov.database.Grade;
import com.dov.database.GradeDAO;
import com.dov.database.GradeDAOImpl;
import com.dov.database.Student;
import com.dov.database.StudentDAO;
import com.dov.database.StudentDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestStudentBySubjectFinder {

    private static GradeDAO gradeDao = new GradeDAOImpl();
    private static StudentDAO studentDao = new StudentDAOImpl();

    public static List<BestStudentBySubject> findBestStudentsBySubject() throws SQLException, ClassNotFoundException {
        List<Grade> grades = gradeDao.getAllGrades();
        Map<String, Double> averageGradeBySubject = new HashMap<>();
        Map<String, Student> bestStudentBySubject = new HashMap<>();

        // Calculer la moyenne des notes par matière
        for (Grade grade : grades) {
            String subjectId = grade.getSubjectId();
            double gradeValue = grade.getGrade();
            if (!averageGradeBySubject.containsKey(subjectId)) {
                averageGradeBySubject.put(subjectId, gradeValue);
                try {
                    bestStudentBySubject.put(subjectId, studentDao.getStudentById(grade.getStudentId()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                double currentAverage = averageGradeBySubject.get(subjectId);
                averageGradeBySubject.put(subjectId, currentAverage + gradeValue);
            }
        }

        // Trouver le meilleur étudiant par matière
        List<BestStudentBySubject> bestStudents = new ArrayList<>();
        for (String subjectId : averageGradeBySubject.keySet()) {
            double averageGrade = averageGradeBySubject.get(subjectId) / grades.size();
            Student bestStudent = bestStudentBySubject.get(subjectId);
            bestStudents.add(new BestStudentBySubject(subjectId, bestStudent, averageGrade));
        }

        return bestStudents;
    }
}
