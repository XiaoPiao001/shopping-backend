package com.example.shoppingbackend.dao;

import com.example.shoppingbackend.entity.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Property)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-31 17:08:53
 */
@Mapper
public interface PropertyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Property queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param property 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Property> queryAllByLimit(Property property, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param property 查询条件
     * @return 总行数
     */
    long count(Property property);

    /**
     * 新增数据
     *
     * @param property 实例对象
     * @return 影响行数
     */
    int insert(Property property);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Property> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Property> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Property> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Property> entities);

    /**
     * 修改数据
     *
     * @param property 实例对象
     * @return 影响行数
     */
    int update(Property property);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Property> queryAll();
}

