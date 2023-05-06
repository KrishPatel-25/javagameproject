package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.GameSaverLoader.*;

public class GameTimer implements ActionListener {


    // Variable initialisation
    public static int timer = 0;
    public static Timer gameTimer;

    // Constructor for LevelTimer
    public GameTimer() {
        if(GameSaverLoader.loadedGame){
            timer = loadedTimer;

        }


        gameTimer = new Timer(1000, this);
        gameTimer.start();
    }



    public void actionPerformed(ActionEvent e) {
        timer++;
        System.out.println(timer);

    }

    public static int getTimer() {
        return timer;
    }
}



