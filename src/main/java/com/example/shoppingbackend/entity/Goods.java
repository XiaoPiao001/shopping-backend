package com.example.shoppingbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-12-29 19:12:39
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = -43699087284612606L;
    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private Integer id;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;
    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private Double price;
    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer num;
    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String describe;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}

