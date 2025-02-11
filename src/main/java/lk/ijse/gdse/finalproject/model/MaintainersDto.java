package lk.ijse.gdse.finalproject.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MaintainersDto {
    private String maintainId;
    private String maintainName;
    private String maintainTask;
    private int contactNumber;
}
