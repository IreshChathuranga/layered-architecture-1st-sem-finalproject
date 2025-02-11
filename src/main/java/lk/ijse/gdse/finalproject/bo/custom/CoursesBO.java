package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.model.CoursesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoursesBO extends SuperBO {
    public String getNextCourseId() throws SQLException, ClassNotFoundException;
    public ArrayList<CoursesDto> getAllCourse() throws SQLException, ClassNotFoundException;
    public boolean saveCourse(CoursesDto coursesDto) throws SQLException, ClassNotFoundException;
    public boolean deleteCourse(String courseId) throws SQLException, ClassNotFoundException;
    public boolean updateCourse(CoursesDto coursesDto) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllCourseIds() throws SQLException, ClassNotFoundException;
}
