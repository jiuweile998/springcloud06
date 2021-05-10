package com.springcloud.Service;

/**
 * @author wlg
 * @create_time 2021-05-09 下午 23:43
 * @function
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
