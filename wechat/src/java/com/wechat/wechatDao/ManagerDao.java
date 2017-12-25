/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.wechatDao;

import com.wechat.wechatDomain.Manager;
import com.wechat.wechatDomain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 宣佚
 */
public class ManagerDao {
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    String sql=null;
    //String strConn;
public Manager selectByManager(Manager manager) throws ClassNotFoundException, SQLException{
    sql="select count(*) from managers where name=? and password=?";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,manager.getName());
        stat.setString(2,manager.getPassword());
        rs=stat.executeQuery();
        if(rs.next()){
            System.out.print(rs.getInt(1));
            if(rs.getInt(1)==1){
                return manager;
            }
        }
       }
    catch(java.sql.SQLException e){
            System.out.println(e.toString());
    }
    finally{
        if(rs!=null){
            rs.close();
    }
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
}
         return null;
}

public Manager selectByManagerName(Manager manager) throws SQLException, ClassNotFoundException{
    sql="select count(*) from managers where name=?";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,manager.getName());
        rs=stat.executeQuery();
        if(rs.next()){
            System.out.print(rs.getInt(1));
            if(rs.getInt(1)==1){
                return manager;
            }
        }
       }
    catch(java.sql.SQLException e){
            System.out.println(e.toString());
    }
    finally{
        if(rs!=null){
            rs.close();
    }
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
}
         return null;
}

public int insertManager(Manager manager) throws ClassNotFoundException, SQLException{
   sql="insert into  managers (name,password) values(?,?)";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,manager.getName());
        stat.setString(2, manager.getPassword()); 
        changeRow=stat.executeUpdate();
}
    catch(java.sql.SQLException e){
            System.out.println(e.toString());
    }
    finally{
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
}
    return changeRow;
}

public int updataManagerPassword(Manager manager) throws ClassNotFoundException, SQLException{
    sql="update managers set password=? where name=?";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,manager.getPassword());
        stat.setString(2, manager.getName()); 
        changeRow=stat.executeUpdate();
}
    catch(java.sql.SQLException e){
            System.out.println(e.toString());
    }
    finally{
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
}
    return changeRow;
}

public int deleteManager(Manager manager) throws ClassNotFoundException, SQLException{
    sql="delete from managers where name=?";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1, manager.getName()); 
        changeRow=stat.executeUpdate();
}
    catch(java.sql.SQLException e){
            System.out.println(e.toString());
    }
    finally{
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
}
    return changeRow;
}
}
