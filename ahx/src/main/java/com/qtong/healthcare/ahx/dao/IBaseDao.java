package com.qtong.healthcare.ahx.dao;

import com.qtong.healthcare.ahx.model.Pager;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by ZML on 2015/4/19.
 */
public interface IBaseDao {

    public Serializable save(Object object);

    public void saveOrUpdate(Object entity);

    public void update(Object entity);

    public void merge(Object entity);

    public void deleteObject(Object entity);

    public void deleteAll(Collection<?> entities);

    public Pager<?> pagedQuery(Criteria criteria, int pageNo, int pageSize);

    public List<?> list(Criteria criteria);

    public Object get(Class clazz, Serializable id);

    public List<?> list(Object entity,String...propertyNames);


}
