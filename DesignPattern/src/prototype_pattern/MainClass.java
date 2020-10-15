package prototype_pattern;

public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student sang = new Student("sang", "A");
        Student sangCopy = sang;
        Student sangCopy1 = (Student) sang.clone();

        sang.setName("change Sang name");

        System.out.println("" + sang + sangCopy + sangCopy1 + "");
    }
}
