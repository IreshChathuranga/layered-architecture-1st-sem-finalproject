package lk.ijse.gdse.finalproject.bo.custom;

import javafx.event.ActionEvent;
import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.db.DBConnection;
import lk.ijse.gdse.finalproject.model.BookingDetailsDto;
import lk.ijse.gdse.finalproject.model.BookingDto;
import lk.ijse.gdse.finalproject.model.ChooseTrainerDto;
import lk.ijse.gdse.finalproject.model.LessonsDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookingBO extends SuperBO {
    public String getNextBookingId() throws SQLException, ClassNotFoundException;
    public boolean savePlaceBooking(BookingDto bookingDto) throws SQLException, ClassNotFoundException;

}
