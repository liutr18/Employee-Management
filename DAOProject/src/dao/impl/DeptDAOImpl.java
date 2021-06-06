package dao.impl;

import dao.IDeptDAO;
import vo.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DeptDAOImpl implements IDeptDAO {
    private Connection  conn=null;
    private PreparedStatement pstmt=null;
    public DeptDAOImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public boolean doCreate(Dept vo) throws Exception {
        String sql="INSERT INTO dept(did,location) VALUES (?,?)";
        this.pstmt=this.conn.prepareStatement(sql);
        pstmt.setInt(1,vo.getDid());
        pstmt.setString(2,vo.getLocation());
        return pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Dept vo) throws Exception {
        String sql="UPDATE dept SET location=? WHERE did=?";
        this.pstmt=this.conn.prepareStatement(sql);
        pstmt.setString(1,vo.getLocation());
        pstmt.setInt(2,vo.getDid());
        return pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if (ids==null||ids.isEmpty()){
            return false;
        }
        StringBuffer sql=new StringBuffer("DELETE FROM dept WHERE did IN(");
        Iterator<Integer>iter=ids.iterator();
        while(iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length());
        sql.append(")");
        this.pstmt=this.conn.prepareStatement(sql.toString());
        return pstmt.executeUpdate()==ids.size();
    }

    @Override
    public Dept findByEid(Integer id) throws Exception {
        String sql="SELECT * FROM dept WHERE did=?";
        this.pstmt=this.conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=this.pstmt.executeQuery();
        Dept vo=null;
        if (rs.next()){
            vo=new Dept();
            vo.setDid(rs.getInt(1));
            vo.setLocation(rs.getString(2));
        }
        return vo;
    }

    @Override
    public List<Dept> findAll() throws Exception {
        List<Dept>al=new ArrayList<>();
        String sql="SELECT * FROM dept";
        this.pstmt=this.conn.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();
        while(rs.next()){
            Dept vo=new Dept();
            vo.setDid(rs.getInt(1));
            vo.setLocation(rs.getString(2));
            al.add(vo);
        }
        return al;
    }

    @Override
    public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        throw new Exception("Unused Method");
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        throw new Exception("Unused Method");
    }
}
