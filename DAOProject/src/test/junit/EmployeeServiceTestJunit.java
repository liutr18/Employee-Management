package test.junit;

import factory.ServiceFactory;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import vo.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTestJunit {
    Employee emp=new Employee();
    @Test
    @Order(1)
    void insert() throws ParseException {
        Employee emp2=new Employee();
        emp.setEid(90015);
        emp.setName("Test Case");
        emp.setPost("Temporary Staff 01");
        Date date= (new SimpleDateFormat("yyyy-MM-dd")).parse("2019-11-17");
        emp.setHireDate(date);
        emp.setSalary(60000.00F);
        emp.setBonus(47500.00F);
        emp2.setEid(10888);
        emp2.setName("Test Case 02");
        emp2.setPost("Temporary Staff 02");
        Date date2= (new SimpleDateFormat("yyyy-MM-dd")).parse("2019-10-28");
        emp2.setHireDate(date2);
        emp2.setSalary(448000.00F);
        emp2.setBonus(409500.00F);
        try {
            assertTrue(ServiceFactory.getIEmployeeServiceInstance().insert(emp)&&
                    ServiceFactory.getIEmployeeServiceInstance().insert(emp2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void update() throws ParseException {
        emp.setEid(90015);
        emp.setName("Test Case");
        emp.setPost("Secretary to General Manager");
        Date date= (new SimpleDateFormat("yyyy-MM-dd")).parse("2020-11-16");
        emp.setHireDate(date);
        emp.setSalary(663000.00F);
        emp.setBonus(402400.00F);
        try {
            assertTrue(ServiceFactory.getIEmployeeServiceInstance().update(emp));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(6)
    void delete() {
        Set<Integer> eids=new HashSet<>();
        eids.add(90015);
        eids.add(10888);
        try{
            assertTrue(ServiceFactory.getIEmployeeServiceInstance().delete(eids));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void findByEid() {
        try{
            assertTrue(ServiceFactory.getIEmployeeServiceInstance().findByEid(10888)!=null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    void listAllEmployees() {
        try{
            assertTrue(!ServiceFactory.getIEmployeeServiceInstance().listAllEmployees().isEmpty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(5)
    @SuppressWarnings("unchecked")
    void fuzzyQuery() {
        Map<String,Object> map=new HashMap<>();
        try{
            map= ServiceFactory.getIEmployeeServiceInstance().fuzzyQuery(1,3,"name","Ray");
            int count=(Integer)map.get("getAllCount");
            List<Employee>employees=(List<Employee>)map.get("findAllSplit");
            assertTrue(count>0&&!employees.isEmpty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}