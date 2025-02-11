package lk.ijse.gdse.finalproject.model.tm;

import javafx.scene.control.Button;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartTM {
    private String bookId;
    private Date bookDate;
    private String bookTime;
    private String studentId;
    private String instructorId;
    private String lessonName;
    private String timePeriod;
    private String rescheduleReason;
    private Button removeBtn;
}
