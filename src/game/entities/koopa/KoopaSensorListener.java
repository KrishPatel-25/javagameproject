package game.entities.koopa;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.character.Character;
import org.jbox2d.common.Vec2;


public class KoopaSensorListener implements SensorListener {

    private Koopa koopa;

    public KoopaSensorListener(Koopa koopa) {
        this.koopa = koopa;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {

        if(sensorEvent.getContactBody()instanceof Character character && !koopa.isInShell()){
            character.applyImpulse(new Vec2(0,600));
            koopa.setInShell(true);
            koopa.startWalking(0);
            koopa.getCollisionTimer().reset();
        }

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
