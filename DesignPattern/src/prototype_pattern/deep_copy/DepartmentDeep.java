package prototype_pattern.deep_copy;

public class DepartmentDeep {
    public String deptName;
    public String year;

    public DepartmentDeep(String name, String year) {
        this.deptName = name;
        this.year = year;
    }

    public DepartmentDeep(DepartmentDeep department) {
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
    protected Object clone()  {
        return new DepartmentDeep(this);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
