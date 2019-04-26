/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.service.impl;

import com.fayuan.chapter13.entity.Blog;
import com.fayuan.chapter13.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 博客服务实现类
 *
 * @author mr.24
 * @version Id: BlogServiceImpl, v 1.0 2019-04-26 22:55 Exp $$
 */
@Service
public class BlogServiceImpl implements BlogService {

    private List<Blog> list = new ArrayList<>();

    public BlogServiceImpl() {
        list.add(new Blog(1L, "spring in action.", "good"));
        list.add(new Blog(2L, "spring boot in action,", "nice"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(long id) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Blog blog = (Blog) iterator.next();
            if (id == blog.getId()) {
                iterator.remove();
            }
        }
    }
}
