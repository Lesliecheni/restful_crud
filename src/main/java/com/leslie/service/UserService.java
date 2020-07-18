package com.leslie.service;

import com.leslie.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LeslieCheni
 * @Date Created in 22:43 2020/7/16 0016
 * @Version JDK1.8
 */

public interface UserService {
    /**
     * 增加一个用户
     */
    int addUser(User user);


    /**
     * 删除一个用户
     */
    int deleteUser(Integer id);

    /**
     * 修改一个用户
     */
    int updateUser(User user);


    /**
     * 根据id查询一个用户
     */
    User queryUserById(Integer id);

    /**
     * 查询所有用户
     */
    List<User> queryAllUser();

    /**
     * 根据用户名查询一个用户
     */
    User queryUserByName(String username);
}
