package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.SigninBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.SigninDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.SigninDAOImpl;
import lk.ijse.gdse.finalproject.entity.Signin;
import lk.ijse.gdse.finalproject.model.SigninDto;

import java.sql.SQLException;

public class SigninBOImpl implements SigninBO {
    SigninDAO signinDAO = (SigninDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SIGNIN);
    @Override
    public boolean saveAdmin(SigninDto signinDto) throws SQLException, ClassNotFoundException {
        return signinDAO.save(new Signin(
                signinDto.getName(),
                signinDto.getUserName(),
                signinDto.getContactNumber(),
                signinDto.getUserAddress(),
                signinDto.getUserPassword()
        ));
    }
}
