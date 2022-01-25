package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.AdminRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (AdminRole)表服务接口
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public interface AdminRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdminRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param adminRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AdminRole> queryByPage(AdminRole adminRole, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param adminRole 筛选条件
     * @return 查询结果
     */
    List<AdminRole> queryAll(AdminRole adminRole);

    /**
     * 新增数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    AdminRole insert(AdminRole adminRole);

    /**
     * 修改数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    AdminRole update(AdminRole adminRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
