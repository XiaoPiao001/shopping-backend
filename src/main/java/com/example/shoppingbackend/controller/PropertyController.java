package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Property;
import com.example.shoppingbackend.service.PropertyService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Property)表控制层
 *
 * @author makejava
 * @since 2022-01-04 16:53:50
 */
@Api(tags = {"商品数据"})
@RestController
@RequestMapping("property")
public class PropertyController {
    /**
     * 服务对象
     */
    @Resource
    private PropertyService propertyService;

    /**
     * 分页查询
     *
     * @param property 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Property>> queryByPage(Property property, PageRequest pageRequest) {
        return ResponseEntity.ok(this.propertyService.queryByPage(property, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param property 筛选条件
     * @return 查询结果
     */
    @ApiOperation(value = "查询指定行商品数据")
    @GetMapping
    public ResponseEntity<AjaxResponse> queryAll(Property property) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.queryAll(property)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条商品数据")
    @GetMapping("{id}")
    public ResponseEntity<AjaxResponse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.queryById(id)));
    }

    /**
     * 新增数据
     *
     * @param property 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增商品数据")
    @PostMapping
    public ResponseEntity<AjaxResponse> add(Property property) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.insert(property)));
    }

    /**
     * 编辑数据
     *
     * @param property 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑商品数据")
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(Property property) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.update(property)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除商品数据")
    @PostMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.deleteById(id)));
    }

}

