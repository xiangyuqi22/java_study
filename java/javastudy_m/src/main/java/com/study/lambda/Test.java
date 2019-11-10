package com.study.lambda;

import com.study.bean.BeanFactory;
import com.study.bean.Student;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * �ʼǣ�
 *
 * ѧϰ��ַ��https://mp.weixin.qq.com/s/P_enQqAf0Jne9-Z_JHNJuA
 *
 * lambda���ʽ
 *      1���Լ�����
 *          �ӿ�ֻ����һ���ӿڷ����������ж��Ĭ�Ϸ���
 *          ����������ж������������ֻ������һ�����󷽷���
 *          ����@FunctionalInterface ע�⣬���ڱ���ʱ�������Ƿ����lambda���ʽ��ʹ��
 *              ����ӿڣ�
 *                          @FunctionalInterface
 *                          public interface StringAdd {
 *                               String add(String str);
 *                          }
 *               ʹ�ã�
 *              StringAdd str1 = str -> str + "---> �ɹ���!";
 *              System.out.println(str1.add("��֪������ǶԵģ���Ϊ"));
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
        String result = predicate.test(student.getHeight()) ? "��" : "��";
        System.out.println("��׵�����Ƿ����100��" + result);
        Predicate<String> p1 = str ->  str.length() > 10;

        Predicate<String> p2 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

//        StringAdd str1 = str -> str + "---> �ɹ���!";
        StringAdd str1 = str -> {
            System.out.println("str");
            return str;
        };

        System.out.println(str1.sub("��֪������ǶԵģ���Ϊ"));


    }


    private static void test2() {
        Consumer<String> consumer = System.err::println;
        consumer.accept("�������Ҳ�����");


        //-------���ʾ��Ƿ����ļ޽�---------------------------------------------------
        SayInterface<String> say1 =  Fun::say;
        say1.say("�������Ҳ�����");

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
