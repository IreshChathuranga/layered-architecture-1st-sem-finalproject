package lk.ijse.gdse.finalproject.model.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SigninTM {
    private String name;
    private String userName;
    private int contactNumber;
    private String userAddress;
    private String userPassword;
}
