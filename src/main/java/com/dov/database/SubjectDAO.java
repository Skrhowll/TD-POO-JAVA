package com.dov.database;

import java.sql.SQLException;
import java.util.List;

public interface SubjectDAO {
    boolean addSubject(String name, int factor) throws SQLException, ClassNotFoundException;
    List<Subject> getAllSubjects() throws SQLException, ClassNotFoundException;
    boolean deleteSubject(String id) throws SQLException, ClassNotFoundException;
    boolean updateSubject(String id, String newName, int newFactor) throws SQLException, ClassNotFoundException;
}
