package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.StudentsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentsBO extends SuperBO {
    public String getNextStuentId() throws SQLException, ClassNotFoundException;
    public ArrayList<StudentsDto> getAllStudents() throws SQLException, ClassNotFoundException;
    public boolean saveStudent(StudentsDto studentsDto) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(StudentsDto studentsDto) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllStudentIds() throws SQLException, ClassNotFoundException;
    public StudentsDto findById(String selectedStudentId) throws SQLException, ClassNotFoundException;
}
