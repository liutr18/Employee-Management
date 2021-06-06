package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DBURL="jdbc:mysql://rm-j6cyflb4719930ytp9o.mysql.rds.aliyuncs.com:3306/daoproject";
    private static final String DBUSER="daoonly01";
    private static final String PWD="Daoonly01";
    private Connection conn=null;

    public DatabaseConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void closeConnection(){
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
