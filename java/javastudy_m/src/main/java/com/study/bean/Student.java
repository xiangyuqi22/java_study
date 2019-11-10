package com.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    //姓名
    private String name;

    //id
    private int id;

    //年龄
    private int age;

    //绰号
    private String nickname;

    //身高
    private int height;

    //体重
    private int weight;

    //年级
    private int grade;

    //性别
    private String sex;

    //学号
    private String studentID;


    public void say(){
        System.out.println(this.toString());
    }



}
