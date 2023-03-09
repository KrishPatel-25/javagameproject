package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class StudentController implements KeyListener {

    private boolean isJumping;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A && !character.isInAir()) {
            character.startWalking(-5);
            character.setCharacterFacing(CharacterFacing.LEFT);
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario left.png", character.getCharacterHalfHeight() *2));

        } else if (code == KeyEvent.VK_D && !character.isInAir()) {
            character.startWalking(5);
            character.setCharacterFacing(CharacterFacing.RIGHT);
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario right.png", character.getCharacterHalfHeight() *2));
        }
        else if (code == KeyEvent.VK_W){
            if(character.getSensorContacts() < 1){
                return;
            }
            character.setInAir(true);

            if(character.getCharacterFacing() == CharacterFacing.LEFT) {
                character.startWalking(-5);
                character.removeAllImages();
                character.addImage(new BodyImage("data/mario left jump.png", character.getCharacterHalfHeight() * 2));
            }

            if(character.getCharacterFacing() == CharacterFacing.RIGHT){
                character.startWalking(5);
                character.removeAllImages();
                character.addImage(new BodyImage("data/mario right jump.png", character.getCharacterHalfHeight() * 2));

            }
            character.jump(5);
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            character.startWalking(0);
        }

    }



    private Character character;

    public StudentController(Character character) {
        this.character = character;
        this.isJumping = false;


    }
}
