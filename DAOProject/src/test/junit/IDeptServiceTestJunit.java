package test.junit;

import factory.ServiceFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import vo.Dept;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IDeptServiceTestJunit {

    @Test
    @Order(1)
    void insert() {
        Dept vo=new Dept();
        vo.setDid(95616);
        vo.setLocation("California");
        try{
            assertTrue(ServiceFactory.getIDeptServiceInstance().insert(vo));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void update() {
        Dept vo=new Dept();
        vo.setDid(95616);
        vo.setLocation("Davis Campus");
        try{
            assertTrue(ServiceFactory.getIDeptServiceInstance().update(vo));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(5)
    void delete() {
        try{
            Set<Integer>ids=new HashSet<>();
            ids.add(95616);
            assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void findByEid() {
        try {
            assertNotNull(ServiceFactory.getIDeptServiceInstance().findByEid(95616));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(4)
    void listAllDepts() {
        try {
            assertNotNull(ServiceFactory.getIDeptServiceInstance().listAllDepts());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}