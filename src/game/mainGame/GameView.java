package game.mainGame;


import city.cs.engine.UserView;
import game.UI.MenuTimer;
import game.character.Character;

import javax.swing.*;
import java.awt.*;

/**
 * @author      Krish, Patel, Krish.Patel.2@city.ac.uk
 * @version     v1
 * @since       v1
 *
 *  GameView Class includes all visual things you see when you run the game - such as hearts, coins and time but also things in the background such as the game's background
 *
 */


public class GameView extends UserView {



    private Image background;
    private final Character character;


    private Image coinSpin = new ImageIcon("data/coin spin.gif").getImage();
    private Image heart = new ImageIcon("data/heart.gif").getImage();
    private Image lostHeart = new ImageIcon("data/lost heart.gif").getImage();

    private Image gameOver = new ImageIcon("data/gameOver.gif").getImage();
    private Image winner = new ImageIcon("data/winner.gif").getImage();

    private Image rain = new ImageIcon("data/rain.gif").getImage();

    private Image timer = new ImageIcon("data/timer.png").getImage();

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.png").getImage();
        character = world.getCharacter();
    }


    @Override
    protected void paintBackground(Graphics2D g) {
//        float y = this.worldToView(this.getCentre());
        g.drawImage(background, (int) (0 - this.getCentre().x * 20), (int) (this.getCentre().y * 20 - 800), this);
//other y coordinate view (int) (this.getCentre().y)
    }

    protected void paintForeground(Graphics2D g) {

//        g.drawImage(rain, 20, 0, 50, 600, this);

        g.drawImage(coinSpin, 725, 0, 40, 40, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        g.drawString(""+ character.getCoins(), 775,28);

        g.drawImage(timer,600,0,40,40,this);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
        g.drawString(""+ GameTimer.getTimer(), 665,28);



        if (character.getLives() == 3) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(heart, 35, 0, 50, 50, this);
            g.drawImage(heart, 70, 0, 50, 50, this);

        }
        if (character.getLives() == 2) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(heart, 35, 0, 50, 50, this);
            g.drawImage(lostHeart,70, 0, 50, 50, this);

        }
        if (character.getLives() == 1) {
            g.drawImage(heart, 0, 0, 50, 50, this);
            g.drawImage(lostHeart,35, 0, 50, 50, this);
            g.drawImage(lostHeart,70, 0, 50, 50, this);

        }
        if (character.getLives() == 0){
            g.drawImage(gameOver,0,0,800,600,this);
            getWorld().stop();
            if(character.end == false){
                new MenuTimer();
                character.end = true;

            }
        }

        if(Character.getCoins() == 15){
            background = new ImageIcon("data/nightbackground.png").getImage();

        }

        if(Character.getCoins() == 30){
            g.drawImage(winner,0,0,800,600,this);
            getWorld().stop();

        }

    }
}


