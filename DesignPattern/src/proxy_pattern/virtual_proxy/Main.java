package proxy_pattern.virtual_proxy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Image> images = new ArrayList<>();
        images.add( new ImageProxy("Virtual_proxy_Photo1") );
        images.add( new ImageProxy("Virtual_proxy_Photo2") );
        images.add( new ImageProxy("Virtual_proxy_Photo3") );

        images.get(0).showImage(); // loading necessary
        images.get(1).showImage(); // loading necessary
        images.get(0).showImage(); // no loading necessary; already
    }
}
