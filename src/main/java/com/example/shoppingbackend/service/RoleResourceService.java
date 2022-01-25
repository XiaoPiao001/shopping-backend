package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.RoleResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (RoleResource)表服务接口
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
public interface RoleResourceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleResource queryById(Integer id);

    /**
     * 分页查询
     *
     * @param roleResource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RoleResource> queryByPage(RoleResource roleResource, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param roleResource 筛选条件
     * @return 查询结果
     */
    List<RoleResource> queryAll(RoleResource roleResource);

    /**
     * 新增数据
     *
     * @param roleResource 实例对象
     * @return 实例对象
     */
    RoleResource insert(RoleResource roleResource);

    /**
     * 修改数据
     *
     * @param roleResource 实例对象
     * @return 实例对象
     */
    RoleResource update(RoleResource roleResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
