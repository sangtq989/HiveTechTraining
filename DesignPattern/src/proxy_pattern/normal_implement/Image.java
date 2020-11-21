package proxy_pattern.normal_implement;

import java.util.concurrent.TimeUnit;

public class Image {
    String filePath;

    public Image(String filePath) throws InterruptedException {
        this.filePath = filePath;
        System.out.println("Loading "+ this.filePath);
        TimeUnit.SECONDS.sleep(2);
    }

    public void showImage(){
        System.out.println("Displaying "+ filePath);
    }
}
