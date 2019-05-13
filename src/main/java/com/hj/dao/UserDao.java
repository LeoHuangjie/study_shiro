package com.hj.dao;

import com.hj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author huangjie
 * @time 2019-04-30 18:15
 */
@Mapper
public interface UserDao {
    Long createUser(User user);

    void createUsers(@Param("list") List<User> users);

    void updateUser(User user);

    void deleteUser(@Param("id") Long userId);

    User findOne(@Param("id") Long userId);

    User findByUsername(String username);

//    Set<String> findRoles(String username);
//
//    Set<String> findPermissions(String username);
}
