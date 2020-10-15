package prototype_pattern.construct_problem;

public class SmarterBrain extends Brain{
    public SmarterBrain() {
        this.iq = 200;
    }

    public SmarterBrain(Brain another) {
        super(another);
    }
    public Object clone() throws CloneNotSupportedException
    {
        return new SmarterBrain(this);
//        SmarterBrain another = (SmarterBrain) super.clone();
//        return another;
    }
}
