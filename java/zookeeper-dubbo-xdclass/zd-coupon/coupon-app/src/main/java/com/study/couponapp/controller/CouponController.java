package com.study.couponapp.controller;

import com.study.couponapp.domain.TCoupon;
import com.study.couponapp.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CouponController
 * @Description: TODO
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private ICouponService iCouponService;

    /**
     * 根据code码查询优惠券信息
     * @param code
     * @return
     */
    @RequestMapping("/find_by_code/{code}")
    public TCoupon findCouponByCode(@PathVariable("code") String code){
        return iCouponService.findCouponByCode(code);
    }


}
