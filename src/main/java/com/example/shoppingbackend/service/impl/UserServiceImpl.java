package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.dao.UserDao;
import com.example.shoppingbackend.entity.User;
import com.example.shoppingbackend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 15:32:27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String name) {
        return this.userDao.queryById(name);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getName());
    }

    /**
     * 通过主键删除数据
     *
     * @param name 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String name) {
        return this.userDao.deleteById(name) > 0;
    }

    @Override
    public List<User> queryAll() {
        return this.userDao.queryAll();
    }
}
