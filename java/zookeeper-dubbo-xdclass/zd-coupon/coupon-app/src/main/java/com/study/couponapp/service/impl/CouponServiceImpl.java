package com.study.couponapp.service.impl;

import com.study.couponapp.constant.Constant;
import com.study.couponapp.domain.TCoupon;
import com.study.couponapp.domain.TCouponExample;
import com.study.couponapp.mapper.TCouponMapper;
import com.study.couponapp.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName CouponServiceImpl
 * @Description: TODO
 * @Author xiangning
 * @Date 2019/12/3
 * @Version V1.0
 **/
@Service
public class CouponServiceImpl implements ICouponService {

    @Resource
    private TCouponMapper tCouponMapper;


    @Override
    public int add(TCoupon tCoupon) {
        return tCouponMapper.insertSelective(tCoupon);
//        return tCouponMapper.insert(tCoupon);
    }

    @Override
    public int delete(Integer id) {
        return tCouponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TCoupon select(Integer id) {
        return tCouponMapper.selectByPrimaryKey(id);
    }


    @Override
    public int update(TCoupon tCoupon) {
        return tCouponMapper.updateByPrimaryKeySelective(tCoupon);
    }

    @Override
    public List<TCoupon> getCouponList() {
        TCouponExample tCouponExample = new TCouponExample();
        tCouponExample.createCriteria()
                .andStatusEqualTo(Constant.USEFULL)
                .andStartTimeLessThan(new Date())
                .andEndTimeGreaterThan(new Date());
        return tCouponMapper.selectByExample(tCouponExample);
    }

    @Override
    public TCoupon findCouponByCode(String code) {
        TCouponExample tCouponExample = new TCouponExample();
        tCouponExample.createCriteria().andCodeEqualTo(code);
        List<TCoupon> tCoupons = tCouponMapper.selectByExample(tCouponExample);
        if(tCoupons.size()>0){
            return tCoupons.get(0);
        }else{
            return null;
        }
    }
}
