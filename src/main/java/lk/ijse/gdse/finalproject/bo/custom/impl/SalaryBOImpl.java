package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.SalaryBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.SalaryDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.gdse.finalproject.entity.PaymentPlan;
import lk.ijse.gdse.finalproject.entity.Salary;
import lk.ijse.gdse.finalproject.model.SalaryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);
    @Override
    public String getNextSalaryId() throws SQLException, ClassNotFoundException {
        return salaryDAO.getNextId();
    }
    @Override
    public ArrayList<SalaryDto> getAllSalary() throws SQLException, ClassNotFoundException {
        ArrayList<SalaryDto> salaryDtos = new ArrayList<>();
        for(Salary salary : salaryDAO.getAll()){
            salaryDtos.add(new SalaryDto(
                    salary.getSalaryId(),
                    salary.getAmount(),
                    salary.getPayDay(),
                    salary.getHolidays(),
                    salary.getIsReceived(),
                    salary.getAdminId(),
                    salary.getStafId()
            ));
        }
        return salaryDtos;
    }
    @Override
    public boolean saveSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.save(new Salary(
                salaryDto.getSalaryId(),
                salaryDto.getAmount(),
                salaryDto.getPayDay(),
                salaryDto.getHolidays(),
                salaryDto.getIsReceived(),
                salaryDto.getAdminId(),
                salaryDto.getStafId()
        ));
    }
    @Override
    public boolean deleteSalary(String salaryId) throws SQLException, ClassNotFoundException {
        return salaryDAO.delete(salaryId);
    }
    @Override
    public boolean updateSalary(SalaryDto salaryDto) throws SQLException, ClassNotFoundException {
        return salaryDAO.update(new Salary(
                salaryDto.getSalaryId(),
                salaryDto.getAmount(),
                salaryDto.getPayDay(),
                salaryDto.getHolidays(),
                salaryDto.getIsReceived(),
                salaryDto.getAdminId(),
                salaryDto.getStafId()
        ));
    }
}
