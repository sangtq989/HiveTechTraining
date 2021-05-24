package vn.hive.proxy;

public class RealClass {
    private String name;

    public RealClass() {
        this.name = "sangpd";
    }

    public String getName() {
        System.out.println("this call from real class");
        return name;
    }
}
