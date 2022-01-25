package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (Resource)表服务接口
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public interface ResourceService {

    /**
     * 通过ID查询单条数据
     *
     * @param resourceId 主键
     * @return 实例对象
     */
    Resource queryById(Integer resourceId);

    /**
     * 分页查询
     *
     * @param resource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Resource> queryByPage(Resource resource, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param resource 筛选条件
     * @return 查询结果
     */
    List<Resource> queryAll(Resource resource);

    /**
     * 新增数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    Resource insert(Resource resource);

    /**
     * 修改数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    Resource update(Resource resource);

    /**
     * 通过主键删除数据
     *
     * @param resourceId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer resourceId);

}
