package com.example.shoppingbackend.vo;

import com.example.shoppingbackend.entity.Resource;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author lenovo
 */
@Data
public class RoleVO {
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

    /**
     * 资源列表
     */
    @ApiModelProperty("资源列表")
    private List<Resource> resourceList;
}
