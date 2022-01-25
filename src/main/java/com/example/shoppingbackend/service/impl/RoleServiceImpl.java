package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.entity.Role;
import com.example.shoppingbackend.dao.RoleDao;
import com.example.shoppingbackend.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer roleId) {
        return this.roleDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        long total = this.roleDao.count(role);
        return new PageImpl<>(this.roleDao.queryAllByLimit(role, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Role> queryAll(Role role) {
        return this.roleDao.queryAll(role);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleId) {
        return this.roleDao.deleteById(roleId) > 0;
    }
}
