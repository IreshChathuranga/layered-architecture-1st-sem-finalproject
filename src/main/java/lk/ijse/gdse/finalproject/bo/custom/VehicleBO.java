package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    public String getNextVehicleId() throws SQLException, ClassNotFoundException;
    public ArrayList<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException;
    public boolean saveVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException;
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException;
    public boolean updateVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllVehicleType() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadVehicelIds() throws SQLException, ClassNotFoundException;
}
