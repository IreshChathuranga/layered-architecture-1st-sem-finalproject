package lk.ijse.gdse.finalproject.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booked {

        private String bookId;
        private Date bookDate;
        private String bookTime;
        private String rescheduleReason;

}
