/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.dao;

import com.fayuan.chapter13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户dao
 *
 * @author mr.24
 * @version Id: UserDao, v 1.0 2019-04-26 00:10 Exp $$
 */
public interface UserDao extends JpaRepository<User, Long> {

    /***
     * 根据名称查询用户
     *
     * @param  username 用户名
     *
     * @return          用户
     */
    User findByUsername(String username);
}
