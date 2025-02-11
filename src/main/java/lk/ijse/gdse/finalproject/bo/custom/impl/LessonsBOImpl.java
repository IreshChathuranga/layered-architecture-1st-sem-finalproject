package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.LessonsBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.LessonsDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.LessonsDAOImpl;
import lk.ijse.gdse.finalproject.entity.Booked;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.model.BookedDto;
import lk.ijse.gdse.finalproject.model.LessonsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class LessonsBOImpl implements LessonsBO {
    LessonsDAO lessonsDAO = (LessonsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LESSONS);
    @Override
    public ArrayList<LessonsDto> getAllLessons() throws SQLException, ClassNotFoundException {
        ArrayList<LessonsDto> lessonsDtos = new ArrayList<>();
        for(Lessons lessons : lessonsDAO.getAll()){
            lessonsDtos.add(new LessonsDto(
                    lessons.getLessonName(),
                    lessons.getTimePeriod(),
                    lessons.getStudentId(),
                    lessons.getInstructorId()
            ));
        }
        return lessonsDtos;
    }

    @Override
    public boolean saveLesson(LessonsDto lessonsDto) throws SQLException, ClassNotFoundException {
       return lessonsDAO.save(new Lessons(
               lessonsDto.getLessonName(),
               lessonsDto.getTimePeriod(),
               lessonsDto.getStudentId(),
               lessonsDto.getInstructorId()
       ));
    }

    @Override
    public boolean deleteLesson(String lessonName) throws SQLException, ClassNotFoundException {
        return lessonsDAO.delete(lessonName);
    }
    @Override
    public boolean updateLesson(LessonsDto lessonsDto) throws SQLException, ClassNotFoundException {
        return lessonsDAO.update(new Lessons(
                lessonsDto.getLessonName(),
                lessonsDto.getTimePeriod(),
                lessonsDto.getStudentId(),
                lessonsDto.getInstructorId()
        ));
    }
    @Override
    public ArrayList<String> getAlllesson() throws SQLException, ClassNotFoundException {
        return lessonsDAO.getAlllesson();
    }
    @Override
    public boolean saveLessonList(ArrayList<LessonsDto> lessonsDTOS) throws SQLException, ClassNotFoundException {
        ArrayList<Lessons> lessonsList = new ArrayList<>();
        for (LessonsDto lessonsDto : lessonsDTOS){
            lessonsList.add(new Lessons(
                    lessonsDto.getLessonName(),
                    lessonsDto.getTimePeriod(),
                    lessonsDto.getStudentId(),
                    lessonsDto.getInstructorId()
            ));
        }
        return lessonsDAO.saveList(lessonsList);
    }

}
