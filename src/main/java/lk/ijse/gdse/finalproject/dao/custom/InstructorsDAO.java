package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Instructors;
import lk.ijse.gdse.finalproject.model.InstructorsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorsDAO extends CrudDAO<Instructors> {
    InstructorsDto findById(String selectedInstructorId) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllInstructorIds() throws SQLException, ClassNotFoundException;
}
