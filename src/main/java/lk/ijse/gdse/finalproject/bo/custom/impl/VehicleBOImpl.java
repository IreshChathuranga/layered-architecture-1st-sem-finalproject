package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.VehicleBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.VehicleDAO;
import lk.ijse.gdse.finalproject.entity.Vehicle;
import lk.ijse.gdse.finalproject.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    @Override
    public String getNextVehicleId() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getNextId();
    }
    @Override
    public ArrayList<VehicleDto> getAllVehicles() throws SQLException, ClassNotFoundException {
        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();
        for(Vehicle vehicle : vehicleDAO.getAll()){
            vehicleDtos.add(new VehicleDto(
                    vehicle.getVehicleId(),
                    vehicle.getVehicleType(),
                    vehicle.getLessonFee(),
                    vehicle.getAdminId()
            ));
        }
        return vehicleDtos;
    }
    @Override
    public boolean saveVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(new Vehicle(
                vehicleDto.getVehicleId(),
                vehicleDto.getVehicleType(),
                vehicleDto.getLessonFee(),
                vehicleDto.getAdminId()
        ));
    }
    @Override
    public boolean deleteVehicle(String vehicleId) throws SQLException, ClassNotFoundException {
        return  vehicleDAO.delete(vehicleId);
    }
    @Override
    public boolean updateVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(new Vehicle(
                vehicleDto.getVehicleId(),
                vehicleDto.getVehicleType(),
                vehicleDto.getLessonFee(),
                vehicleDto.getAdminId()
        ));
    }

    @Override
    public ArrayList<String> getAllVehicleType() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getAllVehicleType();
    }

    @Override
    public ArrayList<String> loadVehicelIds() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getAllVehicelIds();
    }
}
