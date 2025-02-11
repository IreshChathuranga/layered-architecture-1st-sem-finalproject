package lk.ijse.gdse.finalproject.model.tm;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookedTM {
    private String bookId;
    private Date bookDate;
    private String bookTime;
    private String rescheduleReason;
}
