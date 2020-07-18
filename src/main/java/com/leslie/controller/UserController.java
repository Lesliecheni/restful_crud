package com.leslie.controller;

import com.leslie.pojo.User;
import com.leslie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LeslieCheni
 * @Date Created in 23:27 2020/7/16 0016
 * @Version JDK1.8
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;



    /**
     * 查询所有书籍
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String list(Model model){
        List<User> users = userService.queryAllUser();
        model.addAttribute("list",users);
        return "allUser";
    }

    /**
     * 增加一个User
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addPaper(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/user";
    }

    /**
     * 更新一个User的信息
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateBook(Model model, User user) {
        System.out.println(user);
        userService.updateUser(user);
        User user_new = userService.queryUserById(user.getId());
        model.addAttribute("user", user_new);
        return "redirect:/user";
    }


    /**
     * 根据id删除一个User
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") Integer id){
        userService.deleteUser(id);
        return "redirect:/user";
    }


    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/user/toAddPage")
    public String toAddPaper(){
        return "addUser";
    }


    /**
     * 跳转到修改页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/toUpdateUser")
    public String toUpdateBook(Model model, int id) {
        User user = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user", user );
        return "updateUser";
    }

    /**
     * 根据用户名查询一个用户
     */
    @RequestMapping(value = "/user/queryUser",method = RequestMethod.POST)
    public String queryUser(String queryUserName,Model model){
        User user = userService.queryUserByName(queryUserName);

        //System.err.println(books);
        List<User> list = new ArrayList<User>();
        list.add(user);

        if (user==null){
            list = userService.queryAllUser();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allUser";
    }





}
