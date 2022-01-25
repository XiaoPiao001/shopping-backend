package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Resource;
import com.example.shoppingbackend.service.ResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Resource)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@RestController
@RequestMapping("resource")
public class ResourceController {
    /**
     * 服务对象
     */

    private ResourceService resourceService;

    /**
     * 分页查询
     *
     * @param resource 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Resource>> queryByPage(Resource resource, PageRequest pageRequest) {
        return ResponseEntity.ok(this.resourceService.queryByPage(resource, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param resource 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Resource>> queryAll(Resource resource) {
        return ResponseEntity.ok(this.resourceService.queryAll(resource));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Resource> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.resourceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param resource 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Resource> add(Resource resource) {
        return ResponseEntity.ok(this.resourceService.insert(resource));
    }

    /**
     * 编辑数据
     *
     * @param resource 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<Resource> edit(Resource resource) {
        return ResponseEntity.ok(this.resourceService.update(resource));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.resourceService.deleteById(id));
    }

}

