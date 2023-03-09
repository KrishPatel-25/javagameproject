package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private final Image background;
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage();
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background,0,0,this);

    }

    protected void updateBackground(Graphics2D g, Character character) {
        g.drawImage(background, (int) character.getPosition().x,0,this);

    }

}
