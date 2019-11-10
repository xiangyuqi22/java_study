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

    //����
    private String name;

    //id
    private int id;

    //����
    private int age;

    //�º�
    private String nickname;

    //���
    private int height;

    //����
    private int weight;

    //�꼶
    private int grade;

    //�Ա�
    private String sex;

    //ѧ��
    private String studentID;


    public void say(){
        System.out.println(this.toString());
    }



}
