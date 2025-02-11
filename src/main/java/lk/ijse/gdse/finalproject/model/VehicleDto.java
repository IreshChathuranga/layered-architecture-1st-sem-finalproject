package lk.ijse.gdse.finalproject.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleDto {
    private String vehicleId;
    private String vehicleType;
    private double lessonFee;
    private String adminId;
}
