package com.study.bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanFactory {

    private static int count = 0;
    private static Student student = new Student();

    static {
        student.setName("李白" );
        student.setId(0 + count);
        student.setNickname("李太白" );
        student.setHeight(175);
        student.setWeight(132);
        student.setGrade(1);
        student.setSex("男");
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
        student1.setSex(count%2 == 0 ?"男" : "女");
        student1.setStudentID( String.valueOf(Integer.parseInt(student.getStudentID()) + count));
        student1.setAge(student.getAge() + count);


        return student1;
    }


    public static List<Student> createStudents(){
        return Stream.of(
                new Student("李白",1,28,"李太白",175,142,1,"男","tc001"),
                new Student("杜甫",2,29,"诗圣",165,122,1,"男","tc002"),
                new Student("苏东坡",3,28,"东坡居士",168,112,2,"男","sc001"),
                new Student("李清照",4,24,"易安居士",160,99,2,"女","sc002"),
                new Student("朱淑真",5,12,"幽栖居士",165,92,2,"女","sc003")
        ).collect(Collectors.toList());
    }


}
