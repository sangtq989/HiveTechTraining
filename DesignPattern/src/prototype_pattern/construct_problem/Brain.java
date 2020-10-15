package prototype_pattern.construct_problem;

public class Brain implements Cloneable {

    public int iq;

    public Brain() {
        this.iq = 100;
    }

    public Brain(Brain another) {
        this.iq = 100;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Brain(this);
        //return super.clone();
    }
}
