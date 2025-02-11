package lk.ijse.gdse.finalproject.bo.custom;

import lk.ijse.gdse.finalproject.bo.SuperBO;
import lk.ijse.gdse.finalproject.model.MaintainersDto;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MaintainersBO extends SuperBO {
    public String getNextMaintainerId() throws SQLException, ClassNotFoundException;
    public ArrayList<MaintainersDto> getAllMaintainer() throws SQLException, ClassNotFoundException;
    public boolean saveMaintainer(MaintainersDto maintainersDto) throws SQLException, ClassNotFoundException;
    public boolean deleteMaintainer(String maintainId) throws SQLException, ClassNotFoundException;
    public boolean updateMaintainer(MaintainersDto maintainersDto) throws SQLException, ClassNotFoundException;
}
