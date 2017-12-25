/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.wechatDao;
import com.wechat.wechatDomain.PageBean;
import com.wechat.wechatDomain.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 宣佚
 */
public class UserDao {
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    String sql=null;
    //String strConn;
public User selectByUser(User user) throws ClassNotFoundException, SQLException{
    sql="select count(*) from users where user=? and password=?";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,user.getUsername());
        stat.setString(2, user.getPassword());
        rs=stat.executeQuery();
        if(rs.next()){
            System.out.print(rs.getInt(1));
            if(rs.getInt(1)==1){
                return user;
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

public User selectByUsername(User user) throws SQLException, ClassNotFoundException{
    sql="select count(*) from users where user=?";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,user.getUsername());
        rs=stat.executeQuery();
        if(rs.next()){
            System.out.print(rs.getInt(1));
            if(rs.getInt(1)==1){
                return user;
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

public User selectUserByname(User user) throws SQLException, ClassNotFoundException{
    User _user=new User();
    sql="select user,password,sex from users where user=?";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,user.getUsername());
        rs=stat.executeQuery();
        if(rs.next()){
            _user.setUsername(user.getUsername());
            _user.setPassword(rs.getString("password"));
            _user.setSex(rs.getString("sex"));
        }
        return _user;
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

public int selectAllUsersNumByCondition(String condition,User user) throws ClassNotFoundException, SQLException{
    sql="select user,password,sex from users where 1=1";
    int row=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        if(condition!=null&&condition.equals("all")){
                stat=conn.prepareStatement(sql);
        }
        else if(condition!=null&&condition.equals("user")){
                sql+=" and user like ?";
                stat=conn.prepareStatement(sql);
                stat.setString(1, "%"+user.getUsername()+"%");
        }
        else if(condition!=null&&condition.equals("sex")){
            sql+=" and sex = ?";
            stat=conn.prepareStatement(sql);
            stat.setString(1, user.getSex());
        }
        rs=stat.executeQuery();
        while(rs.next()){
            row++;
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
     return row;
}

public ArrayList<User> selectAllUsersByCondition(PageBean pageBean,String condition,User user) throws ClassNotFoundException, SQLException{
    ArrayList<User> users=new ArrayList();
    sql="select user,password,sex from users where 1=1";
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        if(condition!=null&&condition.equals("all")){
                sql+=" limit ?,?";
                stat=conn.prepareStatement(sql);
                stat.setInt(1, pageBean.getStartIndex());
                stat.setInt(2, pageBean.getPageSize());
        }
        else if(condition!=null&&condition.equals("user")){
                sql+=" and user like ? limit ?,?";
                stat=conn.prepareStatement(sql);
                stat.setString(1, "%"+user.getUsername()+"%");
                stat.setInt(2, pageBean.getStartIndex());
                stat.setInt(3, pageBean.getPageSize());
        }
        else if(condition!=null&&condition.equals("sex")){
            sql+=" and sex=? limit ?,?";
            stat=conn.prepareStatement(sql);
            stat.setString(1, user.getSex());
            stat.setInt(2, pageBean.getStartIndex());
            stat.setInt(3, pageBean.getPageSize());
        }
        rs=stat.executeQuery();
        while(rs.next()){
            User _user=new User();
            _user.setUsername(rs.getString("user"));
            _user.setPassword(rs.getString("password"));
            _user.setSex(rs.getString("sex"));
            users.add(_user);
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
     return users;
}


public int insertUser(User user) throws ClassNotFoundException, SQLException{
   sql="insert into  users (user,password,sex) values(?,?,?)";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,user.getUsername());
        stat.setString(2, user.getPassword()); 
        stat.setString(3, user.getSex());
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

public int updataUserPassword(User user) throws ClassNotFoundException, SQLException{
    sql="update users set password=? where user=?";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1,user.getPassword());
        stat.setString(2, user.getUsername()); 
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

public int updataUser(User user,String username) throws ClassNotFoundException, SQLException{
    sql="update users set user=?, password=?,sex=? where user=?";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1, user.getUsername());
        stat.setString(2,user.getPassword());
        stat.setString(3, user.getSex()); 
        stat.setString(4, username);
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

public int deleteUser(User user) throws ClassNotFoundException, SQLException{
    sql="delete from users where user=?";
   int changeRow=0;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "991227"); 
        System.out.println("数据库连接成功！");
        stat=conn.prepareStatement(sql);
        stat.setString(1, user.getUsername()); 
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

public static void main(String args[]) throws SQLException, ClassNotFoundException{
    User user=new User();
    UserDao userDao=new UserDao();
    user.setUsername("李");
    user.setPassword("12345");
    user.setSex("男");
    int row=userDao.selectAllUsersNumByCondition("sex", user);
    PageBean<User> pageBean=new PageBean(1,6,row);
    ArrayList attr=userDao.selectAllUsersByCondition(pageBean, "sex", user);
    for(int i=0;i<attr.size();i++){
        System.out.println(((User)attr.get(i)).getUsername());
    }
}
}