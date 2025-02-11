package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.model.SigninDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.SQLException;

public interface SigninBO extends SuperBO {
    public boolean saveAdmin(SigninDto signinDto) throws SQLException, ClassNotFoundException;
}
