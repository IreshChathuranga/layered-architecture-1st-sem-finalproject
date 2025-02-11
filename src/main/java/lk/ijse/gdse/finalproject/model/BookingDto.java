package lk.ijse.gdse.finalproject.model;

import lk.ijse.gdse.finalproject.entity.BookingDetails;
import lk.ijse.gdse.finalproject.entity.ChooseTrainer;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDto {
    private String bookId;
    private Date bookDate;
    private String bookTime;
    private String rescheduleReason;
    private ArrayList<BookingDetails> bookingDetailsDTOS;
    private ArrayList<Lessons> lessonsDTOS;
    private ArrayList<ChooseTrainer> chooseTrainerDTOS;

}
