package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Courses;
import lk.ijse.gdse.finalproject.model.CoursesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CoursesDAO extends CrudDAO<Courses> {
    ArrayList<String> getAllCourseIds() throws SQLException, ClassNotFoundException;

}
