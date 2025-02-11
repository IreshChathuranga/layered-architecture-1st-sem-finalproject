package lk.ijse.gdse.finalproject.entity;

import lk.ijse.gdse.finalproject.model.BookingDetailsDto;
import lk.ijse.gdse.finalproject.model.ChooseTrainerDto;
import lk.ijse.gdse.finalproject.model.LessonsDto;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking {
    private String bookId;
    private Date bookDate;

    public Booking(String bookId, Date bookDate, String bookTime, String rescheduleReason) {
        this.bookId = bookId;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
        this.rescheduleReason = rescheduleReason;
    }

    private String bookTime;
    private String rescheduleReason;


    private ArrayList<BookingDetails> bookingDetailsDTOS;
    private ArrayList<Lessons> lessonsDTOS;
    private ArrayList<ChooseTrainer> chooseTrainerDTOS;
}
