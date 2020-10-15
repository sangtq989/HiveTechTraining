package prototype_pattern.cache;

import prototype_pattern.abtract.Shape;

public class MainRegistry {
    public static void main(String[] args) {
        SetOfPrototype cache = new SetOfPrototype();
        Shape shape1 = cache.get("circle");
        Shape shape2 = cache.get("triangle");
    }
}
