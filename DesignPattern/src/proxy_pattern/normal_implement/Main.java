package proxy_pattern.normal_implement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("File_Photo1"));
        images.add(new Image("File_Photo2"));
        images.add(new Image("File_photo3"));

        images.get(0).showImage();
        images.get(1).showImage();
        images.get(0).showImage();
    }
}
