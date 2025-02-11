package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.StudentsDAO;
import lk.ijse.gdse.finalproject.entity.Students;
import lk.ijse.gdse.finalproject.model.StudentsDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsDAOImpl implements StudentsDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("select student_id from student order by student_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("S%03d",newIdIndex);
        }
        return  "S001";

    }
    @Override
        public ArrayList<Students> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from student");
        ArrayList<Students> studentsDtos = new ArrayList<>();
        while (rst.next()){
            Students studentsDto =  new Students(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDate(6),
                    rst.getString(7),
                    rst.getDouble(8),
                    rst.getString(9),
                    rst.getInt(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16));
            studentsDtos.add(studentsDto);
        }
        return studentsDtos;
    }
    @Override
    public boolean save(Students entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved = CrudUtil.execute("insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                entity.getStudentId(),
                entity.getStudentName(),
                entity.getDob(),
                entity.getNic(),
                entity.getStudentAddress(),
                entity.getStudentRegisterDate(),
                entity.getGender(),
                entity.getAdvancePayment(),
                entity.getHelpingAids(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getAdminId(),
                entity.getCourseId(),
                entity.getPaymentPlanId(),
                entity.getPaymentId(),
                entity.getVehicleId());
        return isSaved;
    }
    @Override
    public boolean delete(String studentId) throws SQLException, ClassNotFoundException {
        return  CrudUtil.execute("delete from student where student_id=?", studentId);
    }
    @Override
    public boolean update(Students entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update student set stu_name=?, DOB=?,  NIC=? ,stu_address=? ,register_date=? ,gender=? ,advance_payment=? ,helping_aids=? ,phone_number=? ,email=?, curs_id=? ,paymentPlan_id=? ,veh_id=? where student_id=?",
                entity.getStudentName(),
                entity.getDob(),
                entity.getNic(),
                entity.getStudentAddress(),
                entity.getStudentRegisterDate(),
                entity.getGender(),
                entity.getAdvancePayment(),
                entity.getHelpingAids(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getCourseId(),
                entity.getPaymentPlanId(),
                entity.getVehicleId(),
                entity.getStudentId());
    }

    @Override
    public boolean saveList(ArrayList<Students> entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllStudentIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select student_id from student");

        ArrayList<String> studentIds = new ArrayList<>();

        while (rst.next()){
            studentIds.add(rst.getString(1));
        }

        return studentIds;
    }
    @Override
    public StudentsDto findById(String selectedStudentId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from student where student_id=?", selectedStudentId);

        if (rst.next()) {
            return new StudentsDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDate(6),
                    rst.getString(7),
                    rst.getDouble(8),
                    rst.getString(9),
                    rst.getInt(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16));
        }
        return null;
    }

}
