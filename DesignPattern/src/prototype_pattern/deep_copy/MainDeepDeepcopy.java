package prototype_pattern.deep_copy;

public class MainDeepDeepcopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        DepartmentDeep department = new DepartmentDeep("IT", "2013");
        EmployeeDeep emp = new EmployeeDeep("Abc", department);

        EmployeeDeep emp2 = (EmployeeDeep) emp.clone();
        department.setDeptName("new dept name");

        System.out.println(emp + "\n" + emp2);

    }
}
