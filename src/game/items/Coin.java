package game.items;

import city.cs.engine.*;
import game.character.Character;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Coin extends StaticBody {

    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("data/coinSound.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }



    public Coin(World w, Shape coinShape,Character character, float x, float y, float r) {
        super(w, coinShape);

      this.coinShape = coinShape;
      this.setPosition(new Vec2(x,y));
      this.addImage(new BodyImage("data/coin.png", r*2));
      this.addCollisionListener(new CoinCollisionDetector(this, character));



    }


    private Shape coinShape;

    @Override
    public void destroy()
    {
        coinSound.play();
        super.destroy();
    }


}
