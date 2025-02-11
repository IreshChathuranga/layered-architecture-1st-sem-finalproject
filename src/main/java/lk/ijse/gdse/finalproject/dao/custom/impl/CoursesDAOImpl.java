package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.CoursesDAO;
import lk.ijse.gdse.finalproject.entity.Courses;
import lk.ijse.gdse.finalproject.model.CoursesDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoursesDAOImpl implements CoursesDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("select course_id from course order by course_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("C%03d",newIdIndex);
        }
        return  "C001";

    }
    @Override
    public ArrayList<Courses> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from course");
        ArrayList<Courses> coursesDtos = new ArrayList<>();
        while (rst.next()){
            Courses coursesDto = new Courses(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
            coursesDtos.add(coursesDto);
        }
        return coursesDtos;
    }
    @Override
    public boolean save(Courses entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved=CrudUtil.execute("insert into course values(?,?,?)", entity.getCourseId(),entity.getCourseName(),entity.getAdminId());

        return  isSaved;
    }
    @Override
    public boolean delete(String courseId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from course where course_id=?", courseId);
    }
    @Override
    public boolean update(Courses entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update course set  course_name=?, admin_id=? where course_id=?",
                entity.getCourseName(),
                entity.getAdminId(),
                entity.getCourseId()
        );
    }

    @Override
    public boolean saveList(ArrayList<Courses> entity) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public ArrayList<String> getAllCourseIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select course_id from course");

        ArrayList<String> courseIds = new ArrayList<>();

        while (rst.next()){
            courseIds.add(rst.getString(1));
        }

        return courseIds;
    }
}
