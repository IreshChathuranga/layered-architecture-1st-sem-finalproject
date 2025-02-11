package lk.ijse.gdse.finalproject.dao;

import lk.ijse.gdse.finalproject.model.ChooseTrainerDto;
import lk.ijse.gdse.finalproject.model.CoursesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    String getNextId() throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean saveList(ArrayList<T> chooseTrainerDTOS) throws SQLException, ClassNotFoundException;
}
