package lk.ijse.gdse.finalproject.model;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookedDto {
    private String bookId;
    private Date bookDate;
    private String bookTime;
    private String rescheduleReason;
}
