package proxy_pattern.virtual_proxy;

public class ImageProxy implements Image{
    private String filename;
    private ImageReal image;
    private int count;
    public ImageProxy(String filename) { this.filename = filename; }

    @Override
    public void showImage() throws InterruptedException {
        if (image == null) {
            count1;
            image = new ImageReal(filename); // load only on demand
        }
        image.showImage();
    }
}
