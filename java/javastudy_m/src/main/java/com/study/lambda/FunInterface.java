package com.study.lambda;

@FunctionalInterface
public interface FunInterface<T,R> {

        R trans(T t);
        }
