package com.dov.database;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student student) throws ClassNotFoundException, SQLException;
    List<Student> getAllStudents() throws ClassNotFoundException, SQLException;
    void deleteStudent(int id) throws SQLException, ClassNotFoundException;
    void updateStudent(int id, String firstName, String lastName) throws SQLException, ClassNotFoundException;

    Student getStudentById(String studentId) throws ClassNotFoundException, SQLException;
}

