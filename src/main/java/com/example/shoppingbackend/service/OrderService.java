package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-01-04 14:56:53
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderNum 主键
     * @return 实例对象
     */
    Order queryById(Long orderNum);

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Order> queryByPage(Order order, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param order 筛选条件
     * @return 查询结果
     */
    List<Order> queryAll(Order order);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param orderNum 主键
     * @return 是否成功
     */
    boolean deleteById(Long orderNum);

}
