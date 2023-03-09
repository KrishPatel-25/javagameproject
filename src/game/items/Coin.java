package game.items;

import city.cs.engine.*;
import game.character.Character;
import org.jbox2d.common.Vec2;

public class Coin extends StaticBody {


    public Coin(World w, Shape coinShape,Character character, float x, float y, float r) {
        super(w, coinShape);

      this.coinShape = coinShape;
      this.setPosition(new Vec2(x,y));
      this.addImage(new BodyImage("data/coin.png", r*2));
      this.addCollisionListener(new CoinCollisionDetector(this, character));



    }

    private Shape coinShape;


}
