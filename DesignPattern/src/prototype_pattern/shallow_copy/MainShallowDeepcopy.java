package prototype_pattern.shallow_copy;

public class MainShallowDeepcopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department department = new Department("IT", "2013");

        Employee emp = new Employee("Abc", department);
        Employee emp2 = (Employee) emp.clone();

        department.setDeptName("new dept name");

        System.out.println(emp + "\n" + emp2);

    }
}
