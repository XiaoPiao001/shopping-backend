package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.AdminRole;
import com.example.shoppingbackend.service.AdminRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminRole)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@RestController
@RequestMapping("adminRole")
public class AdminRoleController {
    /**
     * 服务对象
     */
    @Resource
    private AdminRoleService adminRoleService;

    /**
     * 分页查询
     *
     * @param adminRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<AdminRole>> queryByPage(AdminRole adminRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.adminRoleService.queryByPage(adminRole, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param adminRole 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<AdminRole>> queryAll(AdminRole adminRole) {
        return ResponseEntity.ok(this.adminRoleService.queryAll(adminRole));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<AdminRole> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.adminRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param adminRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<AdminRole> add(AdminRole adminRole) {
        return ResponseEntity.ok(this.adminRoleService.insert(adminRole));
    }

    /**
     * 编辑数据
     *
     * @param adminRole 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<AdminRole> edit(AdminRole adminRole) {
        return ResponseEntity.ok(this.adminRoleService.update(adminRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.adminRoleService.deleteById(id));
    }

}

