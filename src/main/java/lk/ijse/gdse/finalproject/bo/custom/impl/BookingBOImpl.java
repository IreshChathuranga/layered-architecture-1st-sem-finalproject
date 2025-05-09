package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.BookingBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.BookingDAO;
import lk.ijse.gdse.finalproject.dao.custom.BookingDetailsDAO;
import lk.ijse.gdse.finalproject.dao.custom.ChooseTrainerDAO;
import lk.ijse.gdse.finalproject.dao.custom.LessonsDAO;
import lk.ijse.gdse.finalproject.db.DBConnection;
import lk.ijse.gdse.finalproject.dto.BookingDto;
import lk.ijse.gdse.finalproject.entity.Booking;


import java.sql.Connection;
import java.sql.SQLException;

public class BookingBOImpl implements BookingBO {
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);//property injection
    BookingDetailsDAO bookingDetailsDAO=(BookingDetailsDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING_DETAILS);
    LessonsDAO lessonsDAO = (LessonsDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LESSONS);
    ChooseTrainerDAO chooseTrainerDAO = (ChooseTrainerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CHOOSE_TRAINER);
    @Override
    public String getNextBookingId() throws SQLException, ClassNotFoundException {
       return bookingDAO.getNextId();
    }

    @Override
    public boolean savePlaceBooking(BookingDto bookingDto) throws SQLException, ClassNotFoundException {
        //        Transtarction
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            boolean isBookingSaved = bookingDAO.save(new Booking(bookingDto.getBookId(),bookingDto.getBookDate(),bookingDto.getBookTime(),bookingDto.getRescheduleReason()));
            if (isBookingSaved) {
                boolean isBookingDetailsSaved = bookingDetailsDAO.saveList(bookingDto.getBookingDetailsDTOS());
                if (isBookingDetailsSaved) {
                    boolean isLessonsSaved = lessonsDAO.saveList(bookingDto.getLessonsDTOS());
                    if (isLessonsSaved) {
                        boolean isChooseTrainerSaved =  chooseTrainerDAO.saveList(bookingDto.getChooseTrainerDTOS());
                        if(isChooseTrainerSaved){
                            connection.commit();
                            return true;
                        }
                    }
                }
            }
            connection.rollback();
            return false;
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            return false;
        } finally {
            connection.setAutoCommit(true);
    }
    }


}
