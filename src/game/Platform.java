package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Platform extends StaticBody {

    private final Shape platformShape;
    private final StaticBody platform;
    private final float halfWidth;
    private final float halfHeight;


    public Platform(float halfWidth, float halfHeight, World world) {
        super(world);
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.platformShape = new BoxShape(halfWidth, halfHeight);
        this.platform = new StaticBody(world, platformShape);

    }


    public StaticBody getPlatform() {
        return platform;
    }


    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

}
