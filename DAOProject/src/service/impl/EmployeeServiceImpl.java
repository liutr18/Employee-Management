package service.impl;

import dbc.DatabaseConnection;
import factory.DAOFactory;
import service.IEmployeeService;
import vo.Employee;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This impl class instantiates a DB connection, named dbc, and instructs Service to operate.
 */
public class EmployeeServiceImpl implements IEmployeeService {

    private DatabaseConnection dbc=new DatabaseConnection();

    @Override
    public boolean insert(Employee vo) throws Exception {
        try {
            if(DAOFactory.getIEmployeeInstance(dbc.getConnection()).findByEid(vo.getEid())==null){
                return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doCreate(vo);
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Employee vo) throws Exception {
        try{
            return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return  false;
    }

    @Override
    public boolean delete(Set<Integer> eids) throws Exception {
        try{
            return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doRemoveBatch(eids);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return false;
    }

    @Override
    public Employee findByEid(Integer eid) throws Exception {
        try {
            return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findByEid(eid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return null;
    }

    @Override
    public List<Employee> listAllEmployees() throws Exception {
        try {
            return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return null;
    }

    @Override
    public Map<String, Object> fuzzyQuery(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        try {
            Map<String,Object>map=new HashMap<>();
            map.put("findAllSplit",DAOFactory.getIEmployeeInstance(dbc.getConnection()).
                    findAllSplit(currentPage, lineSize, column, keyWord));
            map.put("getAllCount",DAOFactory.getIEmployeeInstance(dbc.getConnection()).
                    getAllCount(column,keyWord));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.closeConnection();
        }
        return null;
    }
}
