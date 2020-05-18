package org.example.service.impl;

import org.example.dao.LoginDao;
import org.example.entity.Login;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author TMK
 * date 2020/5/2 - 18:20
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    @Override
    public Login checkLogin(String name, String password) {
        return loginDao.checkLogin(name, password);
    }

    @Override
    public boolean changePwd(String name, String oldPwd, String newPwd) {
        return loginDao.changePwd(name,oldPwd,newPwd);
    }
}



