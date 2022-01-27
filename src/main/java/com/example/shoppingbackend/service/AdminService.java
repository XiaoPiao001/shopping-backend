package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Admin;
import com.example.shoppingbackend.vo.AdminVO;
import com.example.shoppingbackend.vo.AjaxResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Admin> queryByPage(Admin admin, PageRequest pageRequest);

    /**
     * 查询指定行数据
     *
     * @param admin 筛选条件
     * @return 查询结果
     */
    List<Admin> queryAll(Admin admin);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 登录
     * @param admin
     * @return
     */
    AjaxResponse login(Admin admin);

    /**
     * 根据角色查询该角色下的管理员
     * @param roleId
     * @return
     */
    AjaxResponse getAdminByRole(Integer roleId);
}
