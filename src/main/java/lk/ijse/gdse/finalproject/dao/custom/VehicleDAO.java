package lk.ijse.gdse.finalproject.dao.custom;

import lk.ijse.gdse.finalproject.dao.CrudDAO;
import lk.ijse.gdse.finalproject.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle> {
    ArrayList<String> getAllVehicleType() throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllVehicelIds() throws SQLException, ClassNotFoundException;
}
