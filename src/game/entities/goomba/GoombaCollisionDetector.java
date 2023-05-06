package game.entities.goomba;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.character.Character;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GoombaCollisionDetector implements CollisionListener {


    private SoundClip damageSound;
    private Goomba goomba;





        @Override
        public void collide (CollisionEvent collisionEvent){
            Body body = collisionEvent.getOtherBody();
            if (body instanceof Character character && goomba.getCollisionTimer().getMilliseconds() >= 1000) {
                {
                    character.setLives(character.getLives() - 1);
                    goomba.destroy();
                    damageSound.play();


                }

            }
        }



    public GoombaCollisionDetector(Goomba goomba) {
            this.goomba = goomba;
        try {
            damageSound = new SoundClip("data/damageSound.wav");   // Open an audio input stream
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        }

    }


