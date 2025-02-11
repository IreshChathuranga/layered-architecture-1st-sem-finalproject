package lk.ijse.gdse.finalproject.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Instructors {
    private String instructorId;
    private String instructorName;
    private int instructorAge;
    private String instructorAddress;
    private String certificationDetail;
    private String adminId;
}