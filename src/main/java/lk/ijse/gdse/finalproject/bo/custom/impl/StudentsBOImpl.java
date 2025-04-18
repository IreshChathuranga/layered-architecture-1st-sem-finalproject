package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.StudentsBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.StudentsDAO;
import lk.ijse.gdse.finalproject.entity.Students;
import lk.ijse.gdse.finalproject.dto.StudentsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsBOImpl implements StudentsBO {
    StudentsDAO studentsDAO = (StudentsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENTS);
    @Override
    public String getNextStuentId() throws SQLException, ClassNotFoundException {
        return studentsDAO.getNextId();
    }
    @Override
    public ArrayList<StudentsDto> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentsDto> studentsDtos = new ArrayList<>();
        for(Students students : studentsDAO.getAll()){
            studentsDtos.add(new StudentsDto(
                    students.getStudentId(),
                    students.getStudentName(),
                    students.getDob(),
                    students.getNic(),
                    students.getStudentAddress(),
                    students.getStudentRegisterDate(),
                    students.getGender(),
                    students.getAdvancePayment(),
                    students.getHelpingAids(),
                    students.getPhoneNumber(),
                    students.getEmail(),
                    students.getAdminId(),
                    students.getCourseId(),
                    students.getPaymentPlanId(),
                    students.getPaymentId(),
                    students.getVehicleId()
            ));
        }
        return studentsDtos;
    }
    @Override
    public boolean saveStudent(StudentsDto studentsDto) throws SQLException, ClassNotFoundException {
        return studentsDAO.save(new Students(
                studentsDto.getStudentId(),
                studentsDto.getStudentName(),
                studentsDto.getDob(),
                studentsDto.getNic(),
                studentsDto.getStudentAddress(),
                studentsDto.getStudentRegisterDate(),
                studentsDto.getGender(),
                studentsDto.getAdvancePayment(),
                studentsDto.getHelpingAids(),
                studentsDto.getPhoneNumber(),
                studentsDto.getEmail(),
                studentsDto.getAdminId(),
                studentsDto.getCourseId(),
                studentsDto.getPaymentPlanId(),
                studentsDto.getPaymentId(),
                studentsDto.getVehicleId()
        ));
    }
    @Override
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        return  studentsDAO.delete(studentId);
    }
    @Override
    public boolean updateStudent(StudentsDto studentsDto) throws SQLException, ClassNotFoundException {
        return studentsDAO.update(new Students(
                studentsDto.getStudentId(),
                studentsDto.getStudentName(),
                studentsDto.getDob(),
                studentsDto.getNic(),
                studentsDto.getStudentAddress(),
                studentsDto.getStudentRegisterDate(),
                studentsDto.getGender(),
                studentsDto.getAdvancePayment(),
                studentsDto.getHelpingAids(),
                studentsDto.getPhoneNumber(),
                studentsDto.getEmail(),
                studentsDto.getAdminId(),
                studentsDto.getCourseId(),
                studentsDto.getPaymentPlanId(),
                studentsDto.getPaymentId(),
                studentsDto.getVehicleId()
        ));
    }
    @Override
    public ArrayList<String> getAllStudentIds() throws SQLException, ClassNotFoundException {
        return studentsDAO.getAllStudentIds();
    }
    @Override
    public StudentsDto findById(String selectedStudentId) throws SQLException, ClassNotFoundException {
        return studentsDAO.findById(selectedStudentId);
    }
}
