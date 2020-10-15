package prototype_pattern.construct_problem;

public class Person implements Cloneable {
    //Khi su dung vối 1 class co static hay final vd như khi track so doi tương duôc tao ra chang han
    //neu dung clone ma khong su dung constructor se khong the set duoc gia tri
    //giai phap la su dung clone với mot constructor protected
    //private final Brain brain;
    public Brain brain;

    public Person(Brain aBrain) {
        brain = aBrain;
    }
//Cach 1 : copy constructor
//    public Person(Person another) {
//        brain = another.brain;
//    }

    protected Person(Person another) {
        Brain refBrain = null;
        try {
            refBrain = (Brain) another.brain.clone();
        } catch (CloneNotSupportedException e) {
        }
        brain = refBrain;

    }

    public String toString() {
        return "This is person with " + brain;
        // Not meant to sound rude as it reads!
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//      Cach 1: su dụng copy constructor sẽ dẫn đến trương hợp không hiệu quả vôi cacs class kế thừa, giải pháp tạm thời là if else
        Person p = new Person(this);
        p.brain = new Brain(this.brain);
        return p;


////      Cach 2: Thay vì để persson tạo brain thì để việc tạo brain chô từng loại brain
//        Person another = (Person) super.clone();
//        another.brain = (Brain) brain.clone();
//        return another;
//      Cach 3:
  //      return new Person(this);
    }

    public Brain getBrain() {
        return brain;
    }
}
