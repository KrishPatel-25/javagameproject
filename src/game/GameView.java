package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import game.character.Character;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView{



    private final Image background;
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage();
    }



    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background,(int) (0 -  this.getCentre().x * 20), (int) this.getCentre().y, this);

    }


//    protected void updateBackground(Graphics2D g) {
//        g.drawImage(background, 0,0,this);
//
//
//    }



}


