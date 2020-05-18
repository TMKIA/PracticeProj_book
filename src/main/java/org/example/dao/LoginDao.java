package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
	//登录检测
	Login checkLogin(@Param("loginName") String name, @Param("passWord") String password);

	//修改密码
	boolean changePwd(@Param("userName") String name,@Param("oldPwd") String oldPwd,@Param("newPwd") String newPwd);
}
