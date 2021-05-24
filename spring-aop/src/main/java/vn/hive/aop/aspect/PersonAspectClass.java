package vn.hive.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import vn.hive.aop.model.Teacher;

import java.util.Arrays;


@Aspect
public class PersonAspectClass {

    //before an execution of any get method inside model package
    @Before("execution(public * vn.hive.aop.model..*(..))")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Before running loggingAdvice on method="+joinPoint.getTarget());
        System.out.println("Arguments Passed=" + Arrays.toString(joinPoint.getArgs()));
    }
//    @Pointcut("execution(public String vn.hive.aop.model..getName())")
//    public void pointCut() {
//        //Hàm này được thực hiện bất cứ khi nào hàm getName trong class  được gọi
//    }
//
//    @Pointcut("within(vn.hive.aop.model..*)")
//    public void within() {
//        //Execute whenever anything in package model is called
//    }
//
//    //    @Pointcut("this(vn.hive.aop.model..)")
////    public void thisAndTarget(){
////        //Execute whenever anything in package model is called
////    }
//    @Pointcut("args(String,..)")
//    public void argsPointcut() {
//        //Execute whenever anything has the type String passing as param
//    }
//
//    @Pointcut("@args(vn.hive.aop.aspect.TestAnnotation)")
//    public void argsAnnotation() {
//        //Execute whenever anything has the Annotation TestAnnotation
//    }
////
//    @Before("argsPointcut()")
//    public void  beforeArgPointcut(){
//        System.out.println("string arg");
//    }

//    @Before("execution(public String vn.hive.aop.model..setName(..))")
//    public void ok(JoinPoint joinPoint) {
//        joinPoint.getArgs();
//        System.out.println("after pointcut");
//    }
}
