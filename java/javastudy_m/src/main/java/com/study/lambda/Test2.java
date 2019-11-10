package com.study.lambda;

import com.study.bean.BeanFactory;
import com.study.bean.Student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {


        List<Student> students1 = Stream.of(
                new Student(),
                new Student(),
                new Student()
        ).collect(Collectors.toList());

        System.out.println(students1);

        //
        System.out.println("创建");
        Set<Student> students = Stream.of(
                BeanFactory.createStudent(),
                BeanFactory.createStudent(),
                BeanFactory.createStudent(),
                BeanFactory.createStudent(),
                BeanFactory.createStudent()
        ).collect(Collectors.toSet());

        System.out.println(students);

        System.out.println("filter过滤");
        List<Student> collect = students.stream()
                .filter(student -> student.getHeight() > 175)
                .collect(Collectors.toList());
        System.out.println(collect);

        long count = students.stream().count();
        System.out.println("计算数量：" + count);

        List<Integer> heights = students.stream().map(Student::getHeight).collect(Collectors.toList());
        System.out.println("获取所有的身高 ==> " + heights);

        List<Integer> heights2 = students.stream().map(Student::getHeight).filter(height -> height > 175).collect(Collectors.toList());
        System.out.println("身高大于175的集合 ==> " + heights2);

        System.out.println("排序");
        students.stream().sorted((s1,s2) -> s1.getHeight() - s2.getHeight()).map((stu) -> {
            System.out.println(stu);
            return stu;
        }).collect(Collectors.toList());

        System.out.println("求最大或最小值");
//        students.stream().max((s1,s2) -> s2.getHeight() - s1.getHeight()).map(stu -> {
//            System.out.println(stu);
//            return stu;
//        });


        students.stream().max(Comparator.comparing(student -> student.getHeight())).map(student -> {
            System.out.println("最高的身高 => " + student);
            return student;
        });

        students.stream().min(Comparator.comparing(student -> student.getHeight())).map(student -> {
            System.out.println("最矮的身高 => " + student);
            return student;
        });

        System.out.println(students);
        System.out.println("求身高高于177的学生");
        long count1 = students.stream().filter(student -> {
            return student.getHeight() > 177;
        }).map(student -> {
            System.out.println(student);
            return student;
        }).count();
        System.out.println("身高高于177的学生有 " + count1 + "人");

    }

}
