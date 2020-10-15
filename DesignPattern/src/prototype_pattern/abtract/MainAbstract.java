package prototype_pattern.abtract;

import java.util.ArrayList;
import java.util.List;

public class MainAbstract {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Triangle triangle = new Triangle();
        triangle.width = 10;
        triangle.height = 20;
        triangle.color = "blue";
        shapes.add(triangle);
    }
}
