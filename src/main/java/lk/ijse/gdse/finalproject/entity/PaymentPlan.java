package lk.ijse.gdse.finalproject.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PaymentPlan{
    private String payplanId;
    private double amount;
    private int rate;
    private double ratePrice;
    private String description ;
    private String payId;
}

