package lk.ijse.gdse.finalproject.model.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleTM {
    private String vehicleId;
    private String vehicleType;
    private double lessonFee;
    private String adminId;
}
