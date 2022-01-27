package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Role;
import com.example.shoppingbackend.service.RoleService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Role>> queryByPage(Role role, PageRequest pageRequest) {
        return ResponseEntity.ok(this.roleService.queryByPage(role, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @ApiOperation("查询指定行数据")
    @GetMapping
    public ResponseEntity<AjaxResponse> queryAll(Role role) {
        return ResponseEntity.ok(AjaxResponse.success(this.roleService.queryAll(role)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Role> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.roleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param role 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<AjaxResponse> add(Role role) {
        return ResponseEntity.ok(this.roleService.insert(role));
    }

    /**
     * 编辑角色
     *
     * @param role 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑角色")
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(Role role) {
        return ResponseEntity.ok(this.roleService.update(role));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.roleService.deleteById(id)));
    }

    /**
     * 赋予管理员角色
     *
     * @param roleId
     * @param adminIdList
     * @return 删除是否成功
     */
    @ApiOperation(value = "赋予管理员角色")
    @PostMapping("/endueRole")
    public ResponseEntity<AjaxResponse> endueRole(Integer roleId,@RequestParam(value="adminIdList") List<Integer> adminIdList) {
        return ResponseEntity.ok(this.roleService.endueRole(roleId,adminIdList));
    }

    /**
     * 废除管理员角色
     *
     * @param roleId
     * @param adminIdList
     * @return 删除是否成功
     */
    @ApiOperation(value = "废除管理员角色")
    @PostMapping("/repealRole")
    public ResponseEntity<AjaxResponse> repealRole(Integer roleId,@RequestParam(value="adminIdList") List<Integer> adminIdList) {
        return ResponseEntity.ok(this.roleService.repealRole(roleId,adminIdList));
    }
}

