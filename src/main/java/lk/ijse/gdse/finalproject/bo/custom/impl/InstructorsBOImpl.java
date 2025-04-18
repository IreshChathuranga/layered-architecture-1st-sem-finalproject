package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.InstructorsBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.InstructorsDAO;
import lk.ijse.gdse.finalproject.entity.Instructors;
import lk.ijse.gdse.finalproject.dto.InstructorsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorsBOImpl implements InstructorsBO {
    InstructorsDAO instructorsDAO = (InstructorsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INSTRUCTORS);
    @Override
    public String getNextInstructorId() throws SQLException, ClassNotFoundException {
       return instructorsDAO.getNextId();
    }
    @Override
    public ArrayList<InstructorsDto> getAllInstructors() throws SQLException, ClassNotFoundException {
        ArrayList<InstructorsDto> instructorsDtos = new ArrayList<>();
        for(Instructors instructors : instructorsDAO.getAll()){
            instructorsDtos.add(new InstructorsDto(
                    instructors.getInstructorId(),
                    instructors.getInstructorName(),
                    instructors.getInstructorAge(),
                    instructors.getInstructorAddress(),
                    instructors.getCertificationDetail(),
                    instructors.getAdminId()
            ));

        }
        return instructorsDtos;
    }
    @Override
    public boolean saveInstructor(InstructorsDto instructorsDto) throws SQLException, ClassNotFoundException {
        return instructorsDAO.save(new Instructors(
                instructorsDto.getInstructorId(),
                instructorsDto.getInstructorName(),
                instructorsDto.getInstructorAge(),
                instructorsDto.getInstructorAddress(),
                instructorsDto.getCertificationDetail(),
                instructorsDto.getAdminId()
        ));
    }
    @Override
    public boolean deleteInstructor(String instructorId) throws SQLException, ClassNotFoundException {
        return instructorsDAO.delete(instructorId);
    }
    @Override
    public boolean updateInstructor(InstructorsDto instructorsDto) throws SQLException, ClassNotFoundException {
        return instructorsDAO.update(new Instructors(
                instructorsDto.getInstructorId(),
                instructorsDto.getInstructorName(),
                instructorsDto.getInstructorAge(),
                instructorsDto.getInstructorAddress(),
                instructorsDto.getCertificationDetail(),
                instructorsDto.getAdminId()
        ));
    }
    @Override
    public ArrayList<String> getAllInstructorIds() throws SQLException, ClassNotFoundException {
        return instructorsDAO.getAllInstructorIds();
    }
    @Override
    public InstructorsDto findById(String selectedInstructorId) throws SQLException, ClassNotFoundException {
        return instructorsDAO.findById(selectedInstructorId);
    }
}
