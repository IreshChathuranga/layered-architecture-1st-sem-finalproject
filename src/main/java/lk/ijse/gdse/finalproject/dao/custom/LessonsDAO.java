package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.model.LessonsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LessonsDAO extends CrudDAO<Lessons> {
    ArrayList<String> getAlllesson() throws SQLException, ClassNotFoundException;
//    boolean saveLessonList(ArrayList<LessonsDto> lessonsDTOS) throws SQLException, ClassNotFoundException;
}
