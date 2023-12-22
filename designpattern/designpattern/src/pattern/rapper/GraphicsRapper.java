package pattern.rapper;

public class GraphicsRapper {
    private OpenGL gl = new OpenGL();

    public void clear(float r, float g, float b, float alpha){
        gl.clearScreen(alpha,r,g,b);
    }

//    private DirectX dx = new DirectX();
//
//    public void clear(float r, float g, float b, float alpha){
//        dx.clear((int)(r * 100),(int)(g * 100),(int)(b * 100),(int)(alpha * 100));
//    }
}
