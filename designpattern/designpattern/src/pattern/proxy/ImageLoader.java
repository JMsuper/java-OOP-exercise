package pattern.proxy;

public class ImageLoader {
    private static ImageLoader instance;

    private ImageLoader(){}

    public static ImageLoader getInstance() {
        if(instance == null){
            instance = new ImageLoader();
        }
        return instance;
    }

    public ImageData load(String path){
        return new ImageData();
    }
}
