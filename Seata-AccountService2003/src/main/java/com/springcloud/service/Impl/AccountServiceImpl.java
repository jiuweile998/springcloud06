package com.springcloud.service.Impl;

import com.springcloud.dao.AccountDao;
import com.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author wlg
 * @create_time 2021-05-10 上午 11:10
 * @function
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER =  LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        //模拟故障，暂停几秒
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }

}
