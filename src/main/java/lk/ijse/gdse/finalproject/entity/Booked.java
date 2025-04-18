package lk.ijse.gdse.finalproject.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter//setter method true injection
@AllArgsConstructor//constructor injection
@NoArgsConstructor//constructor injection
@ToString
public class Booked {

        private String bookId;//property injection
        private Date bookDate;
        private String bookTime;
        private String rescheduleReason;

}
