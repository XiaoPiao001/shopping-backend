package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.RoleResource;
import com.example.shoppingbackend.service.RoleResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoleResource)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:02
 */
@RestController
@RequestMapping("roleResource")
public class RoleResourceController {
    /**
     * 服务对象
     */
    @Resource
    private RoleResourceService roleResourceService;

    /**
     * 分页查询
     *
     * @param roleResource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<RoleResource>> queryByPage(RoleResource roleResource, PageRequest pageRequest) {
        return ResponseEntity.ok(this.roleResourceService.queryByPage(roleResource, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param roleResource 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<RoleResource>> queryAll(RoleResource roleResource) {
        return ResponseEntity.ok(this.roleResourceService.queryAll(roleResource));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RoleResource> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.roleResourceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roleResource 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RoleResource> add(RoleResource roleResource) {
        return ResponseEntity.ok(this.roleResourceService.insert(roleResource));
    }

    /**
     * 编辑数据
     *
     * @param roleResource 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<RoleResource> edit(RoleResource roleResource) {
        return ResponseEntity.ok(this.roleResourceService.update(roleResource));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.roleResourceService.deleteById(id));
    }

}

