package com.study.bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanFactory {

    private static int count = 0;
    private static Student student = new Student();

    static {
        student.setName("���" );
        student.setId(0 + count);
        student.setNickname("��̫��" );
        student.setHeight(175);
        student.setWeight(132);
        student.setGrade(1);
        student.setSex("��");
        student.setAge(1);
        student.setStudentID("75501");
    }

    public static Student createStudent() {
        if(count++ == 0){
            return student;
        }
        Student student1 = new Student();
        student1.setName(student.getName() + count);
        student1.setId(student.getId() + count);
        student1.setNickname(student.getNickname() + count);
        student1.setHeight(student.getHeight() + count);
        student1.setWeight(student.getWeight() + count);
        student1.setGrade(student.getGrade() + count);
        student1.setSex(count%2 == 0 ?"��" : "Ů");
        student1.setStudentID( String.valueOf(Integer.parseInt(student.getStudentID()) + count));
        student1.setAge(student.getAge() + count);


        return student1;
    }


    public static List<Student> createStudents(){
        return Stream.of(
                new Student("���",1,28,"��̫��",175,142,1,"��","tc001"),
                new Student("�Ÿ�",2,29,"ʫʥ",165,122,1,"��","tc002"),
                new Student("�ն���",3,28,"���¾�ʿ",168,112,2,"��","sc001"),
                new Student("������",4,24,"�װ���ʿ",160,99,2,"Ů","sc002"),
                new Student("������",5,12,"���ܾ�ʿ",165,92,2,"Ů","sc003")
        ).collect(Collectors.toList());
    }


}
