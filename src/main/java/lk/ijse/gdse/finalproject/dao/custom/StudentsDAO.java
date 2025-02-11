package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Students;
import lk.ijse.gdse.finalproject.model.StudentsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentsDAO extends CrudDAO<Students> {
    ArrayList<String> getAllStudentIds() throws SQLException, ClassNotFoundException;
    StudentsDto findById(String selectedStudentId) throws SQLException, ClassNotFoundException;
}
