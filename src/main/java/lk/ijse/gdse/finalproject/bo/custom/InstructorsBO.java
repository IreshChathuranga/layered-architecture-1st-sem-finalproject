package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.InstructorsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorsBO extends SuperBO {
    String getNextInstructorId() throws SQLException, ClassNotFoundException;
    ArrayList<InstructorsDto> getAllInstructors() throws SQLException, ClassNotFoundException;
    boolean saveInstructor(InstructorsDto instructorsDto) throws SQLException, ClassNotFoundException;
    boolean deleteInstructor(String instructorId) throws SQLException, ClassNotFoundException;
    boolean updateInstructor(InstructorsDto instructorsDto) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllInstructorIds() throws SQLException, ClassNotFoundException;
    InstructorsDto findById(String selectedInstructorId) throws SQLException, ClassNotFoundException;
}
