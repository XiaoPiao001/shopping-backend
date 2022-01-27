package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.dao.AdminDao;
import com.example.shoppingbackend.entity.Admin;
import com.example.shoppingbackend.exception.CustomError;
import com.example.shoppingbackend.exception.CustomErrorType;
import com.example.shoppingbackend.service.AdminService;
import com.example.shoppingbackend.vo.AdminVO;
import com.example.shoppingbackend.vo.AjaxResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Admin> queryByPage(Admin admin, PageRequest pageRequest) {
        long total = this.adminDao.count(admin);
        return new PageImpl<>(this.adminDao.queryAllByLimit(admin, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param admin 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Admin> queryAll(Admin admin) {
        return this.adminDao.queryAll(admin);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }

    /**
     * 登录
     * @param admin
     * @return
     */
    @Override
    public AjaxResponse login(Admin admin) {
        List<Admin> adminTo = adminDao.queryAll(admin);
        if (adminTo.isEmpty()){
            return AjaxResponse.error(new CustomError(CustomErrorType.LOGIN_ERROR,"用户名或密码错误"));
        }
        AdminVO adminVO = adminDao.login(adminTo.get(0));
        return AjaxResponse.success(adminVO);
    }

    @Override
    public AjaxResponse getAdminByRole(Integer roleId) {
        return AjaxResponse.success(this.adminDao.getAdminByRole(roleId));
    }
}
