/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.entity;

/**
 * 博客实体
 *
 * @author mr.24
 * @version Id: Blog, v 1.0 2019-04-24 21:04 Exp $$
 */
public class Blog {

    private Long id;
    private String name;
    private String content;

    public Blog(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>content</tt>.
     *
     * @return property value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

