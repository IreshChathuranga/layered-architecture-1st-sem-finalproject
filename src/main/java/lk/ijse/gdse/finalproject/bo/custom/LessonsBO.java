package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.LessonsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LessonsBO extends SuperBO {
    public ArrayList<LessonsDto> getAllLessons() throws SQLException, ClassNotFoundException;
    public boolean saveLesson(LessonsDto lessonsDto) throws SQLException, ClassNotFoundException;
    public boolean deleteLesson(String lessonName) throws SQLException, ClassNotFoundException;
    public boolean updateLesson(LessonsDto lessonsDto) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAlllesson() throws SQLException, ClassNotFoundException;
    public boolean saveLessonList(ArrayList<LessonsDto> lessonsDTOS) throws SQLException, ClassNotFoundException;
}
