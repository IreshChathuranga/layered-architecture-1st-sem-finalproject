package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.BookingDetailsDAO;
import lk.ijse.gdse.finalproject.entity.BookingDetails;
import lk.ijse.gdse.finalproject.model.BookingDetailsDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDetailsDAOImpl implements BookingDetailsDAO {
    @Override
    public boolean saveList(ArrayList<BookingDetails> bookingDetailsDTOS) throws SQLException, ClassNotFoundException {
        for (BookingDetails bookingDetails : bookingDetailsDTOS) {
            boolean isBookingDetailsSaved = save(bookingDetails);
            if (!isBookingDetailsSaved) {
                return false;
            }
        }
        return true;
}

    @Override
    public boolean save(BookingDetails entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "insert into booking_details values (?, ?)",
                entity.getBookId(),
                entity.getStudentId()
        );
    }


    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<BookingDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(BookingDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
