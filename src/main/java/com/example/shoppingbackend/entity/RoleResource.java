package com.example.shoppingbackend.entity;

import java.io.Serializable;

/**
 * (RoleResource)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
public class RoleResource implements Serializable {
    private static final long serialVersionUID = -69648210364653691L;
    /**
     * id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 资源id
     */
    private Integer resourceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

}

