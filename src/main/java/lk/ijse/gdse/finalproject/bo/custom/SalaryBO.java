package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.SalaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBO extends SuperBO {
    public String getNextSalaryId() throws SQLException, ClassNotFoundException;
    public ArrayList<SalaryDto> getAllSalary() throws SQLException, ClassNotFoundException;
    public boolean saveSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException;
    public boolean deleteSalary(String salaryId) throws SQLException, ClassNotFoundException;
    public boolean updateSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException;
}
