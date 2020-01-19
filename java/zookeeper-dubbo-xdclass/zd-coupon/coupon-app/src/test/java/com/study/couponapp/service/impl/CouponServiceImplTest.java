package com.study.couponapp.service.impl;

import com.study.couponapp.CouponAppApplication;
import com.study.couponapp.domain.TCoupon;
import com.study.couponapp.service.ICouponService;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CouponAppApplication.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class CouponServiceImplTest {

    @Autowired
    private ICouponService iCouponService;

    private static Integer id = null;

    /**
     * 批量插入数据
     */
//    @Test
    public void test0(){
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                System.out.println("创建线程" + Thread.currentThread().getName());
                for (int j = 0; j < 10; j++) {
                    TCoupon tCoupon = new TCoupon();
                    tCoupon.setCode(UUID.randomUUID().toString());
                    tCoupon.setPicUrl(UUID.randomUUID().toString() + ".jpg");
                    tCoupon.setAchieveAmount(1000);
                    tCoupon.setReduceAmount(500);
                    tCoupon.setStock(10);
                    tCoupon.setTitle("满1000减500");
                    tCoupon.setStatus(0);
                    tCoupon.setCreateTime(new Date());


                    Calendar calendar = Calendar.getInstance();

                    calendar.setTime(new Date());
                    calendar.add(Calendar.MONTH, -1);
                    tCoupon.setStartTime(calendar.getTime());

                    calendar.setTime(new Date());
                    calendar.add(Calendar.MONTH, 5);
                    tCoupon.setEndTime(calendar.getTime());

                    iCouponService.add(tCoupon);
                }
            }).start();

        }

        for (int j = 0; j < 10; j++) {
            TCoupon tCoupon = new TCoupon();
            tCoupon.setCode(UUID.randomUUID().toString());
            tCoupon.setPicUrl(UUID.randomUUID().toString() + ".jpg");
            tCoupon.setAchieveAmount(1000);
            tCoupon.setReduceAmount(500);
            tCoupon.setStock(10);
            tCoupon.setTitle("满1000减500");
            tCoupon.setStatus(0);
            tCoupon.setCreateTime(new Date());

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, -1);
            tCoupon.setStartTime(calendar.getTime());

            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, 5);
            tCoupon.setEndTime(calendar.getTime());

            iCouponService.add(tCoupon);
        }

    }



    @Test
    public void test1() {
        TCoupon tCoupon = new TCoupon();
        tCoupon.setCode(UUID.randomUUID().toString());
        tCoupon.setPicUrl(UUID.randomUUID().toString() + ".jpg");
        tCoupon.setAchieveAmount(0);
        tCoupon.setReduceAmount(0);
        tCoupon.setStock(0);
        tCoupon.setTitle("满100减10元");
        tCoupon.setStatus(0);
        tCoupon.setCreateTime(new Date());
        int result = iCouponService.add(tCoupon);
        assertEquals("新增失败",result,1);
        id = tCoupon.getId();
    }

    @Test
    public void test2() {
        TCoupon result = iCouponService.select(id);
        assertNotNull("查询对象不存在",result);
        assertEquals("查询失败",result.getId(),id);
    }

    @Test
    public void test3() {
        TCoupon tCoupon = new TCoupon();
        tCoupon.setId(id);
        tCoupon.setPicUrl("my.jpg");
        Integer result = iCouponService.update(tCoupon);
        assertEquals("更新失败",result,new Integer(1));
    }

    @Test
    public void test4() {
        int result = iCouponService.delete(id);
        assertEquals("删除失败",result,1);
    }


}