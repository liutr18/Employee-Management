package factory;

import dao.IDeptDAO;
import dao.IEmployeeDAO;
import dao.impl.DeptDAOImpl;
import dao.impl.EmployeeDAOImpl;

import java.sql.Connection;

/**
 * DAOFactory class returns an IDAO, which does not specify IDAOImpl class.
 */
public class DAOFactory {
    public static IEmployeeDAO getIEmployeeInstance(Connection conn){
        return new EmployeeDAOImpl(conn);
    }
    public static IDeptDAO getIDeptInstance(Connection conn){return new DeptDAOImpl(conn);    }
}
