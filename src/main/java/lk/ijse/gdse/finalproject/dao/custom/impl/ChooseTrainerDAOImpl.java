package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.ChooseTrainerDAO;
import lk.ijse.gdse.finalproject.entity.ChooseTrainer;
import lk.ijse.gdse.finalproject.model.ChooseTrainerDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChooseTrainerDAOImpl implements ChooseTrainerDAO {
    @Override
    public boolean saveList(ArrayList<ChooseTrainer> entity) throws SQLException, ClassNotFoundException {
        for (ChooseTrainer chooseTrainer : entity) {
//            ChooseTrainer chooseTrainer = new ChooseTrainer(
//                    chooseTrainerDto.getBookId(),
//                    chooseTrainerDto.getInstructorId());
            boolean isChooseTrainerSaved = save(chooseTrainer);
            if (!isChooseTrainerSaved) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean save(ChooseTrainer entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into choose_trainer values (?, ?)",
                entity.getBookId(),
                entity.getInstructorId());
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ChooseTrainer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ChooseTrainer entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
