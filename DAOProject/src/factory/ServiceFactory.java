package factory;

import service.IDeptService;
import service.IEmployeeService;
import service.impl.DeptServiceImpl;
import service.impl.EmployeeServiceImpl;

/**
 * ServiceFactory class returns an IService, which does not specify IServiceImpl class.
 */
public class ServiceFactory {
    public static IEmployeeService getIEmployeeServiceInstance(){
        return new EmployeeServiceImpl();
    }
    public static IDeptService getIDeptServiceInstance(){return new DeptServiceImpl();
    }
}
