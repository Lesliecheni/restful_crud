package com.leslie.service;

import com.leslie.dao.UserMapper;
import com.leslie.pojo.User;
import com.leslie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LeslieCheni
 * @Date Created in 22:44 2020/7/16 0016
 * @Version JDK1.8
 */
@Service
public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
