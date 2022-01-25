package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -80146163748061015L;
    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer roleId;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String roleDesc;
    /**
     * 禁用0 启用1
     */
    @ApiModelProperty("禁用0 启用1")
    private Integer status;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

