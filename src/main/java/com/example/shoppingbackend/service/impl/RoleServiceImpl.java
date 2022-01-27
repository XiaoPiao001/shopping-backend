package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.dao.RoleDao;
import com.example.shoppingbackend.entity.Role;
import com.example.shoppingbackend.exception.CustomError;
import com.example.shoppingbackend.exception.CustomErrorType;
import com.example.shoppingbackend.service.RoleService;
import com.example.shoppingbackend.vo.AjaxResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
     * @param role        筛选条件
     * @param pageRequest 分页对象
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
    public AjaxResponse insert(Role role) {
        List<Role> roleList = this.roleDao.queryAll(Role.builder().roleName(role.getRoleName()).build());
        if (roleList.size() == 1) {
            return AjaxResponse.error(new CustomError(CustomErrorType.ADDROLE_ERROR, "新增角色失败，该角色已存在"));
        } else {
            this.roleDao.insert(role);
            return AjaxResponse.success(role);
        }
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public AjaxResponse update(Role role) {
        List<Role> roleList = this.roleDao.queryAll(Role.builder().roleName(role.getRoleName()).build());
        if (roleList.size() == 1) {
            return AjaxResponse.error(new CustomError(CustomErrorType.ADDROLE_ERROR, "编辑角色失败，该角色已存在"));
        } else {
            this.roleDao.update(role);
            return AjaxResponse.success(this.queryById(role.getRoleId()));
        }
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

    /**
     * 赋予管理员角色
     *
     * @param roleId
     * @param adminIdList
     * @return
     */
    @Override
    public AjaxResponse endueRole(Integer roleId, List<Integer> adminIdList) {
        Boolean result = this.roleDao.endueRole(roleId, adminIdList) > 0;
        if (!result) {
            return AjaxResponse.error(new CustomError(CustomErrorType.ENDUERESOURCE_ERROR, "赋予管理员角色失败，系统异常"));
        }
        return AjaxResponse.success(result);
    }

    @Override
    public AjaxResponse repealRole(Integer roleId, List<Integer> adminIdList) {
        String adminIds = adminIdList.toString().replace('[', '(').replace(']', ')');
        Boolean result = this.roleDao.repealRole(roleId, adminIds) > 0;
        if (!result) {
            return AjaxResponse.error(new CustomError(CustomErrorType.REPEALROLE_ERROR, "废除管理员角色，系统异常"));
        }
        return AjaxResponse.success(result);
    }
}
