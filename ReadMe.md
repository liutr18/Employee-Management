# Employee Management Project 


# What can it do?
Create, Read, Update, Delete (hereafter as **CURD**) employees' information, automatically guaranteeing each employee's ID is exclusive.

# How are employee's information stored in MySQL?

Variable | Numeric Type | Nullable
---|---|---
Employee ID | INT | No
Name | VARCHAR(100) | Yes
Post | VARCHAR(100) | Yes
HireDate | DATE | Yes
Salary | FLOAT | Yes
Bonus | FLOAT | Yes

# How to test its availablity and implement it?
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
If the Junit Test shows "total 6 passed 6", then it is available to use this whole project. Otherwise, it requires a double-check on the aforementioned steps. Provided APIs on the Control layer are in the following interface. This interface shows 6 available operations of Service Layer (Business Object, BO) to Control layer.
```
src/service/IEmployeeService.java
```
# What is the Junit Test for?
The Junit Test is designed for testing all 6 functions under the Service Interface with an order of insert, update, find, list, fuzzyQuery, and delete. Once the Junit Test passed 6 in total 6, it means that the remote MySQL database is correctly connected, created and used; the interface, implementation class and factory class in DAO and Service Layer are correctly designed and connected.
# What are the APIs on the Service Layer?
There are 6 APIs on the Service Layer, consisting of insertion, enquiry, update, deletion, listing, and fuzzy query.
```
public boolean insert(Employee vo) throws Exception;

public Employee findByEid(Integer eid) throws  Exception;

public boolean update(Employee vo) throws Exception;

public boolean delete(Set<Integer> eids) throws  Exception;

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
```
# What are the APIs on the DAO Layer?
There are 7 APIs on the DAO Layer, consisting of CRUD, listing, fuzzy query, and count data of query.
```
public boolean doCreate(V vo) throws Exception;

public V findByEid(K id) throws  Exception;

public boolean doUpdate(V vo) throws Exception;

public boolean doRemoveBatch(Set<K> ids) throws Exception;

public List<V> findAll() throws Exception;

/**
* make a fuzzy query in current page
* @param currentPage current page
* @param lineSize number of data in every page
* @param column query column
* @param keyWord query keyWord
* @return
* @throws Exception
*/
public List<V> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord) throws Exception;

/**
* Count number of returned data of a fuzzy query
* @param column query column
* @param keyWord query keyWord
* @return
* @throws Exception
*/
public K getAllCount(String column,String keyWord) throws  Exception;
```
# Where is the MySQL database connected to?
The web server is located at a remote instance. This project created a database "daoproject" for Employee Management, tables named "employee" and "dept", and a database user "daoonly01" with authorizations to manipulate data in this database. Users have the authority to implement all functions on the Service Layer.
