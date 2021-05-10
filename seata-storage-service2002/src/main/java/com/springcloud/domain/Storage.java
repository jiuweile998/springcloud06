package com.springcloud.domain;

import lombok.Data;

/**
 * @author wlg
 * @create_time 2021-05-09 下午 23:39
 * @function
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
