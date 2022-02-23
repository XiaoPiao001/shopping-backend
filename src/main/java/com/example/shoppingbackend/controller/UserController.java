package com.example.shoppingbackend.controller;

import com.example.shoppingbackend.entity.User;
import com.example.shoppingbackend.service.UserService;
import com.example.shoppingbackend.vo.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-12-28 15:30:28
 */
@Api(tags = {"用户"})
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<AjaxResponse> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.queryByPage(user, pageRequest)));
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @ApiOperation(value = "查询所有用户")
    @GetMapping("/all")
    public ResponseEntity<AjaxResponse> queryAll() {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.queryAll()));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条用户数据")
    @GetMapping("/queryById")
    public ResponseEntity<AjaxResponse> queryById(String id) {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.queryById(id)));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增用户数据")
    @PostMapping("/add")
    public ResponseEntity<AjaxResponse> add(User user) {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.insert(user)));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑用户数据")
    @PostMapping("/edit")
    public ResponseEntity<AjaxResponse> edit(User user) {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.update(user)));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除用户数据")
    @GetMapping("/deleteById")
    public ResponseEntity<AjaxResponse> deleteById(String id) {
        return ResponseEntity.ok(AjaxResponse.success(this.userService.deleteById(id)));
    }

}

