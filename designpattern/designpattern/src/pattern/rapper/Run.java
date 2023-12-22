package pattern.rapper;

import pattern.Runnable;

public class Run  implements Runnable {
    @Override
    public void run() {
        GraphicsRapper rapper = new GraphicsRapper();
        rapper.clear(0.3f,0.1f,0.4f,0.2f);
    }
}
