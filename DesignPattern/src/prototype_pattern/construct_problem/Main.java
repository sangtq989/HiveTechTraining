package prototype_pattern.construct_problem;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person sang = new Person(new SmarterBrain());
        Person sang1 = (Person) sang.clone();
        System.out.println(sang);
        System.out.println(sang1);
    }
}
