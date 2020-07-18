package com.leslie.dao;

import com.leslie.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LeslieCheni
 * @Date Created in 22:29 2020/7/16 0016
 * @Version JDK1.8
 */

public interface UserMapper {

    /**
     * 增加一个用户
     */
    int addUser(User user);


    /**
     * 删除一个用户
     */
    int deleteUser(@Param("userId") Integer id);

    /**
     * 修改一个用户
     */
    int updateUser(User user);


    /**
     * 根据id查询一个用户
     */
    User queryUserById(@Param("userId") Integer id);

    /**
     * 查询所有用户
     */
    List<User> queryAllUser();

    /**
     * 根据用户名查询一个用户
     */
    User queryUserByName(@Param("username") String username);



}
