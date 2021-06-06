package vo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    /**
     * Every DB table has to match with a simple java class, named VO
     * Use packaging classes in VO to represent null
      */
    private Integer eid;
    private String name;
    private String post;
    private Date hireDate;
    private Float salary;
    private Float bonus;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }
}

