package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
public class Character extends Walker {
    private static final Shape studentShape = new BoxShape(1,2);
    private int coins = 0;

    public int getCredits() {
        return coins;

    }

    public void setCredits(int credits) {
        this.coins = credits;
    }


    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    public Character(World world) {
        super(world, studentShape);
        addImage(image);
    }
}




