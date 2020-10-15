package prototype_pattern.cache;

import prototype_pattern.abtract.Circle;
import prototype_pattern.abtract.Shape;
import prototype_pattern.abtract.Triangle;

import java.util.HashMap;
import java.util.Map;

public class SetOfPrototype {
    private Map<String, Shape> cache = new HashMap<>();

    public SetOfPrototype() {
        Circle circle = new Circle();
        circle.radius = 45;
        circle.color = "Green";

        Triangle triangle = new Triangle();
        triangle.width = 8;
        triangle.height = 10;
        triangle.color = "Blue";

        cache.put("circle", circle);
        cache.put("triangle", triangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}