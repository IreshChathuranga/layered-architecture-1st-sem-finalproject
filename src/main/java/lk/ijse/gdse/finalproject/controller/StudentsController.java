package lk.ijse.gdse.finalproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Window;
import lk.ijse.gdse.finalproject.bo.BOFactory;
import lk.ijse.gdse.finalproject.bo.custom.*;
import lk.ijse.gdse.finalproject.bo.custom.impl.StudentsBOImpl;
import lk.ijse.gdse.finalproject.model.StudentsDto;
import lk.ijse.gdse.finalproject.model.tm.StudentsTM;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    public TableView<StudentsTM> tblStudents;
    public TableColumn<StudentsTM,String> studentId;
    public TableColumn<StudentsTM,String> studentName;
    public TableColumn<StudentsTM, Date> dob;
    public TableColumn<StudentsTM,String> nic;
    public TableColumn<StudentsTM,String> studentAddress;
    public TableColumn<StudentsTM,Date> studentRegisterDate;
    public TableColumn<StudentsTM,String> gender;
    public TableColumn<StudentsTM,Double> advancePayment;
    public TableColumn<StudentsTM,String> helpingAids;
    public TableColumn<StudentsTM,Integer> phoneNumber;
    public TableColumn<StudentsTM,String> email;

    public TableColumn<StudentsTM,String> adminId;
    public TableColumn<StudentsTM,String> courseId;
    public TableColumn<StudentsTM,String> paymentPlanId;
    public TableColumn<StudentsTM,String> paymentId;
    public TableColumn<StudentsTM,String> vehicleId;
    public Label lblStudentId;
    public TextField txtVehicelId;
    public TextField txtPayment;
    public TextField txtPaymentPlanId;
    public TextField txtCourseId;
    public TextField txtNic;
    public TextField txtEmail;
    public TextField txtNumber;
    public TextField txtHelpingAids;
    public TextField txtAdvancePayment;
    public TextField txtGender;
    public TextField txtRegisterDate;
    public TextField txtAddress;
    public TextField txtAdminId;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;
    public TextField txtDob;
    public TextField txtName;
    public Button btnSendEmail;
    public TextField txtAdmin;

    public ComboBox<String> cmbCourse;
    public ComboBox<String> cmbPaymentId;
    public ComboBox<String> cmbPaymentPlanId;
    public ComboBox<String> cmbVehicelId;

    StudentsBO studentsBO = (StudentsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENTS);//loose coupling
    CoursesBO coursesBO = (CoursesBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.COURSES);

    PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);

    PaymentPlanBO paymentPlanBO = (PaymentPlanBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT_PLAN);

    VehicleBO vehicleBO = (VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VEHICLE);

    private void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<StudentsDto> studentsDtos = studentsBO.getAllStudents();//loose coupling
        ObservableList<StudentsTM> studentsTMS = FXCollections.observableArrayList();
        for(StudentsDto studentsDto:studentsDtos){
            StudentsTM studentsTM=new StudentsTM();
            studentsTM.setStudentId(studentsDto.getStudentId());
            studentsTM.setStudentName(studentsDto.getStudentName());
            studentsTM.setDob(studentsDto.getDob());
            studentsTM.setNic(studentsDto.getNic());
            studentsTM.setStudentAddress(studentsDto.getStudentAddress());
            studentsTM.setStudentRegisterDate(studentsDto.getStudentRegisterDate());
            studentsTM.setGender(studentsDto.getGender());
            studentsTM.setAdvancePayment(studentsDto.getAdvancePayment());
            studentsTM.setHelpingAids(studentsDto.getHelpingAids());
            studentsTM.setPhoneNumber(studentsDto.getPhoneNumber());
            studentsTM.setEmail(studentsDto.getEmail());
            studentsTM.setAdminId(studentsDto.getAdminId());
            studentsTM.setCourseId(studentsDto.getCourseId());
            studentsTM.setPaymentPlanId(studentsDto.getPaymentPlanId());
            studentsTM.setPaymentId(studentsDto.getPaymentId());
            studentsTM.setVehicleId(studentsDto.getVehicleId());
            studentsTMS.add(studentsTM);
        }
        tblStudents.setItems(studentsTMS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        studentAddress.setCellValueFactory(new PropertyValueFactory<>("studentAddress"));
        studentRegisterDate.setCellValueFactory(new PropertyValueFactory<>("studentRegisterDate"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        advancePayment.setCellValueFactory(new PropertyValueFactory<>("advancePayment"));
        helpingAids.setCellValueFactory(new PropertyValueFactory<>("helpingAids"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        adminId.setCellValueFactory(new PropertyValueFactory<>("adminId"));
        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        paymentPlanId.setCellValueFactory(new PropertyValueFactory<>("paymentPlanId"));
        paymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        vehicleId.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));

        try{
            refreshPage();
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Fail Booking id").show();
        }
    }

    public void loadNextStudentId() throws SQLException, ClassNotFoundException {
        String nextStudentId = studentsBO.getNextStuentId();
        lblStudentId.setText(nextStudentId);
    }

    private void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextStudentId();
        loadCourseIds();
        loadPaymentPlanIds();
        loadPaymentIds();
        loadVehicelIds();
        loadTableData();

        btnSave.setDisable(false);

        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

        txtName.setText("");
        txtDob.setText("");
        txtNic.setText("");
        txtAddress.setText("");
        txtRegisterDate.setText("");
        txtGender.setText("");
        txtAdvancePayment.setText("");
        txtHelpingAids.setText("");
        txtNumber.setText("");
        txtEmail.setText("");
        txtAdmin.setText("");
        cmbCourse.getSelectionModel().clearSelection();
        cmbPaymentPlanId.getSelectionModel().clearSelection();
        cmbPaymentId.getSelectionModel().clearSelection();
        cmbVehicelId.getSelectionModel().clearSelection();
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentId = lblStudentId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if(optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {
            boolean isDeleted = studentsBO.deleteStudent(studentId);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Student deleted").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete student...!").show();
            }
        }
    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentId = lblStudentId.getText();
        String studentName = txtName.getText();
        Date dob = Date.valueOf(txtDob.getText());
        String nic = txtNic.getText();
        String studentAddress = txtAddress.getText();
        Date studentRegisterDate = Date.valueOf(txtRegisterDate.getText());
        String gender = txtGender.getText();
        Double advancePayment = Double.valueOf(txtAdvancePayment.getText());
        String helpingAids = txtHelpingAids.getText();
        int phoneNumber = Integer.parseInt(txtNumber.getText());
        String email = txtEmail.getText();
        String adminId = txtAdmin.getText();
        String courseId = cmbCourse.getValue();
        String paymentPlanId = cmbPaymentPlanId.getValue();
        String paymentId = cmbPaymentId.getValue();
        String vehicleId = cmbVehicelId.getValue();

        StudentsDto studentsDto = new StudentsDto(
                studentId,
                studentName,
                dob,
                nic,
                studentAddress,
                studentRegisterDate,
                gender,
                advancePayment,
                helpingAids,
                phoneNumber,
                email,
                adminId,
                courseId,
                paymentPlanId,
                paymentId,
                vehicleId
        );

        boolean isUpdated = studentsBO.updateStudent(studentsDto);
        if(isUpdated){
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Student Updated").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Update fail").show();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentId = lblStudentId.getText();
        String studentName = txtName.getText();
        Date dob = Date.valueOf(txtDob.getText());
        String nic = txtNic.getText();
        String studentAddress = txtAddress.getText();
        Date studentRegisterDate = Date.valueOf(txtRegisterDate.getText());
        String gender = txtGender.getText();
        Double advancePayment = Double.valueOf(txtAdvancePayment.getText());
        String helpingAids = txtHelpingAids.getText();
        int phoneNumber = Integer.parseInt(txtNumber.getText());
        String email = txtEmail.getText();
        String adminId = txtAdmin.getText();
        String courseId = cmbCourse.getValue();
        String paymentPlanId = cmbPaymentPlanId.getValue();
        String paymentId = cmbPaymentId.getValue();
        String vehicleId = cmbVehicelId.getValue();

        StudentsDto studentsDto = new StudentsDto(
                studentId,
                studentName,
                dob,
                nic,
                studentAddress,
                studentRegisterDate,
                gender,
                advancePayment,
                helpingAids,
                phoneNumber,
                email,
                adminId,
                courseId,
                paymentPlanId,
                paymentId,
                vehicleId
        );

        boolean isSaved = studentsBO.saveStudent(studentsDto);
        if(isSaved){
            loadNextStudentId();
            txtName.setText("");
            txtDob.setText("");
            txtNic.setText("");
            txtAddress.setText("");
            txtRegisterDate.setText("");
            txtGender.setText("");
            txtAdvancePayment.setText("");
            txtHelpingAids.setText("");
            txtNumber.setText("");
            txtEmail.setText("");
            txtAdmin.setText("");
            cmbCourse.getSelectionModel().clearSelection();
            cmbPaymentPlanId.getSelectionModel().clearSelection();
            cmbPaymentId.getSelectionModel().clearSelection();
            cmbVehicelId.getSelectionModel().clearSelection();
            new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
            loadTableData();
        }else{
            new Alert(Alert.AlertType.ERROR, "Save fail").show();
        }
    }

    public void onClickTable(MouseEvent mouseEvent) {
        StudentsTM studentsTM = tblStudents.getSelectionModel().getSelectedItem();
        if(studentsTM != null){
            lblStudentId.setText(studentsTM.getStudentId());
            txtName.setText(studentsTM.getStudentName());
            txtDob.setText(String.valueOf(studentsTM.getDob()));
            txtNic.setText(studentsTM.getNic());
            txtAddress.setText(studentsTM.getStudentAddress());
            txtRegisterDate.setText(String.valueOf(studentsTM.getStudentRegisterDate()));
            txtGender.setText(studentsTM.getGender());
            txtAdvancePayment.setText(String.valueOf(studentsTM.getAdvancePayment()));
            txtHelpingAids.setText(studentsTM.getHelpingAids());
            txtNumber.setText(String.valueOf(studentsTM.getPhoneNumber()));
            txtEmail.setText(studentsTM.getEmail());
            txtAdmin.setText(studentsTM.getAdminId());
            cmbCourse.getSelectionModel().select(studentsTM.getCourseId());
            cmbPaymentPlanId.getSelectionModel().select(studentsTM.getPaymentPlanId());
            cmbPaymentId.getSelectionModel().select(studentsTM.getPaymentId());
            cmbVehicelId.getSelectionModel().select(studentsTM.getVehicleId());

            btnSave.setDisable(true);
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
        }
    }

    public void refreshOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    public void sendEmailOnAction(ActionEvent actionEvent) {
        StudentsTM selectedItem = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            new Alert(Alert.AlertType.WARNING, "Please select student!");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SendMail.fxml"));
            Parent load = loader.load();

            SendMailController sendMailController = loader.getController();

            String email = selectedItem.getEmail();
            sendMailController.setStudentEmail(email);

            Stage stage = new Stage();
            stage.setScene(new Scene(load));
            stage.setTitle("Send email");

            stage.initModality(Modality.APPLICATION_MODAL);

            Window underWindow = btnUpdate.getScene().getWindow();
            stage.initOwner(underWindow);

            stage.showAndWait();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Fail to load ui..!");
            e.printStackTrace();
        }
    }
    private void loadCourseIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> courseId = coursesBO.getAllCourseIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(courseId);
        cmbCourse.setItems(observableList);
    }

    private void loadPaymentPlanIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> paymentPlanId = paymentPlanBO.loadPaymentPlanIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(paymentPlanId);
        cmbPaymentPlanId.setItems(observableList);
    }

    private void loadPaymentIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> paymentId = paymentPlanBO.loadPaymentIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(paymentId);
        cmbPaymentId.setItems(observableList);
    }

    private void loadVehicelIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> vehicelId = vehicleBO.loadVehicelIds();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(vehicelId);
        cmbVehicelId.setItems(observableList);
    }
}
