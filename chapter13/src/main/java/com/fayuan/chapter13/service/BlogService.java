/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.service;

import com.fayuan.chapter13.entity.Blog;

import java.util.List;

/**
 * 博客服务
 *
 * @author mr.24
 * @version Id: BlogService, v 1.0 2019-04-26 22:53 Exp $$
 */
public interface BlogService {

    List<Blog> getBlogs();

    void deleteBlog(long id);
}
