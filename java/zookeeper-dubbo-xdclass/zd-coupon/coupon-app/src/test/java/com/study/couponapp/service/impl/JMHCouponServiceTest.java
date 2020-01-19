package com.study.couponapp.service.impl;

import com.study.couponapp.CouponAppApplication;

import com.study.couponapp.domain.TCoupon;
import com.study.couponapp.service.ICouponService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @ClassName JMHCouponServiceTest
 * @Description: TODO  优惠券服务的jmh基准测试
 * @Author xiangning
 * @Date 2019/12/4
 * @Version V1.0
 **/
@State(Scope.Thread)
public class JMHCouponServiceTest {

    ConfigurableApplicationContext context;
    ICouponService couponService;

    public static void main(String[] args) throws RunnerException {
        Options options =
                new OptionsBuilder()
                        .include(JMHCouponServiceTest.class.getName() + "*")
                        .warmupIterations(2)            //预热次数
                        .measurementIterations(5)       //正式计量次数
                        .forks(1)                       //开启线程数
                        .build();
       new Runner(options).run();
    }

    @Setup(Level.Trial)
    public void start(){
        this.context = SpringApplication.run(CouponAppApplication.class, "");
        this.couponService = context.getBean(ICouponService.class);
    }

    @Benchmark
    public void test(){
        List<TCoupon> couponList = couponService.getCouponList();
        System.out.println(couponList);
    }

}
