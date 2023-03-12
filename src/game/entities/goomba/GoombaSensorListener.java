package game.entities.goomba;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.character.Character;
import org.jbox2d.common.Vec2;

public class GoombaSensorListener implements SensorListener {

    private Goomba goomba;

    public GoombaSensorListener(Goomba goomba) {
        this.goomba = goomba;

    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if(sensorEvent.getContactBody()instanceof Character character){
            character.applyImpulse(new Vec2(0,600));
            goomba.destroy();
            goomba.getCollisionTimer().reset();
        }


    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
