package prototype_pattern;

public class Student implements Cloneable {
    private String name;
    private String clazz;
    private String gpa;

    public Student(Student student) {
        this.name = student.name;
        this.clazz = student.clazz;
        this.gpa = student.gpa;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public Student(String name, String gpa) {
        this.name = name;
        this.gpa = gpa;
        this.clazz = "Ẩn";
    }


    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}
