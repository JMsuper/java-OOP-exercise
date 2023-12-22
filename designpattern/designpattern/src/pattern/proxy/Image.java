package pattern.proxy;

class Image{
    private ImageData image;
    public Image(String filePath){
        // early loading
        this.image = ImageLoader.getInstance().load(filePath);
    }

    public void draw(Canvas canvas, float x, float y){
        canvas.draw(this.image,x,y);
    }
}
