package prototype_pattern.abtract;

public class Triangle extends Shape {
    public int width;
    public int height;

    public Triangle() {
    }

    public Triangle(Triangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Triangle(this);
    }
}
