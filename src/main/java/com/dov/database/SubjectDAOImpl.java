package com.dov.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public boolean addSubject(String name, int factor) throws SQLException, ClassNotFoundException {
        try (Connection connection = StudentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subject (name, factor) VALUES (?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, factor);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public List<Subject> getAllSubjects() throws SQLException, ClassNotFoundException {
        List<Subject> subjects = new ArrayList<>();
        try (Connection connection = StudentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM subject")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int factor = resultSet.getInt("factor");
                subjects.add(new Subject(id, name, factor));
            }
        }
        return subjects;
    }

    @Override
    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException {
        try (Connection connection = StudentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM subject WHERE id = ?")) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public boolean updateSubject(String id, String newName, int newFactor) throws SQLException, ClassNotFoundException {
        try (Connection connection = StudentDBConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE subject SET name = ?, factor = ? WHERE id = ?")) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newFactor);
            preparedStatement.setString(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
