package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.BookingDto;

import java.sql.SQLException;

public interface BookingBO extends SuperBO {
    public String getNextBookingId() throws SQLException, ClassNotFoundException;
    public boolean savePlaceBooking(BookingDto bookingDto) throws SQLException, ClassNotFoundException;

}
