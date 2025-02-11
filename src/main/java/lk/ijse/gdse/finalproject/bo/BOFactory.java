package lk.ijse.gdse.finalproject.bo;

import lk.ijse.gdse.finalproject.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        BOOKED,BOOKING,COURSES,INSTRUCTORS,LESSONS,MAINTAINERS,PAYMENT,PAYMENT_PLAN,SALARY,SETTING,SIGNIN,STUDENTS,VEHICLE,LOGIN
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case BOOKED:
                return new BookedBOImpl();
            case BOOKING:
                return new BookingBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case COURSES:
                return new CoursesBOImpl();
            case SIGNIN:
                return new SigninBOImpl();
            case INSTRUCTORS:
                return new InstructorsBOImpl();
            case LESSONS:
                return new LessonsBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case SETTING:
                return new SettingBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            case STUDENTS:
                return new StudentsBOImpl();
            case MAINTAINERS:
                return new MaintainersBOImpl();
            case PAYMENT_PLAN:
                return new PaymentPlanBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            default:
                return null;
        }
    }
}
