package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.model.PaymentDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    public String getNextPaymentId() throws SQLException, ClassNotFoundException;
    public ArrayList<PaymentDto> getAllPayment() throws SQLException, ClassNotFoundException;
    public boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;
    public boolean deletePayment(String payId) throws SQLException, ClassNotFoundException;
    public boolean updatePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException;
}
