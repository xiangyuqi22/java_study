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
        //根据男女进行分组
        Map<String, List<Student>> mapList = students.stream().collect(Collectors.groupingBy(student -> student.getSex()));
        mapList.forEach((key,value)->{
            System.out.println(key + "====> " + value);
        });


        //将所有人的名字进行拼接
        String nicknames = students.stream().map(student -> student.getNickname()).collect(Collectors.joining(",", "{", "}"));
        System.out.println("所有昵称：" + nicknames);

        //拼接所有女生的名字
        System.out.println("拼接所有女生的名字");
        students.stream().collect(Collectors.groupingBy(student -> student.getSex())).forEach((key,value) -> {
            System.out.println(key + "==>" + value.stream().map(student -> student.getNickname()).collect(Collectors.joining(",","{","}")));
        });

        //转换成map 并以学号为key
        System.out.println("转换成map 并以学号为key");
        Map<String, Student> toMap = students.stream().collect(Collectors.toMap(Student::getStudentID, student -> student));
        toMap.forEach((key,value) -> {
            System.out.println(key + "--> " + value);
        });

        //年龄在25岁以上的，转换成map，并以id为key
        System.out.println("年龄在25岁以上的，转换成map，并以id为key");
        Map<Integer, Student> toMap2 = students.stream().filter(student -> student.getAge() > 25).collect(Collectors.toMap(Student::getId, student -> student));
        toMap2.forEach((key,value) -> {
            System.out.println(key + "--> " + value);
        });


        Integer ageSum = students.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("所有学生的总年龄是：" + ageSum);

        /*分组统计*/
        students.stream().collect(Collectors.groupingBy(student -> {
            if(student.getHeight()>170){
                return "大于170";
            }else if(student.getHeight()>165) {
                return "大于165小于或等于170";
            }else {
                return "小于或等于165";
            }
        })).forEach((key,value) ->{
            System.out.println(key + "的学生有" + value);
        });

        System.out.println("根据性别进行分组，获取每个性别下面的平均年龄");
        students.stream().collect(Collectors.groupingBy(Student::getSex)).forEach((key,value) -> {
            System.out.println(key + "生的平均年龄是" + value.stream().collect(Collectors.averagingInt(Student::getAge)).intValue());
        });

        System.out.println("获取各性别学生年龄的平均值2");
        students.stream().collect(Collectors.groupingBy(
                Student::getSex,
                Collectors.averagingInt(Student::getAge)
        )).forEach((key,value) -> {
            System.out.println(key + "生的平均年龄是：" + value + "岁！");
        });

        System.out.println("获取各性别学生年龄的总和1");
        students.stream().collect(
                Collectors.groupingBy(Student::getSex,
                        Collectors.reducing(0, (Student student) -> student.getAge(), Integer::sum)
                )).forEach((key,value) -> {
            System.out.println(key + "生的总年龄是：" + value);
        });

        System.out.println("获取各性别学生年龄的总和2");
        students.stream().collect(
                Collectors.groupingBy(Student::getSex,
                        Collectors.summingInt(Student::getAge)
                )).forEach((key,value) -> {
            System.out.println(key + "生的总年龄是：" + value);
        });


        //创建一个list对象数据
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
            System.out.println("key -> " +key + "生有" + value.size() + "个");
        });

        System.out.print("求全班的平均身高 -- > ");
        Integer height = list.stream().collect(Collectors.averagingInt(map -> Integer.parseInt(map.get("height").toString()))).intValue();
        System.out.println(height);

        System.out.print("拼接全班人的身高 -- > ");
        String heights = list.stream().map(map -> map.get("height").toString()).collect(Collectors.joining(","));
        System.out.println(heights);

        System.out.println("list.stream().skip(4) -> 删除四个元素");
        System.out.println(list.stream().skip(4).collect(Collectors.toList()));


        System.out.print("判断所有的学生身高是否都高于165 --> ");
        boolean height1 = list.stream().allMatch(map -> Integer.parseInt(map.get("height").toString()) > 165);
        System.out.println(height1);

        System.out.print("判断是否有学生的身高矮于或等于165 --> ");
        boolean height2 = list.stream().anyMatch(map -> Integer.parseInt(map.get("height").toString()) <= 165);
        System.out.println(height2);

    }


}
