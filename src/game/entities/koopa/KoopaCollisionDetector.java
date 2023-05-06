package game.entities.koopa;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.character.Character;
import game.character.CharacterFacing;
import game.entities.goomba.Goomba;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class KoopaCollisionDetector implements CollisionListener {

    private Koopa koopa;
    private SoundClip damageSound;

    public KoopaCollisionDetector(Koopa koopa) {

        try {
            damageSound = new SoundClip("data/damageSound.wav");   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }

        this.koopa = koopa;


    }



    @Override
    public void collide(CollisionEvent collisionEvent) {
        Body body = collisionEvent.getOtherBody();

        if (body instanceof Character character && !koopa.isInShell()) {
            character.setLives(character.getLives() - 1);
            damageSound.play();
            return;




        }
        if (body instanceof Goomba goomba && koopa.isInShell()) {
            goomba.destroy();
            return;
        }
        if (body instanceof Character character && koopa.isInShell() && koopa.getCollisionTimer().getMilliseconds() < 2000) {
            koopa.startWalking(koopa.getSpeed() * 2);
            return;
        }
        koopa.setSpeed(-koopa.getSpeed());
        koopa.startWalking(koopa.getSpeed());
        koopa.setDirection(koopa.getDirection() == CharacterFacing.LEFT ? CharacterFacing.RIGHT : CharacterFacing.LEFT);


    }
}
