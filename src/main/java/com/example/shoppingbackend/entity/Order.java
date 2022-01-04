package com.example.shoppingbackend.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-12-31 18:09:33
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -45349069990242645L;
    /**
     * 订单号
     */
    private Long orderNum;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 联系电话
     */
    private Long phone;
    /**
     * 订单金额
     */
    private Double orderMoney;
    /**
     * 订单状态

     */
    private String orderState;
    /**
     * 下单日期
     */
    private Date orderDate;
    /**
     * 下单商品
     */
    private String orderGoods;


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

}

