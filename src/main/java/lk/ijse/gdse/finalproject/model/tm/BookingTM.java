package lk.ijse.gdse.finalproject.model.tm;

import lk.ijse.gdse.finalproject.model.BookingDetailsDto;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookingTM {
    private String bookId;
    private Date bookDate;
    private String bookTime;
    private String rescheduleReason;
    private ArrayList<BookingDetailsDto> bookingDetailsDtos;
}
