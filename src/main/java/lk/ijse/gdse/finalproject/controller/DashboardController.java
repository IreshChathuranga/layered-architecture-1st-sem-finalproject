package lk.ijse.gdse.finalproject.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.finalproject.bo.BOFactory;
import lk.ijse.gdse.finalproject.bo.custom.BookedBO;
import lk.ijse.gdse.finalproject.bo.custom.impl.BookedBOImpl;
import lk.ijse.gdse.finalproject.model.BookedDto;
import lk.ijse.gdse.finalproject.model.tm.BookedTM;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Button btbInstructor;
    public Button btnStudent;
    public Button btnMaintainer;
    public Button btnVehicles;
    public AnchorPane dashAnchor;
    public TableView<BookedTM> tblBooking;
    public TableColumn<BookedTM,String> bookId;
    public TableColumn<BookedTM,Date> bookDate;
    public TableColumn<BookedTM,String> bookTime;
    public TableColumn<BookedTM,String> rescheduleReason;

    public void instructorOnAction(ActionEvent actionEvent) throws IOException {
        navigateTo("/view/Instructors.fxml");
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        navigateTo("/view/Students.fxml");
    }

    public void maintainerOnAction(ActionEvent actionEvent) throws IOException {
        navigateTo("/view/Maintainers.fxml");
    }

    public void vehicleOnAction(ActionEvent actionEvent) throws IOException {
        navigateTo("/view/Vehicle.fxml");
    }
    public void navigateTo(String fxmlpath) throws IOException {
        dashAnchor.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlpath));
        dashAnchor.getChildren().add(load);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookDate.setCellValueFactory(new PropertyValueFactory<>("bookDate"));
        bookTime.setCellValueFactory(new PropertyValueFactory<>("bookTime"));
        rescheduleReason.setCellValueFactory(new PropertyValueFactory<>("rescheduleReason"));
        try{
            loadTableData();
        }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Fail Booking id").show();
        }
    }
        BookedBO bookedBO = (BookedBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOKED);
    public void loadTableData() throws SQLException, ClassNotFoundException{
        ArrayList<BookedDto> bookedDtos = bookedBO.getAllBooking(); //loose coupling
        ObservableList<BookedTM> bookedTMS = FXCollections.observableArrayList();
        for(BookedDto bookedDto:bookedDtos){
            BookedTM bookedTM = new BookedTM();
            bookedTM.setBookId(bookedDto.getBookId());
            bookedTM.setBookDate(bookedDto.getBookDate());
            bookedTM.setBookTime(bookedDto.getBookTime());
            bookedTM.setRescheduleReason(bookedDto.getRescheduleReason());
            bookedTMS.add(bookedTM);
        }
        tblBooking.setItems(bookedTMS);
    }
}
