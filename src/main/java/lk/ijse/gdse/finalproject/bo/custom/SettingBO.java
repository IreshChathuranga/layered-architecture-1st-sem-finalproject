package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.SettingDto;

import java.sql.SQLException;

public interface SettingBO extends SuperBO {
    public SettingDto getSignupDetails() throws SQLException, ClassNotFoundException;
    public boolean editSignup(SettingDto settingDto) throws SQLException, ClassNotFoundException;
}
