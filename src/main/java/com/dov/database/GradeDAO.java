package com.dov.database;

import java.sql.SQLException;
import java.util.List;

public interface GradeDAO {

    boolean addGrade(int studentId, int subjectId, int grade) throws SQLException;
    boolean deleteGrade(String studentId, String subjectId) throws ClassNotFoundException, SQLException;

    boolean updateGrade(String studentId, String subjectId, int newGrade) throws ClassNotFoundException, SQLException;
    List<Grade> getAllGradesBySubject() throws ClassNotFoundException, SQLException;

    List<Grade> getAllGrades();
}
