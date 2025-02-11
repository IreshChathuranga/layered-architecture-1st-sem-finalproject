package lk.ijse.gdse.finalproject.bo.custom.impl;

import lk.ijse.gdse.finalproject.bo.custom.MaintainersBO;
import lk.ijse.gdse.finalproject.dao.DAOFactory;
import lk.ijse.gdse.finalproject.dao.custom.MaintainersDAO;
import lk.ijse.gdse.finalproject.dao.custom.impl.MaintainersDAOImpl;
import lk.ijse.gdse.finalproject.entity.Lessons;
import lk.ijse.gdse.finalproject.entity.Maintainers;
import lk.ijse.gdse.finalproject.model.MaintainersDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainersBOImpl implements MaintainersBO {
    MaintainersDAO maintainersDAO = (MaintainersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MAINTAINERS);
    @Override
    public String getNextMaintainerId() throws SQLException, ClassNotFoundException {
       return maintainersDAO.getNextId();
    }
    @Override
    public ArrayList<MaintainersDto> getAllMaintainer() throws SQLException, ClassNotFoundException {
        ArrayList<MaintainersDto> maintainersDtos = new ArrayList<>();
        for(Maintainers maintainers : maintainersDAO.getAll()){
            maintainersDtos.add(new MaintainersDto(
                    maintainers.getMaintainId(),
                    maintainers.getMaintainName(),
                    maintainers.getMaintainTask(),
                    maintainers.getContactNumber()
            ));
        }
        return maintainersDtos;
    }
    @Override
    public boolean saveMaintainer(MaintainersDto maintainersDto) throws SQLException, ClassNotFoundException {
        return maintainersDAO.save(new Maintainers(
                maintainersDto.getMaintainId(),
                maintainersDto.getMaintainName(),
                maintainersDto.getMaintainTask(),
                maintainersDto.getContactNumber()
        ));
    }
    @Override
    public boolean deleteMaintainer(String maintainId) throws SQLException, ClassNotFoundException {
        return maintainersDAO.delete(maintainId);
    }
    @Override
    public boolean updateMaintainer(MaintainersDto maintainersDto) throws SQLException, ClassNotFoundException {
        return maintainersDAO.update(new Maintainers(
                maintainersDto.getMaintainId(),
                maintainersDto.getMaintainName(),
                maintainersDto.getMaintainTask(),
                maintainersDto.getContactNumber()
        ));
    }
}
