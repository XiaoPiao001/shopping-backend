package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.dao.PropertyDao;
import com.example.shoppingbackend.entity.Goods;
import com.example.shoppingbackend.dao.GoodsDao;
import com.example.shoppingbackend.entity.Property;
import com.example.shoppingbackend.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2021-12-29 19:13:58
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Resource
    private PropertyDao propertyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer id) {
        return this.goodsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Goods> queryByPage(Goods goods, PageRequest pageRequest) {
        long total = this.goodsDao.count(goods);
        return new PageImpl<>(this.goodsDao.queryAllByLimit(goods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        Property property = new Property();
        property.setItemId(goods.getId());
        Property updateProperty=propertyDao.queryAll(property).get(0);
        updateProperty.setName(goods.getName());
        this.propertyDao.update(updateProperty);
        this.goodsDao.update(goods);
        return this.queryById(goods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        Property property = new Property();
        property.setItemId(id);
        Integer propertyId = propertyDao.queryAll(property).get(0).getId();
        return this.goodsDao.deleteById(id) > 0 && this.propertyDao.deleteById(propertyId) > 0;
    }

    @Override
    public List<Goods> queryAll() {
        return this.goodsDao.queryAll();
    }

    @Override
    public List<Goods> queryByGoods(Goods goods) {
        return this.goodsDao.queryByGoods(goods);
    }


}
