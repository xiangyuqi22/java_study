package com.study.lambda;

import com.study.bean.BeanFactory;
import com.study.bean.Student;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main(String[] args) {

        groupByTest();

    }

    private static void groupByTest() {
        List<Student> students = BeanFactory.createStudents();
        //������Ů���з���
        Map<String, List<Student>> mapList = students.stream().collect(Collectors.groupingBy(student -> student.getSex()));
        mapList.forEach((key,value)->{
            System.out.println(key + "====> " + value);
        });


        //�������˵����ֽ���ƴ��
        String nicknames = students.stream().map(student -> student.getNickname()).collect(Collectors.joining(",", "{", "}"));
        System.out.println("�����ǳƣ�" + nicknames);

        //ƴ������Ů��������
        System.out.println("ƴ������Ů��������");
        students.stream().collect(Collectors.groupingBy(student -> student.getSex())).forEach((key,value) -> {
            System.out.println(key + "==>" + value.stream().map(student -> student.getNickname()).collect(Collectors.joining(",","{","}")));
        });

        //ת����map ����ѧ��Ϊkey
        System.out.println("ת����map ����ѧ��Ϊkey");
        Map<String, Student> toMap = students.stream().collect(Collectors.toMap(Student::getStudentID, student -> student));
        toMap.forEach((key,value) -> {
            System.out.println(key + "--> " + value);
        });

        //������25�����ϵģ�ת����map������idΪkey
        System.out.println("������25�����ϵģ�ת����map������idΪkey");
        Map<Integer, Student> toMap2 = students.stream().filter(student -> student.getAge() > 25).collect(Collectors.toMap(Student::getId, student -> student));
        toMap2.forEach((key,value) -> {
            System.out.println(key + "--> " + value);
        });


        Integer ageSum = students.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("����ѧ�����������ǣ�" + ageSum);

        /*����ͳ��*/
        students.stream().collect(Collectors.groupingBy(student -> {
            if(student.getHeight()>170){
                return "����170";
            }else if(student.getHeight()>165) {
                return "����165С�ڻ����170";
            }else {
                return "С�ڻ����165";
            }
        })).forEach((key,value) ->{
            System.out.println(key + "��ѧ����" + value);
        });

        System.out.println("�����Ա���з��飬��ȡÿ���Ա������ƽ������");
        students.stream().collect(Collectors.groupingBy(Student::getSex)).forEach((key,value) -> {
            System.out.println(key + "����ƽ��������" + value.stream().collect(Collectors.averagingInt(Student::getAge)).intValue());
        });

        System.out.println("��ȡ���Ա�ѧ�������ƽ��ֵ2");
        students.stream().collect(Collectors.groupingBy(
                Student::getSex,
                Collectors.averagingInt(Student::getAge)
        )).forEach((key,value) -> {
            System.out.println(key + "����ƽ�������ǣ�" + value + "�꣡");
        });

        System.out.println("��ȡ���Ա�ѧ��������ܺ�1");
        students.stream().collect(
                Collectors.groupingBy(Student::getSex,
                        Collectors.reducing(0, (Student student) -> student.getAge(), Integer::sum)
                )).forEach((key,value) -> {
            System.out.println(key + "�����������ǣ�" + value);
        });

        System.out.println("��ȡ���Ա�ѧ��������ܺ�2");
        students.stream().collect(
                Collectors.groupingBy(Student::getSex,
                        Collectors.summingInt(Student::getAge)
                )).forEach((key,value) -> {
            System.out.println(key + "�����������ǣ�" + value);
        });


        //����һ��list��������
        List<Map<String,Object>> list = new ArrayList<>();
        for (Student student:
             students) {
            Map<String,Object> map = new HashMap<>();
            map.put("name",student.getName());
            map.put("sex",student.getSex());
            map.put("age",student.getAge());
            map.put("height",student.getHeight());
            list.add(map);
        }

        Map<String, List<Map<String, Object>>> sexMap = list.stream().collect(Collectors.groupingBy(map -> map.get("sex").toString()));
        sexMap.forEach((key,value) ->{
            System.out.println("key -> " +key + "����" + value.size() + "��");
        });

        System.out.print("��ȫ���ƽ����� -- > ");
        Integer height = list.stream().collect(Collectors.averagingInt(map -> Integer.parseInt(map.get("height").toString()))).intValue();
        System.out.println(height);

        System.out.print("ƴ��ȫ���˵���� -- > ");
        String heights = list.stream().map(map -> map.get("height").toString()).collect(Collectors.joining(","));
        System.out.println(heights);

        System.out.println("list.stream().skip(4) -> ɾ���ĸ�Ԫ��");
        System.out.println(list.stream().skip(4).collect(Collectors.toList()));


        System.out.print("�ж����е�ѧ������Ƿ񶼸���165 --> ");
        boolean height1 = list.stream().allMatch(map -> Integer.parseInt(map.get("height").toString()) > 165);
        System.out.println(height1);

        System.out.print("�ж��Ƿ���ѧ������߰��ڻ����165 --> ");
        boolean height2 = list.stream().anyMatch(map -> Integer.parseInt(map.get("height").toString()) <= 165);
        System.out.println(height2);

    }


}
