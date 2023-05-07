package game.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuTimer implements ActionListener {

    int timer;

    Timer menuTimer;
    public MenuTimer() {

        menuTimer = new Timer(1000, this);
        menuTimer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timer++;
        if(timer == 5){
            menuTimer.stop();
            timer = 0;
            System.exit(0);
        }
    }


}
