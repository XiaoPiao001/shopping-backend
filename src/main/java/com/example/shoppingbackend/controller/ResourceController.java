package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Resource;
import com.example.shoppingbackend.service.ResourceService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * (Resource)表控制层
 *
 * @author makejava
 * @since 2022-01-21 16:38:01
 */
@Api(tags = {"资源"})
@RestController
@RequestMapping("resource")
public class ResourceController {
    /**
     * 服务对象
     */
    @javax.annotation.Resource
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
    public ResponseEntity<AjaxResponse> add(@RequestBody Resource resource) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.insert(resource)));
    }

    /**
     * 编辑数据
     *
     * @param resource 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(@RequestBody Resource resource) {
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
     * 通过角色查询资源
     *
     * @param roleId 角色id
     * @return 资源列表
     */
    @ApiOperation("通过角色查询资源")
    @GetMapping("/getResourceByRole")
    public ResponseEntity<AjaxResponse> getResourceByRole(Integer roleId) {
        return ResponseEntity.ok(AjaxResponse.success(this.resourceService.getResourceByRole(roleId)));
    }

    /**
     * 启用或禁用角色的资源
     *
     * @param roleId 角色ID
     * @param resourceId 资源ID
     * @param state 0禁用 1启用
     * @return 资源列表
     */
    @ApiOperation("启用或禁用角色的资源")
    @GetMapping("/roleResourceState")
    public ResponseEntity<AjaxResponse> roleResourceState(Integer roleId,Integer resourceId,Integer state) {
        return ResponseEntity.ok(this.resourceService.roleResourceState(roleId,resourceId,state));
    }
}

