package vn.hive.aop.service;
import vn.hive.aop.model.Student;
import vn.hive.aop.model.Teacher;


public class PersonService {

    Student student;
    Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
