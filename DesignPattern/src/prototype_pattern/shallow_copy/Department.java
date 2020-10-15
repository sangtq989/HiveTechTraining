package prototype_pattern.shallow_copy;

public class Department {
    public String deptName;
    public String year;

    public Department(String name, String year) {
        this.deptName = name;
        this.year = year;
    }

    public Department(Department department) {
        this.year = department.year;
        this.deptName = department.deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Department(this);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
