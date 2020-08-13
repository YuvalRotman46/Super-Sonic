package graphics;

import java.awt.*;
import java.util.*;

import actions.SonicStanding;
import actions.SonicStarting;
import controllers.KeyboardController;
import game.*;

public class GraphicEngine extends Canvas implements Runnable{

    public Sonic sonic;
    public boolean isActive;
    private ArrayList<GameObject> gameObjects;
    private Thread engineThread;

    public static final int NANO_SEC_DELAY = 100;
    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 500;

    public GraphicEngine(){
        super();
        isActive = false;
        engineThread = new Thread(this);

        gameObjects = new ArrayList<>();
        sonic = new Sonic();
        sonic.loadNewAction(new SonicStanding(sonic));
        gameObjects.add(sonic);

        this.addKeyListener(new KeyboardController(this));

        setFocusable(true);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    /**
     *
     * @param code - nothing, have no meaning at all.
     */
    public void enable(int code) {
        isActive = true;
        engineThread.start();
    }

    public void disable(int code){

    }

    /**
     * Kind of timer tick
     */
    public void tick(){
        repaint();
        invalidate();
    }

    @Override
    public void paint(Graphics g) {
        sonic.draw(g);
        for(GameObject o : gameObjects){
            o.draw(g);
        }
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (isActive){
            if (lastTime+NANO_SEC_DELAY <= System.currentTimeMillis()){
                tick();
                lastTime = System.currentTimeMillis();
            }
        }
    }

}
