package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Role;
import com.example.shoppingbackend.vo.AjaxResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(Integer roleId);

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Role> queryByPage(Role role, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    List<Role> queryAll(Role role);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    AjaxResponse insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    AjaxResponse update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleId);

    /**
     * 赋予管理员角色
     * @param roleId
     * @param adminIdList
     * @return
     */
    AjaxResponse endueRole(@Param("roleId") Integer roleId, @Param("adminIdList") List<Integer> adminIdList);

    /**
     * 废除管理员角色
     * @param roleId
     * @param adminIdList
     * @return
     */
    AjaxResponse repealRole(@Param("roleId") Integer roleId, @Param("adminIdList") List<Integer> adminIdList);
}
