package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentController implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            character.startWalking(-5);
        } else if (code == KeyEvent.VK_D) {
            character.startWalking(5);
        }
        else if (code == KeyEvent.VK_W){
            character.jump(5);
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }

    private Character character;

    public StudentController(Character character) {
        this.character = character;
    }
}
