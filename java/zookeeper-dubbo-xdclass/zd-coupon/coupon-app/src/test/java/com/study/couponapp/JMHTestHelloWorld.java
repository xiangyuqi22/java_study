package com.study.couponapp;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JMHTestHelloWorld
 * @Description: TODO  JMH练习测试
 * @Author xiangning
 * @Date 2019/12/4
 * @Version V1.0
 **/

public class JMHTestHelloWorld {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .warmupIterations(2)  //做2轮预热
                .measurementIterations(2) //代表正式计量测试做2轮，⽽每次都是先执⾏完预热再执⾏ 正式计量，内容都是调⽤标注了 @Benchmark 的代码
                .forks(1) //做一轮测试
                .build();
        new Runner(options).run();
    }

    @Benchmark
//    @BenchmarkMode(Mode.All)
    public void testNoInitialCapacity(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }

    @Benchmark
//    @BenchmarkMode(Mode.All)
    public void testHasInitialCapacity(){
        List<Integer> list = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }
}



