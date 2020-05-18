package org.example.controller;

import org.example.entity.Login;
import org.example.service.LoginService;
import org.example.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author TMK
 * date 2020/5/2 - 17:59
 */

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"loginUser"})
public class LoginController {

    @Resource(name = "loginServiceImpl")
    private LoginService loginService;

    /*确认登录*/
    @RequestMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request, Model model, String loginName, String passWord) {
        Login loginUser = loginService.checkLogin(loginName, passWord);
        model.addAttribute("loginUser",loginUser);
        if (loginUser != null) {
            return "main";
        } else {
            return "error";
        }
    }

    /*修改密码*/
    @RequestMapping("/changePwd")
    public String changePwd(@ModelAttribute(value = "loginUser") Login loginUser,  String loginName, String oldPwd, String newPwd) {
        boolean flag = loginService.changePwd(loginName, oldPwd, newPwd);
        if (flag){
            return "forward:/user/logOut";
        }else{
            return "main";
        }

    }

    /*返回主菜单*/
    @RequestMapping("returnMain")
    public String returnMain(@ModelAttribute(value = "loginUser") Login loginUser,Model model){
        if (loginUser!=null) {
            return "main";
        }else{
            return "login";
        }
    }
    /*注销*/
    @RequestMapping("/logOut")
    public String logOut(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "login";
    }

    @ModelAttribute
    public Login getLoginUser(){
        return new Login();
    }

}
