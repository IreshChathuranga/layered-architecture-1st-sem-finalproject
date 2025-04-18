package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.BookedBO;
import lk.ijse.gdse.finalproject.dao.custom.BookedDAO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.entity.Booked;
import lk.ijse.gdse.finalproject.dto.BookedDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookedBOImpl implements BookedBO {
    BookedDAO bookedDAO = (BookedDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKED);
    @Override
    public ArrayList<BookedDto> getAllBooking() throws SQLException, ClassNotFoundException {
        ArrayList<BookedDto> bookedDtos = new ArrayList<>();
        for (Booked booked : bookedDAO.getAll()) {
            bookedDtos.add(new BookedDto(
                booked.getBookId(),
                booked.getBookDate(),
                booked.getBookTime(),
                booked.getRescheduleReason()
            ));
        }
        return bookedDtos;
    }
}
