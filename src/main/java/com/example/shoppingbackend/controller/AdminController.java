package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Admin;
import com.example.shoppingbackend.service.AdminService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Api(tags = {"管理员"})
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Admin>> queryByPage(Admin admin, PageRequest pageRequest) {
        return ResponseEntity.ok(this.adminService.queryByPage(admin, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param admin 筛选条件
     * @return 查询结果
     */
    @ApiOperation(value = "查询指定行数据")
    @GetMapping
    public ResponseEntity<AjaxResponse> queryAll(Admin admin) {
        return ResponseEntity.ok(AjaxResponse.success(this.adminService.queryAll(admin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Admin> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.adminService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public ResponseEntity<Admin> add(Admin admin) {
        return ResponseEntity.ok(this.adminService.insert(admin));
    }

    /**
     * 编辑数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/edit")
    public ResponseEntity<Admin> edit(Admin admin) {
        return ResponseEntity.ok(this.adminService.update(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deleteById")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.adminService.deleteById(id));
    }

    /**
     * 登录
     * @param admin
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseEntity<AjaxResponse> queryByPage(Admin admin) {
        return ResponseEntity.ok(this.adminService.login(admin));
    }

    /**
     * 查询某角色下的管理员
     *
     * @param roleId 角色主键
     * @return
     */
    @ApiOperation(value = "查询某角色下的管理员")
    @GetMapping("/getAdminByRole")
    public ResponseEntity<AjaxResponse> getAdminByRole(Integer roleId) {
        return ResponseEntity.ok(this.adminService.getAdminByRole(roleId));
    }
}

