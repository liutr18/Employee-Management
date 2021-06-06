package service;

import vo.Employee;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This interface shows available operations in Service(Business Object,BO) to Control layer.
 */
public interface IEmployeeService {
    public boolean insert(Employee vo) throws Exception;
    public boolean update(Employee vo) throws Exception;
    public boolean delete(Set<Integer> eids) throws  Exception;
    public Employee findByEid(Integer eid) throws  Exception;
    public List<Employee> listAllEmployees() throws Exception;

    /**
     * fuzzyQuery calls IEmployeeDAO.findAllSplit(), returning List<Employee>
     * and calls IEmployeeDAO.getAllCount(), returning Integer.
     * @return if String="findAllSplit", Object=List<Employee>
     *     if String="getAllCount", Object=Integer
     * @throws Exception
     */
    public Map<String,Object> fuzzyQuery(Integer currentPage,Integer lineSize,String column,String keyWord)
            throws Exception;
}
