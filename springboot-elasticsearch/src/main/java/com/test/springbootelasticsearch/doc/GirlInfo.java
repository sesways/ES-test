package com.test.springbootelasticsearch.doc;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "girl",type = "info")
public class GirlInfo implements Serializable {
    /**
     * ES底层的id是long类型，如果使用其他类型会报错；
     */
    private Long id;
    private String name;
    private Integer age;
    private Date date;
    private String email;

    /**
     * 反序列化需要用到无参构造函数，如果不写会报错；
     */
    public GirlInfo() {
    }

    public GirlInfo(String name, Integer age, Date date, String email) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
