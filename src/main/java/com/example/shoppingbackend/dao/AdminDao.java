package com.example.shoppingbackend.dao;

import com.example.shoppingbackend.entity.Admin;
import com.example.shoppingbackend.vo.AdminVO;
import com.example.shoppingbackend.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Mapper
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param admin 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(Admin admin, @Param("pageable") Pageable pageable);

    /**
     * 查询指定行数据 不分页
     *
     * @param admin 查询条件
     * @return 对象列表
     */
    List<Admin> queryAll(Admin admin);

    /**
     * 统计总行数
     *
     * @param admin 查询条件
     * @return 总行数
     */
    long count(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Admin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Admin> entities);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 登录
     * @param admin
     * @return
     */
    AdminVO login(Admin admin);

    /**
     * 根据用户查询其角色和权限
     * @param admin
     * @return
     */
    RoleVO getRoleVOByAdmin(Admin admin);

    /**
     * 根据角色查询该角色下的管理员
     * @param roleId
     * @return
     */
    List<Admin> getAdminByRole(Integer roleId);
}

