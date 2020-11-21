package proxy_pattern.virtual_proxy;

import java.util.concurrent.TimeUnit;

public class ImageReal implements Image {
    private String filename;
    public ImageReal(String filename) throws InterruptedException {
        this.filename = filename;
        System.out.println("Loading "+filename);
        TimeUnit.SECONDS.sleep(2);
    }
    @Override
    public void showImage() {
        System.out.println("Displaying "+filename);
    }
}
