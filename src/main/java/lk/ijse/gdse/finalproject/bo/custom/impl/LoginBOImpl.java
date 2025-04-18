package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.LoginBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.SigninDAO;
import lk.ijse.gdse.finalproject.entity.Signin;
import lk.ijse.gdse.finalproject.dto.SigninDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBOImpl implements LoginBO {
    SigninDAO signinDAO = (SigninDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SIGNIN);

    @Override
    public ArrayList<SigninDto> loadAdminData() throws SQLException, ClassNotFoundException {
        ArrayList<Signin> signin = signinDAO.getAll();
        ArrayList<SigninDto> signinDtos = new ArrayList<>();
        for (Signin sign : signin) {
            signinDtos.add(new SigninDto(sign.getName(), sign.getUserName(), sign.getContactNumber(), sign.getUserAddress(), sign.getUserPassword()));
        };
        return signinDtos;
    }
}
