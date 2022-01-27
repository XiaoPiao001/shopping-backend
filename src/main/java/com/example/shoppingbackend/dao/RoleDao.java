package com.example.shoppingbackend.dao;

import com.example.shoppingbackend.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@Mapper
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(Integer roleId);

    /**
     * 查询指定行数据
     *
     * @param role     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Role> queryAllByLimit(Role role, @Param("pageable") Pageable pageable);

    /**
     * 查询指定行数据 不分页
     *
     * @param role 查询条件
     * @return 对象列表
     */
    List<Role> queryAll(Role role);

    /**
     * 统计总行数
     *
     * @param role 查询条件
     * @return 总行数
     */
    long count(Role role);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Role> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Role> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Role> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Role> entities);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Integer roleId);

    /**
     * 赋予管理员角色
     *
     * @param roleId
     * @param adminIdList
     * @return
     */
    int endueRole(@Param("roleId") Integer roleId, @Param("adminIdList") List<Integer> adminIdList);

    /**
     * 废除管理员角色
     *
     * @param roleId
     * @param adminIdList
     * @return
     */
    int repealRole(@Param("roleId") Integer roleId, @Param("adminIdList") String adminIdList);

}

