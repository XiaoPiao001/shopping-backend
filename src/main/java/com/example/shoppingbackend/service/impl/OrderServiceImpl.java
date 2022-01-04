package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.entity.Order;
import com.example.shoppingbackend.dao.OrderDao;
import com.example.shoppingbackend.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-12-31 18:09:34
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderNum 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long orderNum) {
        return this.orderDao.queryById(orderNum);
    }

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Order> queryByPage(Order order, PageRequest pageRequest) {
        long total = this.orderDao.count(order);
        return new PageImpl<>(this.orderDao.queryAllByLimit(order, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param order 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Order> queryAll(Order order) {
        return this.orderDao.queryAll(order);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getOrderNum());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderNum 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long orderNum) {
        return this.orderDao.deleteById(orderNum) > 0;
    }
}
