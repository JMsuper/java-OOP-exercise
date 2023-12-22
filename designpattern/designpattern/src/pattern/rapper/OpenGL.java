package pattern.rapper;

public class OpenGL {
    private float r;
    private float g;
    private float b;
    private float alpha;

    public void clearScreen(float alpha, float r, float g, float b){
        this.alpha = alpha;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
