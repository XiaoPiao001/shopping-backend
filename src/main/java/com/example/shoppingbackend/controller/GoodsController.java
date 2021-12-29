package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.Goods;
import com.example.shoppingbackend.service.GoodsService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2021-12-29 19:12:39
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<AjaxResponse> queryByPage(Goods goods, PageRequest pageRequest) {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.queryByPage(goods, pageRequest)));
    }

    /**
     * 查询所有数据
     *
     * @return 查询结果
     */
    @ApiOperation(value = "查询所有商品")
    @GetMapping("/all")
    public ResponseEntity<AjaxResponse> queryByPage() {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.queryAll()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条商品")
    @GetMapping("/queryById")
    public ResponseEntity<AjaxResponse> queryById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.queryById(id)));
    }

    /**
     * 新增数据
     *
     * @param goods 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增商品")
    @PostMapping
    public ResponseEntity<AjaxResponse> add(Goods goods) {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.insert(goods)));
    }

    /**
     * 编辑数据
     *
     * @param goods 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑商品")
    @PutMapping
    public ResponseEntity<AjaxResponse> edit(Goods goods) {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.update(goods)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除商品")
    @DeleteMapping
    public ResponseEntity<AjaxResponse> deleteById(Integer id) {
        return ResponseEntity.ok(AjaxResponse.success(this.goodsService.deleteById(id)));
    }

}

