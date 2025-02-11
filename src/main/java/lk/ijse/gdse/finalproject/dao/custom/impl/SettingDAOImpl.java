package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.SettingDAO;
import lk.ijse.gdse.finalproject.entity.Setting;
import lk.ijse.gdse.finalproject.model.SettingDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SettingDAOImpl implements SettingDAO {
    @Override
    public SettingDto getSignupDetails() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from signup LIMIT 1");
        if (rst.next()) {
            return new SettingDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }
    @Override
    public boolean update(Setting entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update signup set user_name=?, contact_number=?,  user_address=?, userpassword=? where username=?",
                entity.getName(),
                entity.getContactNumber(),
                entity.getAddress(),
                entity.getPassword(),
                entity.getUserName()
        );
    }

    @Override
    public boolean saveList(ArrayList<Setting> entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Setting> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Setting entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

}
