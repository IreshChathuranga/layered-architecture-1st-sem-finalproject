package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.SigninDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginBO extends SuperBO {
    ArrayList<SigninDto> loadAdminData() throws SQLException, ClassNotFoundException;
}
