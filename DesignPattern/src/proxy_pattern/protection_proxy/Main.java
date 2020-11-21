package proxy_pattern.protection_proxy;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new ImageProxy("Protection_proxy_Photo1", "secret"));
        images.add(new ImageProxy("Protection_proxy_Photo2", "x"));
        images.add(new ImageProxy("Protection_proxy_Photo3", "szecret"));

        images.get(0).showImage(); // loading necessary
        images.get(1).showImage(); // loading necessary
        images.get(0).showImage(); // no loading necessary; already
    }
}
