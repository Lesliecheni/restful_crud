package com.leslie.controller;

import com.leslie.pojo.User;
import com.leslie.service.UserService;
import com.leslie.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lesliecheni
 * date 2020/7/17 17:53.
 */
@Controller
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "userLogin";
    }

    @RequestMapping(value = "/login",produces = "application/json; charset=utf-8")
    public String login(User user, Model model){

        String username = user.getUsername();
        if (null==username||""==username){
            model.addAttribute("msg","用户名不能为空");
            return "redirect:/userLogin";
        }
        User u = userService.queryUserByName(username);
        if (null==u){
            model.addAttribute("msg","用户未注册");
            return "redirect:/userLogin";
        }
        System.out.println(u.getPassword());
        if(u.getPassword().equals(user.getPassword())){

            String token = JwtUtils.createJWT(u.getId().toString(),u.getUsername(),"user");
            System.out.println(token);
            model.addAttribute("token",token);
            model.addAttribute("msg","登录成功！");
            return "redirect:/user";
        }else {
            model.addAttribute("msg","密码不正确！");
            return "redirect:/userLogin";
        }
    }

}
