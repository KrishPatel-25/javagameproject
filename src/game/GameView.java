package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import game.character.Character;
import game.items.Coin;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {


    private final Image background;
    private final Character character;

    private Image coin = new ImageIcon("data/coin.png").getImage();
    private Image heart = new ImageIcon("data/heart.gif").getImage();
    private Image lostHeart = new ImageIcon("data/lost heart.gif").getImage();

    private Image gameOver = new ImageIcon("data/gameover.gif").getImage();
    private Image winner = new ImageIcon("data/winner.gif").getImage();

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage();
        character = world.getCharacter();
    }


    @Override
    protected void paintBackground(Graphics2D g) {
//        float y = this.worldToView(this.getCentre());
        g.drawImage(background, (int) (0 - this.getCentre().x * 20), (int) (this.getCentre().y * 20 - 950), this);
//other y coordinate view (int) (this.getCentre().y)
    }

    protected void paintForeground(Graphics2D g) {

        g.drawImage(coin, 650, 0, 40, 40, this);
        g.drawString(""+ character.coins, 775,20);


        if (Character.lives == 3) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(heart, 35, 0, 50, 50, this);
            g.drawImage(heart, 70, 0, 50, 50, this);

        }
        if (Character.lives == 2) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(heart, 35, 0, 50, 50, this);
            g.drawImage(lostHeart,70, 0, 50, 50, this);

        }
        if (Character.lives == 1) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(lostHeart,35, 0, 50, 50, this);
            g.drawImage(lostHeart,70, 0, 50, 50, this);

        }
        if (Character.lives == 0){
            g.drawImage(gameOver,0,0,800,600,this);
            character.getWorld().stop();
        }

        if(Character.coins == 25){
            g.drawImage(winner,0,0,800,600,this);
            character.getWorld().stop();

        }


//    protected void updateBackground(Graphics2D g) {
//        g.drawImage(background, 0,0,this);
//
//
//    }


    }
}


