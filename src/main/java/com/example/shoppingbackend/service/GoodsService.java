package com.example.shoppingbackend.service;

import com.example.shoppingbackend.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-12-29 19:12:39
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Goods queryById(Integer id);

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Goods> queryByPage(Goods goods, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Goods> queryAll();

    List<Goods> queryByGoods(Goods goods);
}
