package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.BookedDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookedBO extends SuperBO {
    ArrayList<BookedDto> getAllBooking() throws SQLException, ClassNotFoundException;
}
