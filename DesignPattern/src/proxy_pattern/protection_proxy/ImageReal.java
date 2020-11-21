package proxy_pattern.protection_proxy;

import java.util.concurrent.TimeUnit;

public class ImageReal implements Image {
    String filePath;

    public ImageReal(String filePath) throws InterruptedException {
        this.filePath = filePath;
        System.out.println("Loading " + this.filePath);
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public void showImage() {
        System.out.println("Displaying " + this.filePath);
    }

}
