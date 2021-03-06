package com.example.shoppingbackend.dao;

import com.example.shoppingbackend.entity.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (RoleResource)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@Mapper
public interface RoleResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleResource queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param roleResource 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RoleResource> queryAllByLimit(RoleResource roleResource, @Param("pageable") Pageable pageable);

    /**
     * 查询指定行数据 不分页
     *
     * @param roleResource 查询条件
     * @return 对象列表
     */
    List<RoleResource> queryAll(RoleResource roleResource);

    /**
     * 统计总行数
     *
     * @param roleResource 查询条件
     * @return 总行数
     */
    long count(RoleResource roleResource);

    /**
     * 新增数据
     *
     * @param roleResource 实例对象
     * @return 影响行数
     */
    int insert(RoleResource roleResource);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleResource> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoleResource> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleResource> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RoleResource> entities);

    /**
     * 修改数据
     *
     * @param roleResource 实例对象
     * @return 影响行数
     */
    int update(RoleResource roleResource);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

