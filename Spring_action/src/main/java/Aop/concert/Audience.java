package Aop.concert;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(** Aop.concert.Performance.perform(..))")
    public void performance(){}

//    //表演之前
//    @Before("execution(** Aop.concert.Performance.perform(..))")
//    public void silenceCellPhones(){
//        System.out.println("Silencing cell phones");
//    }
//
//    //表演之前
//    @Before("performance()")
//    public void takeSeats(){
//        System.out.println("Taking seats");
//    }
//
//    //表演之后
//    @AfterReturning("performance()")
//    public void applause(){
//        System.out.println("CLAP CLAP CLAP!!!");
//    }
//
//    //表演失败之后
//    @AfterThrowing("performance()")
//    public void demandRefund(){
//        System.out.println("Demanding a refund");
//    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phones");
            System.out.println("taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }

}
