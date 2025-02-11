package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.CoursesBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.CoursesDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.CoursesDAOImpl;
import lk.ijse.gdse.finalproject.entity.Courses;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.model.CoursesDto;
import lk.ijse.gdse.finalproject.model.LessonsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoursesBOImpl implements CoursesBO {
    CoursesDAO coursesDAO = (CoursesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSES);
    @Override
    public String getNextCourseId() throws SQLException, ClassNotFoundException {
        return coursesDAO.getNextId();
    }
    @Override
    public ArrayList<CoursesDto> getAllCourse() throws SQLException, ClassNotFoundException {
        ArrayList<CoursesDto> coursesDtos = new ArrayList<>();
        for(Courses courses : coursesDAO.getAll()){
            coursesDtos.add(new CoursesDto(
                    courses.getCourseId(),
                    courses.getCourseName(),
                    courses.getAdminId()
            ));
        }
        return coursesDtos;
    }
    @Override
    public boolean saveCourse(CoursesDto coursesDto) throws SQLException, ClassNotFoundException {
        return coursesDAO.save(new Courses(
                coursesDto.getCourseId(),
                coursesDto.getCourseName(),
                coursesDto.getAdminId()
        ));
    }
    @Override
    public boolean deleteCourse(String courseId) throws SQLException, ClassNotFoundException {
        return coursesDAO.delete(courseId);
    }
    @Override
    public boolean updateCourse(CoursesDto coursesDto) throws SQLException, ClassNotFoundException {
        return coursesDAO.update(new Courses(
                coursesDto.getCourseId(),
                coursesDto.getCourseName(),
                coursesDto.getAdminId()
        ));
    }

    @Override
    public ArrayList<String> getAllCourseIds() throws SQLException, ClassNotFoundException {
        return coursesDAO.getAllCourseIds();
    }
}
