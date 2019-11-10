package com.study.lambda;

import com.study.bean.BeanFactory;
import com.study.bean.Student;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 笔记：
 *
 * 学习地址：https://mp.weixin.qq.com/s/P_enQqAf0Jne9-Z_JHNJuA
 *
 * lambda表达式
 *      1：自己创建
 *          接口只能有一个接口方法，可以有多个默认方法
 *          抽象类可以有多个方法，但是只允许有一个抽象方法，
 *          加入@FunctionalInterface 注解，会在编译时检查该类是否符合lambda表达式的使用
 *              定义接口：
 *                          @FunctionalInterface
 *                          public interface StringAdd {
 *                               String add(String str);
 *                          }
 *               使用：
 *              StringAdd str1 = str -> str + "---> 成功了!";
 *              System.out.println(str1.add("我知道这个是对的，因为"));
 *
 *
 *
 */

public class Test {

    public static void main(String[] args) {
//        test1();
        test2();
        test3();
    }


    private static void test1(){
        Predicate<Integer> predicate = x -> x > 100;

        Student student = BeanFactory.createStudent();
        String result = predicate.test(student.getHeight()) ? "是" : "否";
        System.out.println("李白的身高是否大于100？" + result);
        Predicate<String> p1 = str ->  str.length() > 10;

        Predicate<String> p2 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

//        StringAdd str1 = str -> str + "---> 成功了!";
        StringAdd str1 = str -> {
            System.out.println("str");
            return str;
        };

        System.out.println(str1.sub("我知道这个是对的，因为"));


    }


    private static void test2() {
        Consumer<String> consumer = System.err::println;
        consumer.accept("命运由我不由天");


        //-------本质就是方法的嫁接---------------------------------------------------
        SayInterface<String> say1 =  Fun::say;
        say1.say("我命由我不由天");

        SayInterface<Integer> say2 = Fun::say;
        say2.say(999);


        SayInterface<Student> say3 = Student::say;
        Student student = BeanFactory.createStudent();
        say3.say(student);



    }

    private static void test3() {
        Student student = BeanFactory.createStudent();
        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);

//        -----------------------------------------------------------
//        FunInterface<Student,String> f1 = stu -> stu.getName() + stu.getNickname();
        FunInterface<Student,String> f1 = Student::getName;
        System.out.println(f1.trans(BeanFactory.createStudent()));
        System.out.println(f1.trans(BeanFactory.createStudent()));
        System.out.println(f1.trans(BeanFactory.createStudent()));
        System.out.println(f1.trans(BeanFactory.createStudent()));

//        ----------------------------------------------------------





        
        
    }



}
