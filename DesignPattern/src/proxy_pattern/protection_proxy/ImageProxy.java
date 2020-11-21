package proxy_pattern.protection_proxy;

public class ImageProxy implements Image {
    private String password;
    String filePath;
    ImageReal image;

    public ImageProxy(String filePath, String password) {
        this.password = password;
        this.filePath = filePath;
    }

    @Override
    public void showImage() throws InterruptedException {
        if (password.equals("secret")) {
            System.out.println("Access granted, file open");
            this.image = new ImageReal(filePath);
            this.image.showImage();
        } else {
            System.out.println("Ilegal password, can't show");
        }
    }
}
