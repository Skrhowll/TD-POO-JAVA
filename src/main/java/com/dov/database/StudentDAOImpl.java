package com.dov.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) throws ClassNotFoundException, SQLException {
        StudentDBConfig studentDBConfig = new StudentDBConfig();
        try (Connection connection = studentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, firstName, lastName) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void deleteStudent(int id) throws ClassNotFoundException {
        StudentDBConfig studentDBConfig = new StudentDBConfig();
        try (Connection connection = studentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(int id, String newFirstName, String newLastName) throws SQLException, ClassNotFoundException {
        StudentDBConfig studentDBConfig = new StudentDBConfig();
        try (Connection connection = studentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET firstName = ?, lastName = ? WHERE id = ?")) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, newLastName);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }
    @Override
    public Student getStudentById(String studentId) throws ClassNotFoundException, SQLException {
        try (Connection connection = StudentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id = ?")) {
            preparedStatement.setString(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                return new Student(id, firstName, lastName);
            }
        }
        return null;
    }
}

