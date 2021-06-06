package dao.impl;

import dao.IEmployeeDAO;
import vo.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This impl class instantiates a Connection, named conn, and instructs DAO to operate.
 * DAOImpl requires param conn as the current connection.
 * pstmt is a standard connection between database and DAO.
 * preparedStatement.executeUpdate() returns the row count for SQL Data Manipulation Language Statements.
 */
public class EmployeeDAOImpl implements IEmployeeDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    public EmployeeDAOImpl(Connection conn){
        this.conn=conn;
    }

    @Override
    public boolean doCreate(Employee vo) throws Exception {
        String sql="INSERT INTO employee(eid, name, post,hireDate, salary, bonus) VALUES (?,?,?,?,?,?)";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getEid());
        this.pstmt.setString(2,vo.getName());
        this.pstmt.setString(3,vo.getPost());
        this.pstmt.setDate(4,new Date(vo.getHireDate().getTime()));
        this.pstmt.setFloat(5,vo.getSalary());
        this.pstmt.setFloat(6,vo.getBonus());
        return this.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Employee vo) throws Exception {
        String sql="UPDATE employee SET name=?, post=?,hireDate=?, salary=?, bonus=? WHERE eid=?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1,vo.getName());
        this.pstmt.setString(2,vo.getPost());
        this.pstmt.setDate(3,new Date(vo.getHireDate().getTime()));
        this.pstmt.setFloat(4,vo.getSalary());
        this.pstmt.setFloat(5,vo.getBonus());
        this.pstmt.setInt(6,vo.getEid());
        return this.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> eids) throws Exception {
        if(eids==null||eids.size()==0){
            return false;
        }
        StringBuffer buf=new StringBuffer("DELETE FROM employee WHERE eid IN(");
        Iterator<Integer>iter=eids.iterator();
        while(iter.hasNext()){
            buf.append(iter.next()).append(",");
        }
        buf.delete(buf.length()-1,buf.length()).append(")");
        this.pstmt=this.conn.prepareStatement(buf.toString());
        return this.pstmt.executeUpdate()== eids.size();
    }

    @Override
    public Employee findByEid(Integer eid) throws Exception {
        Employee ret=null;
        String sql="SELECT * FROM employee WHERE eid=?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,eid);
        ResultSet rs=this.pstmt.executeQuery();
        if(rs.next()){
            ret=new Employee();
            ret.setEid(rs.getInt(1));
            ret.setName(rs.getString(2));
            ret.setPost(rs.getString(3));
            ret.setHireDate(rs.getDate(4));
            ret.setSalary(rs.getFloat(5));
            ret.setBonus(rs.getFloat(6));
        }
        return ret;
    }

    @Override
    public List<Employee> findAll() throws Exception {
        List<Employee> al=new ArrayList<>();
        String sql="SELECT * FROM employee";
        this.pstmt=this.conn.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();
        while(rs.next()){
            Employee emp=new Employee();
            emp.setEid(rs.getInt(1));
            emp.setName(rs.getString(2));
            emp.setPost(rs.getString(3));
            emp.setHireDate(rs.getDate(4));
            emp.setSalary(rs.getFloat(5));
            emp.setBonus(rs.getFloat(6));
            al.add(emp);
        }
        return al;
    }

    @Override
    public List<Employee> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Employee> al=new ArrayList<>();
        String sql="SELECT * FROM (SELECT eid,name,post,hireDate,salary,bonus,ROWNUM rn FROM employee WHERE "+
                column+" LIKE ? AND ROWNUM<=?) temp WHERE temp.rn>?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1,"%"+keyWord+"%");
        this.pstmt.setInt(2,currentPage*lineSize);
        this.pstmt.setInt(3,(currentPage-1)*lineSize);
        ResultSet rs=this.pstmt.executeQuery();
        while (rs.next()){
            Employee emp=new Employee();
            emp.setEid(rs.getInt(1));
            emp.setName(rs.getString(2));
            emp.setPost(rs.getString(3));
            emp.setHireDate(rs.getDate(4));
            emp.setSalary(rs.getFloat(5));
            emp.setBonus(rs.getFloat(6));
            al.add(emp);
        }
        return al;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql="SELECT COUNT(eid) FROM employee WHERE "+column+" LIKE ?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=this.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return null;
    }
}
