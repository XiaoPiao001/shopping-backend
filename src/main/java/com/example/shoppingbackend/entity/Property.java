package com.example.shoppingbackend.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Property)实体类
 *
 * @author makejava
 * @since 2021-12-31 17:08:54
 */
public class Property implements Serializable {
    private static final long serialVersionUID = 751169451605112202L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 商品编号id
     */
    @ApiModelProperty(value = "商品编号id")
    private Integer itemId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;
    /**
     * 商品类别
     */
    @ApiModelProperty(value = "商品类别")
    private String type;
    /**
     * 商品颜色
     */
    @ApiModelProperty(value = "商品颜色")
    private String color;
    /**
     * 商品容量
     */
    @ApiModelProperty(value = "商品容量")
    private String capacity;
    /**
     * 商品型号
     */
    @ApiModelProperty(value = "商品型号")
    private String code;
    /**
     * 商品配置
     */
    @ApiModelProperty(value = "商品配置")
    private String configure;
    /**
     * 商品重量
     */
    @ApiModelProperty(value = "商品重量")
    private Double weight;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConfigure() {
        return configure;
    }

    public void setConfigure(String configure) {
        this.configure = configure;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}

