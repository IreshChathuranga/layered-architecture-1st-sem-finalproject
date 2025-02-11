package lk.ijse.gdse.finalproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import lk.ijse.gdse.finalproject.bo.BOFactory;
import lk.ijse.gdse.finalproject.bo.custom.InstructorsBO;
import lk.ijse.gdse.finalproject.bo.custom.impl.InstructorsBOImpl;
import lk.ijse.gdse.finalproject.model.InstructorsDto;
import lk.ijse.gdse.finalproject.model.tm.InstructorsTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class InstructorsController implements Initializable {
    public TableView<InstructorsTM> tblInstructor;
    public TableColumn<InstructorsTM,String> instructorId;
    public TableColumn<InstructorsTM,String> instructorName;
    public TableColumn<InstructorsTM,Integer> instructorAge;
    public TableColumn<InstructorsTM,String> instructorAddress;
    public TableColumn<InstructorsTM,String> certificationDetail;
    public TableColumn<InstructorsTM,String> adminId;
    public Label lblCertification;
    public TextField txtAddress;
    public Label lblInstructorAddress;
    public TextField txtAdminId;
    public Label lblAdminId;
    public Label lblInstructorAge;
    public Label lblInstructorName;
    public TextField txtAge;
    public TextField txtName;
    public Label lblInstructorId;
    public Label lblInstructor;
    public TextField txtCertification;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;
    public Rectangle reInstructor;
    InstructorsBO instructorsBO = (InstructorsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INSTRUCTORS);
    private void loadTableData() throws SQLException, ClassNotFoundException {
        ArrayList<InstructorsDto> instructorsDtos = instructorsBO.getAllInstructors();
        ObservableList<InstructorsTM> instructorsTMS = FXCollections.observableArrayList();
        for(InstructorsDto instructorsDto:instructorsDtos){
            InstructorsTM instructorsTM=new InstructorsTM();
            instructorsTM.setInstructorId(instructorsDto.getInstructorId());
            instructorsTM.setInstructorName(instructorsDto.getInstructorName());
            instructorsTM.setInstructorAge(instructorsDto.getInstructorAge());
            instructorsTM.setInstructorAddress(instructorsDto.getInstructorAddress());
            instructorsTM.setCertificationDetail(instructorsDto.getCertificationDetail());
            instructorsTM.setAdminId(instructorsDto.getAdminId());
            instructorsTMS.add(instructorsTM);
        }
        tblInstructor.setItems(instructorsTMS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructorId.setCellValueFactory(new PropertyValueFactory<>("instructorId"));
        instructorName.setCellValueFactory(new PropertyValueFactory<>("instructorName"));
        instructorAge.setCellValueFactory(new PropertyValueFactory<>("instructorAge"));
        instructorAddress.setCellValueFactory(new PropertyValueFactory<>("instructorAddress"));
        certificationDetail.setCellValueFactory(new PropertyValueFactory<>("certificationDetail"));
        adminId.setCellValueFactory(new PropertyValueFactory<>("adminId"));

        try{
            refreshPage();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Fail Instructor id").show();
        }
    }
    public void loadNextInstructorId() throws SQLException, ClassNotFoundException {
        String nextInstructorId = instructorsBO.getNextInstructorId();
        lblInstructor.setText(nextInstructorId);
    }
    public void onClickTable(MouseEvent mouseEvent) {
        InstructorsTM instructorsTM = tblInstructor.getSelectionModel().getSelectedItem();
        if (instructorsTM != null) {
            lblInstructor.setText(instructorsTM.getInstructorId());
            txtName.setText(instructorsTM.getInstructorName());
            txtAge.setText(String.valueOf(instructorsTM.getInstructorAge()));
            txtAddress.setText(instructorsTM.getInstructorAddress());
            txtCertification.setText(instructorsTM.getCertificationDetail());
            txtAdminId.setText(instructorsTM.getAdminId());

            btnSave.setDisable(true);

            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }
    }

    public void refreshOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String instructorId = lblInstructor.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = instructorsBO.deleteInstructor(instructorId);
            if (isDeleted) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Instructor deleted").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete instructor...!").show();
            }
        }
    }
    private void refreshPage() throws SQLException, ClassNotFoundException {
        loadNextInstructorId();
        loadTableData();

        btnSave.setDisable(false);

        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);

        txtName.setText("");
        txtAge.setText("");
        txtAddress.setText("");
        txtCertification.setText("");
        txtAdminId.setText("");
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String instructorId = lblInstructor.getText();
        String instructorName = txtName.getText();
        int instructorAge = Integer.parseInt(txtAge.getText());
        String instructorAddress = txtAddress.getText();
        String certificationDetail = txtCertification.getText();
        String adminId = txtAdminId.getText();

            InstructorsDto instructorsDto = new InstructorsDto(
                    instructorId,
                    instructorName,
                    instructorAge,
                    instructorAddress,
                    certificationDetail,
                    adminId
            );

            boolean isSaved = instructorsBO.saveInstructor(instructorsDto);
            if (isSaved) {
                loadNextInstructorId();
                txtName.setText("");
                txtAge.setText("");
                txtAddress.setText("");
                txtCertification.setText("");
                txtAdminId.setText("");
                new Alert(Alert.AlertType.INFORMATION, "Instructor Saved").show();
                loadTableData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Save fail").show();

            }

    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String instructorId = lblInstructor.getText();
        String instructorName = txtName.getText();
        int instructorAge = Integer.parseInt(txtAge.getText());
        String instructorAddress = txtAddress.getText();
        String certificationDetail = txtCertification.getText();
        String adminId = txtAdminId.getText();

            InstructorsDto instructorsDto = new InstructorsDto(
                    instructorId,
                    instructorName,
                    instructorAge,
                    instructorAddress,
                    certificationDetail,
                    adminId
            );

            boolean isUpdate = instructorsBO.updateInstructor(instructorsDto);
            if (isUpdate) {
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Instructor Updated").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update instructor...!").show();
            }

    }
}
