package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.entity.RoleResource;
import com.example.shoppingbackend.dao.RoleResourceDao;
import com.example.shoppingbackend.service.RoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleResource)表服务实现类
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl implements RoleResourceService {
    @Resource
    private RoleResourceDao roleResourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleResource queryById(Integer id) {
        return this.roleResourceDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleResource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RoleResource> queryByPage(RoleResource roleResource, PageRequest pageRequest) {
        long total = this.roleResourceDao.count(roleResource);
        return new PageImpl<>(this.roleResourceDao.queryAllByLimit(roleResource, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param roleResource 筛选条件
     * @return 查询结果
     */
    @Override
    public List<RoleResource> queryAll(RoleResource roleResource) {
        return this.roleResourceDao.queryAll(roleResource);
    }

    /**
     * 新增数据
     *
     * @param roleResource 实例对象
     * @return 实例对象
     */
    @Override
    public RoleResource insert(RoleResource roleResource) {
        this.roleResourceDao.insert(roleResource);
        return roleResource;
    }

    /**
     * 修改数据
     *
     * @param roleResource 实例对象
     * @return 实例对象
     */
    @Override
    public RoleResource update(RoleResource roleResource) {
        this.roleResourceDao.update(roleResource);
        return this.queryById(roleResource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleResourceDao.deleteById(id) > 0;
    }
}
