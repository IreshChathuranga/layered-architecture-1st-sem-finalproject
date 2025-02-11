package lk.ijse.gdse.finalproject.entity;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment{
    private String payId;
    private Date payDate;
    private String payMethod;
    private String adminId;
}

