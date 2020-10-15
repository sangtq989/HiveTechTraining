package prototype_pattern.deep_copy;

import prototype_pattern.shallow_copy.Department;
import prototype_pattern.shallow_copy.Employee;

public class EmployeeDeep implements Cloneable {
    private String empName;
    private DepartmentDeep department;

    public EmployeeDeep(String empName, DepartmentDeep dept) {
        this.empName = empName;
        this.department = dept;
    }

    public EmployeeDeep(EmployeeDeep employee) {
        this.empName = employee.getEmpName();
        this.department = employee.getDepartment();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public DepartmentDeep getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDeep department) {
        this.department = department;
    }

//    public Object clone()
//    {
//            Person another = (Person) super.clone();//
//            another.brain = (Brain) brain.clone();//
//            return another;
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        EmployeeDeep emp = new EmployeeDeep(this);
        emp.department = new DepartmentDeep(this.department);
        return emp;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "empName='" + empName + '\'' +
                ", department=" + department +
                '}';
    }
}
