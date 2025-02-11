package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.BookedDAO;
import lk.ijse.gdse.finalproject.entity.Booked;
import lk.ijse.gdse.finalproject.model.BookedDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookedDAOImpl implements BookedDAO {
    @Override
    public ArrayList<Booked> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from booking");
        ArrayList<Booked> bookedDtos = new ArrayList<>();
        while (rst.next()){
            Booked bookedDto = new Booked(
                    rst.getString(1),
                    rst.getDate(2),
                    rst.getString(3),
                    rst.getString(4));
            bookedDtos.add(bookedDto);
        }
        return bookedDtos;
    }
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Booked entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Booked entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveList(ArrayList<Booked> entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
