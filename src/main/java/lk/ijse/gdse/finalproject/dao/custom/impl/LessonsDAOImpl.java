package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.LessonsDAO;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.model.LessonsDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessonsDAOImpl implements LessonsDAO {

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Lessons> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from training_lesson");
        ArrayList<Lessons> lessonsDtos = new ArrayList<>();
        while (rst.next()){
            Lessons lessonsDto = new Lessons(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4));
            lessonsDtos.add(lessonsDto);
        }
        return lessonsDtos;
    }
    public boolean save(Lessons entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved=CrudUtil.execute("insert into training_lesson values(?,?,?,?)", entity.getLessonName(),entity.getTimePeriod(),entity.getStudentId(),entity.getInstructorId());

        return  isSaved;
    }
    @Override
    public boolean delete(String lessonName) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("delete from training_lesson where less_name=?", lessonName);
    }
    @Override
    public boolean update(Lessons entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update training_lesson set time_period=?, student_id=?, instru_id=? where less_name=?",
                entity.getTimePeriod(),
                entity.getStudentId(),
                entity.getInstructorId(),
                entity.getLessonName()
        );
    }

//    @Override
//    public boolean saveList(ArrayList<LessonsDto> chooseTrainerDTOS) throws SQLException, ClassNotFoundException {
//        return false;
//    }

    @Override
    public ArrayList<String> getAlllesson() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select less_name from training_lesson");

        ArrayList<String> lessons = new ArrayList<>();

        while (rst.next()){
            lessons.add(rst.getString(1));
        }

        return lessons;
    }
    @Override
public boolean saveList(ArrayList<Lessons> entity) throws SQLException, ClassNotFoundException {
    for (Lessons lessons : entity) {
        boolean isLessonSaved = save(lessons);
        if (!isLessonSaved) {
            return false;
        }
    }
    return true;
}

}
