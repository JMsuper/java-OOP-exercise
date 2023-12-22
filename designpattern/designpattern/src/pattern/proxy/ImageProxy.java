package pattern.proxy;

class ImageProxy{
    private String filePath;
    private ImageData image;
    public ImageProxy(String filePath){
        this.filePath = filePath;
    }

    public void draw(Canvas canvas, float x, float y){
        // lazy loading
        if(this.image == null){
            this.image = ImageLoader.getInstance().load(this.filePath);
        }

        canvas.draw(this.image,x,y);
    }
}
