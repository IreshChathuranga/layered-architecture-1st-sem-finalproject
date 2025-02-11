package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Setting;
import lk.ijse.gdse.finalproject.model.SettingDto;

import java.sql.SQLException;

public interface SettingDAO extends CrudDAO<Setting> {
    SettingDto getSignupDetails() throws SQLException, ClassNotFoundException;
}
