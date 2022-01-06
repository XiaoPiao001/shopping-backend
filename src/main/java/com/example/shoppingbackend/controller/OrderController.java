package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Order;
import com.example.shoppingbackend.service.OrderService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2022-01-04 14:56:51
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<Order>> queryByPage(Order order, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderService.queryByPage(order, pageRequest));
    }

    /**
     * 查询指定行数据
     *
     * @param order 筛选条件
     * @return 查询结果
     */
    @ApiOperation(value = "查询指定行订单")
    @GetMapping
    public ResponseEntity<AjaxResponse> queryAll(Order order) {
        return ResponseEntity.ok(AjaxResponse.success(this.orderService.queryAll(order)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条订单")
    @GetMapping("{id}")
    public ResponseEntity<AjaxResponse> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(AjaxResponse.success(this.orderService.queryById(id)));
    }

    /**
     * 新增数据
     *
     * @param order 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增订单")
    @PostMapping
    public ResponseEntity<AjaxResponse> add(Order order) {
        return ResponseEntity.ok(AjaxResponse.success(this.orderService.insert(order)));
    }

    /**
     * 编辑数据
     *
     * @param order 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑订单")
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(Order order) {
        return ResponseEntity.ok(AjaxResponse.success(this.orderService.update(order)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除订单")
    @PostMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(Long id) {
        return ResponseEntity.ok(AjaxResponse.success(this.orderService.deleteById(id)));
    }

}

