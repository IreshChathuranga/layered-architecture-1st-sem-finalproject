package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.PaymentPlanDAO;
import lk.ijse.gdse.finalproject.entity.PaymentPlan;
import lk.ijse.gdse.finalproject.model.PaymentPlanDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentPlanDAOImpl implements PaymentPlanDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst= CrudUtil.execute("select payplan_id from payment_plan order by payplan_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("Z%03d",newIdIndex);
        }
        return  "Z001";

    }
    @Override
    public ArrayList<PaymentPlan> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from payment_plan");
        ArrayList<PaymentPlan> paymentPlanDtos = new ArrayList<>();
        while (rst.next()){
            PaymentPlan paymentPlanDto =  new PaymentPlan(
                    rst.getString(1),
                    rst.getDouble(2),
                    rst.getInt(3),
                    rst.getDouble(4),
                    rst.getString(5),
                    rst.getString(6));
            paymentPlanDtos.add(paymentPlanDto);
        }
        return paymentPlanDtos;
    }
    @Override
    public boolean save(PaymentPlan entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved=CrudUtil.execute("insert into payment_plan values(?,?,?,?,?,?)", entity.getPayplanId(),entity.getAmount(),entity.getRate(),entity.getRatePrice(),entity.getDescription(),entity.getPayId());

        return  isSaved;
    }
    @Override
    public boolean delete(String payPlanId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from payment_plan where payplan_id=?", payPlanId);
    }
    @Override
    public boolean update(PaymentPlan entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update payment_plan set  amount=?, rate=?,  rate_price=?, description=?, payment_Id=? where payplan_id=?",
                entity.getAmount(),
                entity.getRate(),
                entity.getRatePrice(),
                entity.getDescription(),
                entity.getPayId(),
                entity.getPayplanId()
        );
    }

    @Override
    public boolean saveList(ArrayList<PaymentPlan> entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllPayId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select pay_id from payment");

        ArrayList<String> paymentId = new ArrayList<>();

        while (rst.next()){
            paymentId.add(rst.getString(1));
        }

        return paymentId;
    }
    @Override
    public ArrayList<String> loadPaymentPlanIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select payplan_id from payment_plan");

        ArrayList<String> paymentPlanId = new ArrayList<>();

        while (rst.next()){
            paymentPlanId.add(rst.getString(1));
        }

        return paymentPlanId;
    }
}
