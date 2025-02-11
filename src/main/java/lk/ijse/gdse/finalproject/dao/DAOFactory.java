package lk.ijse.gdse.finalproject.dao;

import lk.ijse.gdse.finalproject.dao.custom.impl.*;
import net.sf.jasperreports.engine.ReturnValue;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory
                =new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        BOOKED,BOOKING,BOOKING_DETAILS,CHOOSE_TRAINER,COURSES,INSTRUCTORS,LESSONS,MAINTAINERS,PAYMENT,PAYMENT_PLAN,SALARY,SETTING,SIGNIN,STUDENTS,VEHICLE
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
            switch(daoTypes){
                case BOOKED:
                    return new BookedDAOImpl();
                case BOOKING:
                    return new BookingDAOImpl();
                case BOOKING_DETAILS:
                    return new BookingDetailsDAOImpl();
                case CHOOSE_TRAINER:
                    return new ChooseTrainerDAOImpl();
                case COURSES:
                    return new CoursesDAOImpl();
                case INSTRUCTORS:
                    return new InstructorsDAOImpl();
                case LESSONS:
                    return new LessonsDAOImpl();
                case MAINTAINERS:
                    return new MaintainersDAOImpl();
                case PAYMENT:
                    return new PaymentDAOImpl();
                case PAYMENT_PLAN:
                    return new PaymentPlanDAOImpl();
                case SALARY:
                    return new SalaryDAOImpl();
                case SETTING:
                    return new SettingDAOImpl();
                case SIGNIN:
                    return new SigninDAOImpl();
                case VEHICLE:
                    return new VehicleDAOImpl();
                case STUDENTS:
                    return new StudentsDAOImpl();
                default:
                    return null;
            }
        }
    }

