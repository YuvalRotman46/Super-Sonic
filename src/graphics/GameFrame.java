package graphics;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GraphicEngine graphicEngine;

    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 500;
    public static final String GAME_FRAME_TITLE = "Sonic The Hedgehog";

    public GameFrame(){
        super();

        this.graphicEngine = new GraphicEngine();
        add(this.graphicEngine);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
