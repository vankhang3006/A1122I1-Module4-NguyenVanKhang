package com.codegym.ss7_bai2.aop;

import com.codegym.ss7_bai2.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class Logger {
    private static int count=0;

    @Before("execution(* com.codegym.ss7_bai2.controller.CommentController.*(..))")
    public void count(){
        count++;
        System.out.println("So luong truy cap :"+ count);
    }
    @AfterThrowing(pointcut = "execution(* com.codegym.ss7_bai2.controller.CommentController.save(..))",throwing = "error")
    public void loggingCreate(JoinPoint joinPoint, Throwable error){
         Object[] args = joinPoint.getArgs();
        Comment comment = (Comment) args[0];
        // ghi vào file
        System.out.println("Exception is: " + error);
        System.out.println("Tên người bình luận : " + comment.getAuthor());
        System.out.println("Nội dung bình luận : " + comment.getMessage());
        System.out.println("Thời gian bình luận : " + LocalDateTime.now());
    }
}
