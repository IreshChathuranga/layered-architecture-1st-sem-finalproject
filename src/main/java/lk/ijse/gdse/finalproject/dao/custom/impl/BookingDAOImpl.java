package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.BookingDAO;
import lk.ijse.gdse.finalproject.dao.custom.BookingDetailsDAO;
import lk.ijse.gdse.finalproject.dao.custom.ChooseTrainerDAO;
import lk.ijse.gdse.finalproject.dao.custom.LessonsDAO;
import lk.ijse.gdse.finalproject.db.DBConnection;
import lk.ijse.gdse.finalproject.entity.Booking;
import lk.ijse.gdse.finalproject.model.BookingDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAOImpl implements BookingDAO {
    private final BookingDetailsDAO bookingDetailsDAO= new BookingDetailsDAOImpl();
    private final LessonsDAO lessonsDAO= new LessonsDAOImpl();
    private final ChooseTrainerDAO chooseTrainerDAO = new ChooseTrainerDAOImpl();
    @Override
    public boolean save(Booking entity) throws SQLException, ClassNotFoundException {
            return CrudUtil.execute(
                    "insert into booking values (?, ?, ?, ?)",
                    entity.getBookId(), entity.getBookDate(), entity.getBookTime(), entity.getRescheduleReason());
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("select book_id from booking order by book_id desc limit 1");
        if(rst.next()){
           String lastId = rst.getString(1);
           String subString = lastId.substring(1);
           int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("B%03d",newIdIndex);
       }
        return  "B001";

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Booking entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveList(ArrayList<Booking> entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Booking> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
