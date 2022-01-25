package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -96145308034296333L;
    /**
     * 管理员id
     */
    @ApiModelProperty("管理员id")
    private Integer id;
    /**
     * 管理员名称
     */
    @ApiModelProperty("管理员名称")
    private String adminName;
    /**
     * 管理员密码
     */
    @ApiModelProperty("管理员密码")
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

