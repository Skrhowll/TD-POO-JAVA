package com.dov.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements GradeDAO {


    @Override
    public boolean addGrade(int studentId, int subjectId, int grade) throws SQLException {
        String query = "INSERT INTO grade (student_id, subject_id, grade) VALUES (?, ?, ?)";
        try (Connection connection = new StudentDBConfig().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, subjectId);
            preparedStatement.setInt(3, grade);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteGrade(String studentId, String subjectId) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean updateGrade(String studentId, String subjectId, int newGrade) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public List<Grade> getAllGradesBySubject() throws ClassNotFoundException, SQLException {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT subject_id, grade FROM grade";
        StudentDBConfig studentDBConfig = new StudentDBConfig();

        try (Connection connection = studentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String subjectId = resultSet.getString("subject_id");
                int grade = resultSet.getInt("grade");
                grades.add(new Grade(subjectId, grade));
            }
        }

        return grades;
    }

    @Override
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM grade";

        try (Connection connection = new StudentDBConfig().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String subjectId = resultSet.getString("subject_id");
                int gradeValue = resultSet.getInt("grade");
                Grade grade = new Grade(studentId, subjectId, gradeValue);
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return grades;
    }

}
