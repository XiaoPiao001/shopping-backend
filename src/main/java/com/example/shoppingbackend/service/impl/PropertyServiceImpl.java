package com.example.shoppingbackend.service.impl;

import com.example.shoppingbackend.dao.GoodsDao;
import com.example.shoppingbackend.entity.Goods;
import com.example.shoppingbackend.entity.Property;
import com.example.shoppingbackend.dao.PropertyDao;
import com.example.shoppingbackend.service.PropertyService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Property)表服务实现类
 *
 * @author makejava
 * @since 2022-01-04 16:53:54
 */
@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {
    @Resource
    private PropertyDao propertyDao;
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Property queryById(Integer id) {
        return this.propertyDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param property 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Property> queryByPage(Property property, PageRequest pageRequest) {
        long total = this.propertyDao.count(property);
        return new PageImpl<>(this.propertyDao.queryAllByLimit(property, pageRequest), pageRequest, total);
    }
    
    /**
     * 查询指定行数据
     *
     * @param property 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Property> queryAll(Property property) {
        return this.propertyDao.queryAll(property);
    }

    /**
     * 新增数据
     *
     * @param property 实例对象
     * @return 实例对象
     */
    @Override
    public Property insert(Property property) {
        this.propertyDao.insert(property);
        return property;
    }

    /**
     * 修改数据
     *
     * @param property 实例对象
     * @return 实例对象
     */
    @Override
    public Property update(Property property) {
        Property updateProperty = this.propertyDao.queryById(property.getId());
        Goods goods=this.goodsDao.queryById(updateProperty.getItemId());
        goods.setName(property.getName());
        this.goodsDao.update(goods);
        this.propertyDao.update(property);
        return this.queryById(property.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        Property property=this.queryById(id);
        return this.propertyDao.deleteById(id) > 0 && goodsDao.deleteById(property.getItemId()) > 0;
    }
}
