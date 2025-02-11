package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.SettingBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.SettingDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.SettingDAOImpl;
import lk.ijse.gdse.finalproject.entity.Salary;
import lk.ijse.gdse.finalproject.entity.Setting;
import lk.ijse.gdse.finalproject.model.SettingDto;

import java.sql.SQLException;

public class SettingBOImpl implements SettingBO {
    SettingDAO settingDAO = (SettingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SETTING);
    @Override
    public SettingDto getSignupDetails() throws SQLException, ClassNotFoundException {
        return settingDAO.getSignupDetails();
    }
    @Override
    public boolean editSignup(SettingDto settingDto) throws SQLException, ClassNotFoundException {
        return settingDAO.update(new Setting(
                settingDto.getName(),
                settingDto.getUserName(),
                settingDto.getContactNumber(),
                settingDto.getAddress(),
                settingDto.getPassword()
        ));
    }
}
