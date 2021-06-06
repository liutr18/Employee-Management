package test;

import factory.ServiceFactory;
import vo.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) throws Exception {
        Set<Integer> eids=new HashSet<>();
        eids.add(10887);
        ServiceFactory.getIEmployeeServiceInstance().delete(eids);
        Employee emp1=new Employee();
        emp1.setEid(10887);
        emp1.setName("Bobby Smith");
        emp1.setPost("Senior Data Science Engineer");
        Date date= (new SimpleDateFormat("yyyy-MM-dd")).parse("2021-01-07");
        emp1.setHireDate(date);
        emp1.setSalary(828800.00F);
        emp1.setBonus(777200.00F);
        boolean insertion=ServiceFactory.getIEmployeeServiceInstance().insert(emp1);
        System.out.println(insertion);
    }
}
