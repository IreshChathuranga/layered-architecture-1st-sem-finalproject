package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.PaymentBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.PaymentDAO;
import lk.ijse.gdse.finalproject.entity.Payment;
import lk.ijse.gdse.finalproject.dto.PaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public String getNextPaymentId() throws SQLException, ClassNotFoundException {
        return paymentDAO.getNextId();
    }
    @Override
    public ArrayList<PaymentDto> getAllPayment() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentDto> paymentDtos = new ArrayList<>();
        for(Payment payment : paymentDAO.getAll()){
            paymentDtos.add(new PaymentDto(
                    payment.getPayId(),
                    payment.getPayDate(),
                    payment.getPayMethod(),
                    payment.getAdminId()
            ));
        }
        return paymentDtos;
    }
    @Override
    public boolean savePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        return paymentDAO.save(new Payment(
                paymentDto.getPayId(),
                paymentDto.getPayDate(),
                paymentDto.getPayMethod(),
                paymentDto.getAdminId()
        ));
    }
    @Override
    public boolean deletePayment(String payId) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete(payId);
    }
    @Override
    public boolean updatePayment(PaymentDto paymentDto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(new Payment(
                paymentDto.getPayId(),
                paymentDto.getPayDate(),
                paymentDto.getPayMethod(),
                paymentDto.getAdminId()
        ));
    }
}
