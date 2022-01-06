package com.example.shoppingbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2022-01-04 14:56:52
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 800725877930738260L;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private Long orderNum;
    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String name;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private Long phone;
    /**
     * 订单金额
     */
    @ApiModelProperty(value = "订单金额")
    private Double orderMoney;
    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private String orderState;
    /**
     * 下单日期
     */
    @ApiModelProperty(value = "下单日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderDate;
    /**
     * 下单商品
     */
    @ApiModelProperty(value = "下单商品")
    private String orderGoods;
    /**
     * 收货地址
     */
    @ApiModelProperty(value = "收货地址")
    private String orderAddress;


    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

}

