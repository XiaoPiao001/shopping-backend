package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Resource;
import com.example.shoppingbackend.service.ResourceService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
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
    public ResponseEntity<AjaxResponse> queryAll(Resource resource) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.queryAll(resource)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<AjaxResponse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.queryById(id)));
    }

    /**
     * 新增数据
     *
     * @param resource 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<AjaxResponse> add(Resource resource) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.insert(resource)));
    }

    /**
     * 编辑数据
     *
     * @param resource 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(Resource resource) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.update(resource)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.deleteById(id)));
    }

    /**
     * 通过角色查询权益
     *
     * @param id 角色id
     * @param type 权益类型
     * @return 权益列表
     */
    @ApiOperation("通过角色查询权益")
    @GetMapping("/role")
    public ResponseEntity<AjaxResponse> getResourceByRole(@PathVariable("id") Integer id, @PathVariable("type") String type) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.getResourceByRole(id,type)));
    }
}

