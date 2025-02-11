package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.InstructorsDAO;
import lk.ijse.gdse.finalproject.entity.Instructors;
import lk.ijse.gdse.finalproject.model.InstructorsDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorsDAOImpl implements InstructorsDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("select instru_id from instructor order by instru_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("I%03d",newIdIndex);
        }
        return  "I001";

    }
    @Override
    public ArrayList<Instructors> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from instructor");
        ArrayList<Instructors> instructorsDtos = new ArrayList<>();
        while (rst.next()){
            Instructors instructorsDto =  new Instructors(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
            instructorsDtos.add(instructorsDto);
        }
        return instructorsDtos;
    }
    @Override
    public boolean save(Instructors entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved=CrudUtil.execute("insert into instructor values(?,?,?,?,?,?)", entity.getInstructorId(),entity.getInstructorName(),entity.getInstructorAge(),entity.getInstructorAddress(),entity.getCertificationDetail(),entity.getAdminId());

        return  isSaved;
    }
    @Override
    public boolean delete(String instructorId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from instructor where instru_id=?", instructorId);
    }
    @Override
    public boolean update(Instructors entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update instructor set  instru_name=?, instru_age=?,  instru_address=?,  certification_detail=?, admin_id=? where instru_id=?",
                entity.getInstructorName(),
                entity.getInstructorAge(),
                entity.getInstructorAddress(),
                entity.getCertificationDetail(),
                entity.getAdminId(),
                entity.getInstructorId()
        );
    }

    @Override
    public boolean saveList(ArrayList<Instructors> entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllInstructorIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select instru_id from instructor");

        ArrayList<String> instructorIds = new ArrayList<>();

        while (rst.next()){
            instructorIds.add(rst.getString(1));
        }

        return instructorIds;
    }
    @Override
    public InstructorsDto findById(String selectedInstructorId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from instructor where instru_id=?", selectedInstructorId);

        if (rst.next()) {
            return new InstructorsDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }
}
