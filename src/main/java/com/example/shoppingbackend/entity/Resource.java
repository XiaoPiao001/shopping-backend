package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Resource)实体类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = 352065530010134154L;
    /**
     * id
     */
    @ApiModelProperty("资源id")
    private Integer resourceId;
    /**
     * 资源code
     */
    @ApiModelProperty("资源code")
    private String resourceCode;
    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    private String resourceName;
    /**
     * 资源类型 menu菜单 button按钮
     */
    @ApiModelProperty("资源类型 menu菜单 button按钮")
    private String resourceType;
    /**
     * 1显示 0不显示
     */
    @ApiModelProperty("1显示 0不显示")
    private Integer listHide;


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getListHide() {
        return listHide;
    }

    public void setListHide(Integer listHide) {
        this.listHide = listHide;
    }

}

