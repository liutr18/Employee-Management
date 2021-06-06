package service.impl;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IDeptService;
import vo.Dept;

import java.util.List;
import java.util.Set;

public class DeptServiceImpl implements IDeptService {
    private DatabaseConnection dbc=new DatabaseConnection();
    @Override
    public boolean insert(Dept vo) throws Exception {
        try{
            if(DAOFactory.getIDeptInstance(this.dbc.getConnection()).findByEid(vo.getDid())==null){
                return DAOFactory.getIDeptInstance(this.dbc.getConnection()).doCreate(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Dept vo) throws Exception {
        try{
            if (DAOFactory.getIDeptInstance(this.dbc.getConnection()).findByEid(vo.getDid())!=null){
                return DAOFactory.getIDeptInstance(this.dbc.getConnection()).doUpdate(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try{
            return DAOFactory.getIDeptInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return false;
    }

    @Override
    public Dept findByEid(Integer id) throws Exception {
        try{
            return DAOFactory.getIDeptInstance(this.dbc.getConnection()).findByEid(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return null;
    }

    @Override
    public List<Dept> listAllDepts() throws Exception {

        try {
            return DAOFactory.getIDeptInstance(this.dbc.getConnection()).findAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return null;
    }
}
