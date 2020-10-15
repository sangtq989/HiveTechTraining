package prototype_pattern.shallow_copy;

public class Employee {
    private String empName;
    private Department department;

    public Employee(String empName, Department dept) {
        this.empName = empName;
        this.department = dept;
    }

    public Employee(Employee employee) {
        this.empName = employee.getEmpName();
        this.department = employee.getDepartment();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    protected Object clone() {
        return new Employee(this);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "empName='" + empName + '\'' +
                ", department=" + department +
                '}';
    }
}
