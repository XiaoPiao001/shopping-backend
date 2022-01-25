package com.example.shoppingbackend.entity;

import java.io.Serializable;

/**
 * (AdminRole)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public class AdminRole implements Serializable {
    private static final long serialVersionUID = -48743006234059501L;
    /**
     * id
     */
    private Integer id;
    /**
     * 管理员id
     */
    private Integer adminId;
    /**
     * 角色id
     */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}

