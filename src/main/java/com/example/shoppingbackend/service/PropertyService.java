package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Property)表服务接口
 *
 * @author makejava
 * @since 2021-12-31 17:08:56
 */
public interface PropertyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Property queryById(Integer id);

    /**
     * 分页查询
     *
     * @param property 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Property> queryByPage(Property property, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param property 实例对象
     * @return 实例对象
     */
    Property insert(Property property);

    /**
     * 修改数据
     *
     * @param property 实例对象
     * @return 实例对象
     */
    Property update(Property property);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Property> queryAll();
}
