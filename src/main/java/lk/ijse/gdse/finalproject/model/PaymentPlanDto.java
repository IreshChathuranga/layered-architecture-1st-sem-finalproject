package lk.ijse.gdse.finalproject.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PaymentPlanDto {
    private String payplanId;
    private double amount;
    private int rate;
    private double ratePrice;
    private String description ;
    private String payId;
}
