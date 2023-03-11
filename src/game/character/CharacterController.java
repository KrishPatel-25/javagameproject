package game.character;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController implements KeyListener {

   public int walkingSpeed = 5;



    private boolean isJumping;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SHIFT){
            walkingSpeed = 8;

    }

        if (code == KeyEvent.VK_A) {
            character.startWalking(-walkingSpeed);
            character.setPreviousCharacterFacing(character.getCharacterFacing());
            character.setCharacterFacing(CharacterFacing.LEFT);
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario left.png", character.getCharacterHalfHeight() *2));

        } if (code == KeyEvent.VK_D) {
            character.startWalking(walkingSpeed);
            character.setPreviousCharacterFacing(character.getCharacterFacing());
            character.setCharacterFacing(CharacterFacing.RIGHT);
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario right.png", character.getCharacterHalfHeight() *2));
        }
        if (code == KeyEvent.VK_W){
            if(character.getSensorContacts() < 1){
                return;
            }
            character.setInAir(true);
            if(character.isJumpBoost() && character.getBoostTimer().getMilliseconds()/1000 < 10){
                character.jumpingSpeed = 18;

            }
            else{ character.jumpingSpeed = character.getPreviousJumpSpeed();

            }
            character.jump(character.jumpingSpeed);

            if(character.getCharacterFacing() == null){
                character.startWalking(0);
                character.removeAllImages();
                character.addImage(new BodyImage("data/mario straight jump.png", character.getCharacterHalfHeight() * 2));
                return;

            }


            if(character.getCharacterFacing() == CharacterFacing.LEFT){
                character.startWalking(-walkingSpeed);
                character.removeAllImages();
                character.addImage(new BodyImage("data/mario left jump.png", character.getCharacterHalfHeight() * 2));
                return;
            }

            if(character.getCharacterFacing() == CharacterFacing.RIGHT) {
                character.startWalking(walkingSpeed);
                character.removeAllImages();
                character.addImage(new BodyImage("data/mario right jump.png", character.getCharacterHalfHeight() * 2));
                return;


            }


        }

        }



    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            character.startWalking(0);
            character.setPreviousCharacterFacing(character.getCharacterFacing());
            character.setCharacterFacing(null);
        }
        if(e.getKeyCode() == KeyEvent.VK_A && character.getSensorContacts() >= 1){
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario left.png", character.getCharacterHalfHeight() * 2));
        }
        if(e.getKeyCode() == KeyEvent.VK_D && character.getSensorContacts() >= 1) {
            character.removeAllImages();
            character.addImage(new BodyImage("data/mario right.png", character.getCharacterHalfHeight() * 2));
        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            walkingSpeed = 5;

        }





    }



    private Character character;

    public CharacterController(Character character) {
        this.character = character;
        this.isJumping = false;


    }
}
