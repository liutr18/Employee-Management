# Employee Management Project designed & created by Tianren Liu


# What can it do?
Create, Read, Update, Delete (hereafter as **CURD**) employees' information, automatically guaranteeing each employee's ID is exclusive.

# What does an employee's information include?

Variable | Numeric Type | Nullable
---|---|---
Employee ID | Integer | No
Name | String | Yes
Post | String | Yes
HireDate | Date | Yes
Salary | Float | Yes
Bonus | Float | Yes

# How to use it?
Download the Employee-Management File and Import the MySQL connector to the project library. 
```
lib/mysql-connector-java-8.0.25.jar
```
Run a terminal of Navicat 15 for MySQL, and run the following .sql file to initialize the database.
```
src/Database.sql
```
After the initialization of the database, named "daoproject", it is available to connect the MySQL server by launching the following file because the Database driver, URL, user, and password are already provided.
```
src/dbc/DatabaseConnection.java
```
Run the Junit Test to test availability of Employee Service Interface.
```
src/test/junit/EmployeeServiceTestJunit.java
```
If the Junit Test shows "total 5 passed 5", then it is available to use this whole project. Otherwise, it requires a double-check on the aforementioned steps. Provided APIs on the Control layer are in the following interface. This interface shows 6 available operations of Service Layer (Business Object, BO) to Control layer.
```
src/service/IEmployeeService.java
```
Available Functions are:

```
// Create
public boolean insert(Employee vo) throws Exception;
// Read
public Employee findByEid(Integer eid) throws  Exception;
// Update
public boolean update(Employee vo) throws Exception;
// Delete
public boolean delete(Set<Integer> eids) throws  Exception;

// Read info of all Employees
public List<Employee> listAllEmployees() throws Exception;

// Fuzzy Query
/**
 * fuzzyQuery calls IEmployeeDAO.findAllSplit(), returning List<Employee>
 * and calls IEmployeeDAO.getAllCount(), returning Integer.
 * @return if String="findAllSplit", Object=List<Employee>
 *     if String="getAllCount", Object=Integer
 * @throws Exception
 */
public Map<String,Object> fuzzyQuery(Integer currentPage,Integer lineSize,String column,String keyWord)
        throws Exception;
```
