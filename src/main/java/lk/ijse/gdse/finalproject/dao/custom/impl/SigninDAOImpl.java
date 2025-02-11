package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.SigninDAO;
import lk.ijse.gdse.finalproject.entity.Instructors;
import lk.ijse.gdse.finalproject.model.SigninDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;
import lk.ijse.gdse.finalproject.entity.Signin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SigninDAOImpl implements SigninDAO {
    @Override
    public boolean save(Signin entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved = CrudUtil.execute("insert into signup values(?,?,?,?,?)",
                entity.getName(),
                entity.getUserName(),
                entity.getContactNumber(),
                entity.getUserAddress(),
                entity.getUserPassword()
        );
        return isSaved;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Signin> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from signup");
        ArrayList<Signin> signinsDtos = new ArrayList<>();
        while (rst.next()){
            Signin signin =  new Signin(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4),
                    rst.getString(5));
            signinsDtos.add(signin);
        }
        return signinsDtos;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Signin entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveList(ArrayList<Signin> entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
