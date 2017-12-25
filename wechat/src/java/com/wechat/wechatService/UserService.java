/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.wechatService;

import com.wechat.wechatDao.UserDao;
import com.wechat.wechatDomain.PageBean;
import com.wechat.wechatDomain.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 宣佚
 */
public class UserService {
    UserDao userDao=new UserDao();
    public void Register(User user) throws SQLException, ClassNotFoundException, UserException{
       User _user=userDao.selectByUsername(user);
       if(_user!=null){
           throw new UserException("用户名"+user.getUsername()+"已经存在！");
       }
       else{
            if(userDao.insertUser(user)==0){
               throw new UserException("抱歉，用户注册异常失败，请重试!");
            } 
                throw new UserException("用户添加成功！");

            }
      
       }
    
    public PageBean SelectUserOnline(ArrayList attr,int pageNum,int pageSize) throws SQLException, ClassNotFoundException, UserException{
//        User users[];
        User user=new User();
        ArrayList<User> users=new ArrayList();
        int end;
        int online;
        if(attr==null){
            throw new UserException("无在线用户！");
    }
        else{
            online= attr.size();
            PageBean<User> pageBean=new PageBean(pageNum,pageSize,online);
            if(pageBean.getStartIndex()+pageSize>online){
                end=online;
            }
            else{
                end=pageBean.getStartIndex()+pageSize;
            }
//            users=new User[online];
            for(int i=pageBean.getStartIndex();i<end;i++){
                user.setUsername((String) attr.get(i));
                users.add(userDao.selectUserByname(user));
            }
            pageBean.setList(users);
            return pageBean;
        }
 
    }
    
public PageBean selectAllUsersByCondition(int pageNum,int pageSize,String condition,User user) throws ClassNotFoundException, SQLException{
    ArrayList<User> users=new ArrayList();
    UserDao userDao=new UserDao();
    int row=userDao.selectAllUsersNumByCondition(condition, user);
    PageBean pageBean=new PageBean(pageNum,pageSize,row);
    users=userDao.selectAllUsersByCondition(pageBean, condition, user);
    pageBean.setList(users);
    return pageBean;
}

public void deleteUser(User user) throws ClassNotFoundException, SQLException, UserException{
    int row;
    row=userDao.deleteUser(user);
    if(row!=0){
        throw new UserException("删除成功！");
    }
    else{
        throw new UserException("删除失败！");
    }
}

public void updateUser(User user,String username) throws UserException, ClassNotFoundException, SQLException{
    int row;
    if(user.getUsername().length()==0){
        throw new UserException("用户名不可以为空！");
    }
    else{
        if(user.getPassword().length()==0){
            throw new UserException("密码不可以为空！");
        }
        else{
            if(user.getSex().length()==0){
                throw new UserException("性别不可以为空！");
            }
            else{
                if(user.getSex().equals("男")||user.getSex().equals("女")){
                        row=userDao.updataUser(user, username);
                        if(row!=0){
                            throw new UserException("修改成功！");
                        }
                        else{
                            throw new UserException("修改失败！");
                        }
                }
                else{
                    throw new UserException("性别只可以为男或女！");
                }
            }
        }
    }
}
}
