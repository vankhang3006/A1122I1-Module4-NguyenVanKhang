package com.codegym.ss9_book.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
    private static int count=0;

    @Before("execution(* com.codegym.ss9_book.controller.*(..))")
    public void count(){
        count++;
        System.out.println("So luong truy cap :"+ count);
    }

}
