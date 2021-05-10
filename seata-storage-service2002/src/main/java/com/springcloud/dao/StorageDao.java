package com.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wlg
 * @create_time 2021-05-09 下午 23:40
 * @function
 */
@Mapper
public interface StorageDao {
    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
