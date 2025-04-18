package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.PaymentPlanDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentPlanBO extends SuperBO {
    public String getNextPaymentPlanId() throws SQLException, ClassNotFoundException;
    public ArrayList<PaymentPlanDto> getAllPaymentPlan() throws SQLException, ClassNotFoundException;
    public boolean savePaymentPlan(PaymentPlanDto paymentPlanDto) throws SQLException, ClassNotFoundException;
    public boolean deletePaymentPlan(String payPlanId) throws SQLException, ClassNotFoundException;
    public boolean updatePaymentPlan(PaymentPlanDto paymentPlanDto) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllPayId() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadPaymentPlanIds() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadPaymentIds() throws SQLException, ClassNotFoundException;
}
