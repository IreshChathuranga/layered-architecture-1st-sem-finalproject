package lk.ijse.gdse.finalproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.finalproject.bo.BOFactory;
import lk.ijse.gdse.finalproject.bo.custom.BookingBO;
import lk.ijse.gdse.finalproject.bo.custom.InstructorsBO;
import lk.ijse.gdse.finalproject.bo.custom.LessonsBO;
import lk.ijse.gdse.finalproject.bo.custom.StudentsBO;
import lk.ijse.gdse.finalproject.bo.custom.impl.BookingBOImpl;
import lk.ijse.gdse.finalproject.bo.custom.impl.InstructorsBOImpl;
import lk.ijse.gdse.finalproject.bo.custom.impl.LessonsBOImpl;
import lk.ijse.gdse.finalproject.bo.custom.impl.StudentsBOImpl;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.BookedDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.InstructorsDAOImpl;
import lk.ijse.gdse.finalproject.dao.custom.impl.LessonsDAOImpl;
import lk.ijse.gdse.finalproject.dao.custom.impl.StudentsDAOImpl;
import lk.ijse.gdse.finalproject.entity.BookingDetails;
import lk.ijse.gdse.finalproject.entity.ChooseTrainer;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.model.*;
import lk.ijse.gdse.finalproject.model.tm.CartTM;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
    public TextField txtDate;
    public TextField txtTime;
    public Button btnReschedule;

    public Button btnDelete;
    public TextField txtReason;
    public TableView<CartTM> tblBook;
    public TableColumn<CartTM, String> bookId;
    public TableColumn<CartTM, Date> bookDate;
    public TableColumn<CartTM, String> bookTime;

    public Label lblBokk;
    public Button btnRefresh;
    public ComboBox<String> cmbStudentId;
    public Label lblStuName;
    public ComboBox<String> cmbInstructor;
    public Label lblinstuName;

    private final StudentsDAOImpl studentsModel = new StudentsDAOImpl();
    private final InstructorsDAOImpl instructorsModel = new InstructorsDAOImpl();
    private final LessonsDAOImpl lessonsModel = new LessonsDAOImpl();

    private final ObservableList<CartTM> cartTMS = FXCollections.observableArrayList();
    public TableColumn<CartTM, String> studentId;
    public TableColumn<CartTM, String> instructorId;
    public TableColumn<CartTM, String> rescheduleReason;
    public Button btnAddTable;
    public ComboBox<String> cmbLessons;
    public TextField txtTimePeriod;
    public TableColumn<CartTM, String> lessonName;
    public TableColumn<CartTM, String> timePeriod;
    public TableColumn<?, ?> action;
    public Button btnPlaceBooking;
    InstructorsBO instructorsBO = (InstructorsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INSTRUCTORS);
    LessonsBO lessonsBO = (LessonsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LESSONS);
    StudentsBO studentsBO = (StudentsBO)  BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENTS);
    BookingBO bookingBO = (BookingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOKING);
    public void studentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String selectedStudentId = cmbStudentId.getSelectionModel().getSelectedItem();
        StudentsDto studentsDto = studentsBO.findById(selectedStudentId);

        if (studentsDto != null) {
            lblStuName.setText(studentsDto.getStudentName());
        }
    }

    public void refreshOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    public void instructorOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String selectedInstructorId = cmbInstructor.getSelectionModel().getSelectedItem();
        InstructorsDto instructorsDto = instructorsBO.findById(selectedInstructorId);

        if (instructorsDto != null) {
            lblinstuName.setText(instructorsDto.getInstructorName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValues();
        try {
            refreshPage();
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Fail to load data").show();
        }
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        lblBokk.setText(bookingBO.getNextBookingId());
        loadStudentIds();
        loadInstructorIds();
        loadLessons();

        txtDate.setText("");
        txtTime.setText("");
        cmbStudentId.getSelectionModel().clearSelection();
        cmbInstructor.getSelectionModel().clearSelection();
        lblStuName.setText("");
        lblinstuName.setText("");
        cmbLessons.getSelectionModel().clearSelection();
        txtTimePeriod.setText("");
        txtReason.setText("");

        cartTMS.clear();

        tblBook.refresh();
    }

    private void setCellValues() {
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookDate.setCellValueFactory(new PropertyValueFactory<>("bookDate"));
        bookTime.setCellValueFactory(new PropertyValueFactory<>("bookTime"));
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        instructorId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
        lessonName.setCellValueFactory(new PropertyValueFactory<>("lessonName"));
        timePeriod.setCellValueFactory(new PropertyValueFactory<>("timePeriod"));
        rescheduleReason.setCellValueFactory(new PropertyValueFactory<>("rescheduleReason"));
        action.setCellValueFactory(new PropertyValueFactory<>("removeBtn"));

        tblBook.setItems(cartTMS);
    }

    private void loadStudentIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> studentIds = studentsBO.getAllStudentIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(studentIds);
        cmbStudentId.setItems(observableList);
    }

    private void loadInstructorIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> instructorIds = instructorsBO.getAllInstructorIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(instructorIds);
        cmbInstructor.setItems(observableList);
    }

    private void loadLessons() throws SQLException, ClassNotFoundException {
        ArrayList<String> lessons = lessonsBO.getAlllesson();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(lessons);
        cmbLessons.setItems(observableList);
    }

    public void addTableOnAction(ActionEvent event) {
        String bookId = lblBokk.getText();
        Date bookDate = Date.valueOf(txtDate.getText());
        String bookTime = txtTime.getText();
        String studentId = cmbStudentId.getValue();

        if (studentId == null) {
            new Alert(Alert.AlertType.ERROR, "Please select student..!").show();
        }
        String instructorId = cmbInstructor.getValue();

        if (instructorId == null) {
            new Alert(Alert.AlertType.ERROR, "Please select instructor..!").show();
        }
        String lessons = cmbLessons.getValue();
        if (lessons == null) {
            new Alert(Alert.AlertType.ERROR, "Please select lesson..!").show();
        }
        String timePeriod = txtTimePeriod.getText();
        String reason = txtReason.getText();
        Button btn = new Button("Remove");

        CartTM newCartTM = new CartTM(
                bookId,
                bookDate,
                bookTime,
                studentId,
                instructorId,
                lessons,
                timePeriod,
                reason,
                btn
        );
        btn.setOnAction(actionEvent -> {
            cartTMS.remove(newCartTM);
            tblBook.refresh();
        });
        cartTMS.add(newCartTM);
    }

    public void placeBookingOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (tblBook.getItems().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please add data..!").show();
        }
        if (cmbStudentId.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select student for place booking..!").show();
        }
        if (cmbLessons.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select lesson for place booking..!").show();
        }
        if (cmbInstructor.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select instructor for place booking..!").show();
        }
        String bookId = lblBokk.getText();
        Date bookDate = Date.valueOf(txtDate.getText());
        String bookTime = txtTime.getText();
        String timePeriod = txtTimePeriod.getText();
        String rescheduleReason = txtReason.getText();

        ArrayList<BookingDetails> bookingDetailsDTOS = new ArrayList<>();

        for (CartTM cartTM : cartTMS) {

            BookingDetails bookingDetailsDTO = new BookingDetails(
                    bookId,
                    cartTM.getStudentId()
            );
            bookingDetailsDTOS.add(bookingDetailsDTO);
        }
        ArrayList<Lessons> lessonsDTOS = new ArrayList<>();
        for (CartTM cartTM : cartTMS){
            Lessons lessonsDTO = new Lessons(
                    cartTM.getLessonName(),
                    timePeriod,
                    cartTM.getStudentId(),
                    cartTM.getInstructorId()
            );
            lessonsDTOS.add(lessonsDTO);
        }
        ArrayList<ChooseTrainer> chooseTrainerDTOS = new ArrayList<>();
        for(CartTM cartTM:cartTMS){
            ChooseTrainer chooseTrainerDTO = new ChooseTrainer(
                    bookId,
                    cartTM.getInstructorId()
            );
            chooseTrainerDTOS.add(chooseTrainerDTO);
        }
            BookingDto bookingDto = new BookingDto(
                bookId,
                bookDate,
                bookTime,
                rescheduleReason,
                bookingDetailsDTOS,
                lessonsDTOS,
                chooseTrainerDTOS
        );

        boolean isSaved = bookingBO.savePlaceBooking(bookingDto);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Booking saved..!").show();
            refreshPage();
        } else {
            new Alert(Alert.AlertType.ERROR, "Booking fail..!").show();
        }
    }
}


