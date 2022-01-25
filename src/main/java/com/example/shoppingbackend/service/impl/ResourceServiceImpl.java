package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.entity.Resource;
import com.example.shoppingbackend.dao.ResourceDao;
import com.example.shoppingbackend.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Resource)表服务实现类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    private ResourceDao resourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resourceId 主键
     * @return 实例对象
     */
    @Override
    public Resource queryById(Integer resourceId) {
        return this.resourceDao.queryById(resourceId);
    }

    /**
     * 分页查询
     *
     * @param resource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Resource> queryByPage(Resource resource, PageRequest pageRequest) {
        long total = this.resourceDao.count(resource);
        return new PageImpl<>(this.resourceDao.queryAllByLimit(resource, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param resource 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Resource> queryAll(Resource resource) {
        return this.resourceDao.queryAll(resource);
    }

    /**
     * 新增数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource insert(Resource resource) {
        this.resourceDao.insert(resource);
        return resource;
    }

    /**
     * 修改数据
     *
     * @param resource 实例对象
     * @return 实例对象
     */
    @Override
    public Resource update(Resource resource) {
        this.resourceDao.update(resource);
        return this.queryById(resource.getResourceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param resourceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer resourceId) {
        return this.resourceDao.deleteById(resourceId) > 0;
    }
}
