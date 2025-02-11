package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.PaymentPlan;
import lk.ijse.gdse.finalproject.model.PaymentPlanDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentPlanDAO extends CrudDAO<PaymentPlan> {
    ArrayList<String> getAllPayId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadPaymentPlanIds() throws SQLException, ClassNotFoundException;
}
