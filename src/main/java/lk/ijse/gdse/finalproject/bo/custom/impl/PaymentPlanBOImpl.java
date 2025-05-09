package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.PaymentPlanBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.PaymentPlanDAO;
import lk.ijse.gdse.finalproject.entity.PaymentPlan;
import lk.ijse.gdse.finalproject.dto.PaymentPlanDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPlanBOImpl implements PaymentPlanBO {
    PaymentPlanDAO paymentPlanDAO = (PaymentPlanDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT_PLAN);
    @Override
    public String getNextPaymentPlanId() throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.getNextId();
    }
    @Override
    public ArrayList<PaymentPlanDto> getAllPaymentPlan() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentPlanDto> paymentPlanDtos = new ArrayList<>();
        for(PaymentPlan paymentPlan : paymentPlanDAO.getAll()){
            paymentPlanDtos.add(new PaymentPlanDto(
                    paymentPlan.getPayplanId(),
                    paymentPlan.getAmount(),
                    paymentPlan.getRate(),
                    paymentPlan.getRatePrice(),
                    paymentPlan.getDescription(),
                    paymentPlan.getPayId()
            ));
        }
        return paymentPlanDtos;
    }
    @Override
    public boolean savePaymentPlan(PaymentPlanDto paymentPlanDto) throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.save(new PaymentPlan(
                paymentPlanDto.getPayplanId(),
                paymentPlanDto.getAmount(),
                paymentPlanDto.getRate(),
                paymentPlanDto.getRate(),
                paymentPlanDto.getDescription(),
                paymentPlanDto.getPayId()
        ));
    }
    @Override
    public boolean deletePaymentPlan(String payPlanId) throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.delete(payPlanId);
    }
    @Override
    public boolean updatePaymentPlan(PaymentPlanDto paymentPlanDto) throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.update(new PaymentPlan(
                paymentPlanDto.getPayplanId(),
                paymentPlanDto.getAmount(),
                paymentPlanDto.getRate(),
                paymentPlanDto.getRate(),
                paymentPlanDto.getDescription(),
                paymentPlanDto.getPayId()
        ));
    }
    @Override
    public ArrayList<String> getAllPayId() throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.getAllPayId();
    }

    @Override
    public ArrayList<String> loadPaymentPlanIds() throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.loadPaymentPlanIds();
    }

    @Override
    public ArrayList<String> loadPaymentIds() throws SQLException, ClassNotFoundException {
        return paymentPlanDAO.getAllPayId();
    }
}
