package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.SalaryDAO;
import lk.ijse.gdse.finalproject.entity.Salary;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst= CrudUtil.execute("select salary_id from salary order by salary_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("L%03d",newIdIndex);
        }
        return  "L001";

    }
    @Override
    public ArrayList<Salary> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from salary");
        ArrayList<Salary> salaryDtos = new ArrayList<>();
        while (rst.next()){
            Salary salaryDto = new Salary(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getDate(3),
                    rst.getInt(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7));
            salaryDtos.add(salaryDto);
        }
        return salaryDtos;
    }
    @Override
    public boolean save(Salary entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved=CrudUtil.execute("insert into salary values(?,?,?,?,?,?,?)", entity.getSalaryId(),entity.getAmount(),entity.getPayDay(),entity.getHolidays(),entity.getIsReceived(),entity.getAdminId(),entity.getStafId());

        return  isSaved;
    }
    @Override
    public boolean delete(String salaryId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from salary where salary_id=?", salaryId);
    }
    @Override
    public boolean update(Salary entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update salary set amount=?, pay_day=?, holidays=?, is_received=?, admin_id=?, staf_id=? where salary_id=?",
                entity.getAmount(),
                entity.getPayDay(),
                entity.getHolidays(),
                entity.getIsReceived(),
                entity.getAdminId(),
                entity.getStafId(),
                entity.getSalaryId()
        );
    }

    @Override
    public boolean saveList(ArrayList<Salary> entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
