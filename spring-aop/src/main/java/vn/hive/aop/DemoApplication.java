package vn.hive.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.hive.aop.model.Student;
import vn.hive.aop.model.Teacher;
import vn.hive.aop.service.PersonService;

public class DemoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PersonService personService = context.getBean("personService", PersonService.class);

//        System.out.println(personService.getTeacher().getName());
        Teacher teacher = context.getBean("teacher",Teacher.class);
        teacher.setName("asdas");


    }

}
