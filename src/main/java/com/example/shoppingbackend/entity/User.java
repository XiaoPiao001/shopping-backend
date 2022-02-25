package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-12-28 15:30:29
 */
public class User implements Serializable {
    private static final long serialVersionUID = -79372796432570439L;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String name;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private Long phone;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

