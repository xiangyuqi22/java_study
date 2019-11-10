package com.study.lambda;

@FunctionalInterface
public interface StringAdd {
    String add(String str);

    default String sub(String str){
       return  this.add(str) + " ---> " + str;
    }

}
