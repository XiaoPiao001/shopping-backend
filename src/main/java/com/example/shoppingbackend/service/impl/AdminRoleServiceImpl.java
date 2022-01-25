package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.entity.AdminRole;
import com.example.shoppingbackend.dao.AdminRoleDao;
import com.example.shoppingbackend.service.AdminRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminRole)表服务实现类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService {
    @Resource
    private AdminRoleDao adminRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdminRole queryById(Integer id) {
        return this.adminRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param adminRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AdminRole> queryByPage(AdminRole adminRole, PageRequest pageRequest) {
        long total = this.adminRoleDao.count(adminRole);
        return new PageImpl<>(this.adminRoleDao.queryAllByLimit(adminRole, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param adminRole 筛选条件
     * @return 查询结果
     */
    @Override
    public List<AdminRole> queryAll(AdminRole adminRole) {
        return this.adminRoleDao.queryAll(adminRole);
    }

    /**
     * 新增数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    @Override
    public AdminRole insert(AdminRole adminRole) {
        this.adminRoleDao.insert(adminRole);
        return adminRole;
    }

    /**
     * 修改数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    @Override
    public AdminRole update(AdminRole adminRole) {
        this.adminRoleDao.update(adminRole);
        return this.queryById(adminRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminRoleDao.deleteById(id) > 0;
    }
}
