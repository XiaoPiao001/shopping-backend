package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Data
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
}

