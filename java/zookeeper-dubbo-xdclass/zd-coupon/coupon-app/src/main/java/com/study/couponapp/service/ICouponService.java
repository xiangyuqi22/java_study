package com.study.couponapp.service;

import com.study.couponapp.domain.TCoupon;
import com.study.userserviceapi.vo.UserVO;

import java.util.List;

public interface ICouponService {

    int add(TCoupon tCoupon);

    int delete(Integer id);

    TCoupon select(Integer id);

    int update(TCoupon tCoupon);

    List<TCoupon> getCouponList();

    /**
     * 根据code码查询优惠券
     * @param code
     * @return
     */
    TCoupon findCouponByCode(String code);



}
