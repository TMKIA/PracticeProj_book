package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Login;

/**
 * @author TMK
 * date 2020/5/2 - 17:58
 */
public interface LoginService {
    //登录检测
    Login checkLogin(String name, String password);

    //修改密码
    boolean changePwd(String name,String oldPwd, String newPwd);
    }
