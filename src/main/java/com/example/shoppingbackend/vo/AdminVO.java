package com.example.shoppingbackend.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lenovo
 */
@Data
public class AdminVO {
    private String token;
    private boolean isValidate;
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

    /**
     * 角色
     */
    @ApiModelProperty("角色")
    private RoleVO roleVO;
}
