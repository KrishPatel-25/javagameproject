package game.mainGame;

import game.mainGame.GameSaverLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.mainGame.GameSaverLoader.*;

public class GameTimer implements ActionListener {



    public static int timer = 0;
    public static Timer gameTimer;


    public GameTimer() {
        if(GameSaverLoader.loadedGame){
            timer = loadedTimer;

        }


        gameTimer = new Timer(1000, this);
        gameTimer.start();
    }



    public void actionPerformed(ActionEvent e) {
        timer++;

//        System.out.println(timer);

    }

    public static int getTimer() {
        return timer;
    }
}



