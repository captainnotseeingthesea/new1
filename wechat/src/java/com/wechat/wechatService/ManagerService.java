/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechat.wechatService;

import com.wechat.wechatDao.ManagerDao;
import com.wechat.wechatDomain.Manager;
import java.sql.SQLException;

/**
 *
 * @author 宣佚
 */
public class ManagerService {
   private ManagerDao managerDao=new ManagerDao();
   public  Manager login(Manager manager) throws ClassNotFoundException, SQLException{
       Manager _manager=managerDao.selectByManager(manager);
       if(_manager!=null){
           return _manager;
       }
       return null;
   }
   public void  register(Manager manager)throws ManagerException, SQLException, ClassNotFoundException{
       Manager _manager=managerDao.selectByManagerName(manager);
       if(_manager!=null){
           throw new ManagerException("用户名"+manager.getName()+"已经存在！");
       }
       else{
            if(managerDao.insertManager(manager)==0){
               throw new ManagerException("抱歉，用户注册异常失败，请重试!");
            }  
       }
   }
}
