package lk.ijse.gdse.finalproject.dao.custom.impl;

import lk.ijse.gdse.finalproject.dao.custom.MaintainersDAO;
import lk.ijse.gdse.finalproject.entity.Maintainers;
import lk.ijse.gdse.finalproject.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainersDAOImpl implements MaintainersDAO {
    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("select maintain_id from maintainer order by maintain_id desc limit 1");
        if(rst.next()){
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIdIndex = i+1;
            return String.format("M%03d",newIdIndex);
        }
        return  "M001";

    }
    @Override
    public ArrayList<Maintainers> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("select * from maintainer");
        ArrayList<Maintainers> maintainersDtos = new ArrayList<>();
        while (rst.next()){
            Maintainers maintainersDto =  new Maintainers(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4));
            maintainersDtos.add(maintainersDto);
        }
        return maintainersDtos;
    }
    @Override
    public boolean save(Maintainers entity) throws SQLException, ClassNotFoundException {
        Boolean isSaved = CrudUtil.execute("insert into maintainer values(?,?,?,?)",entity.getMaintainId(),entity.getMaintainName(),entity.getMaintainTask(),entity.getContactNumber());
        return isSaved;
    }
    @Override
    public boolean delete(String maintainId) throws SQLException, ClassNotFoundException {
        return  CrudUtil.execute("delete from maintainer where maintain_id=?", maintainId);
    }
    @Override
    public boolean update(Maintainers entity) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "update maintainer set maintain_name=?, maintain_task=?,  contact_number=? where maintain_id=?",
                entity.getMaintainName(),
                entity.getMaintainTask(),
                entity.getContactNumber(),
                entity.getMaintainId()
        );
    }

    @Override
    public boolean saveList(ArrayList<Maintainers> entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
