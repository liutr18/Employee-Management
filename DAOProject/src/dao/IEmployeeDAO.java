package dao;

import vo.Employee;

/**
 * This Interface shows available operations in Data Access Object to Business Object,
 * and wait the Business Object to call.
 */
public interface IEmployeeDAO extends IDAO<Integer,Employee> {
}
