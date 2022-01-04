package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Property;
import com.example.shoppingbackend.service.PropertyService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Property)表控制层
 *
 * @author makejava
 * @since 2021-12-31 15:44:27
 */
@RestController
@RequestMapping("property")
public class PropertyController {
    /**
     * 服务对象
     */
    @Resource
    private PropertyService propertyService;

//    /**
//     * 分页查询
//     *
//     * @param property 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<AjaxResponse> queryByPage(Property property, PageRequest pageRequest) {
//        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.queryByPage(property, pageRequest)));
//    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation(value = "查询所有商品参数")
    @GetMapping
    public ResponseEntity<AjaxResponse> queryAll() {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.queryAll()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条商品参数")
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
    @ApiOperation(value = "新增商品参数")
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
    @ApiOperation(value = "编辑商品参数")
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
    @ApiOperation(value = "删除商品参数")
    @PostMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.propertyService.deleteById(id)));
    }

}

